/**
 * 
 */
package ci.bourse.renouv.securite;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

import com.auth0.jwt.exceptions.InvalidClaimException;

import ci.bourse.renouv.constant.BourseConstant;
import ci.bourse.renouv.dto.UtilisateurDtoLight;
import ci.bourse.renouv.facade.UtilisateurFacade;
import ci.bourse.renouv.utils.TokenUtils;

/**
 * @author euchoux
 */
@Component
public class JwtAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

	@Autowired
	private UtilisateurFacade utilisateurFacade;

	public JwtAuthenticationFilter() {
		super("/**");
	}

	/**
	 * @param defaultFilterProcessesUrl
	 */
	public JwtAuthenticationFilter(final String defaultFilterProcessesUrl) {
		super(defaultFilterProcessesUrl);
	}

	/**
	 * @param requiresAuthenticationRequestMatcher
	 */
	public JwtAuthenticationFilter(final RequestMatcher requiresAuthenticationRequestMatcher) {
		super(requiresAuthenticationRequestMatcher);
	}

	@Override
	protected boolean requiresAuthentication(final HttpServletRequest request, final HttpServletResponse response) {
		return true;
	}

	@Override
	public Authentication attemptAuthentication(final HttpServletRequest request, final HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {

		final String header = request.getHeader(BourseConstant.AUTHORIZATION_PROPERTY);

		if (header == null || !header.startsWith(BourseConstant.AUTHENTICATION_SCHEME)) {
			throw new AuthenticationServiceException("Aucun jeton trouvé dans l'entête de la requête.");
		}

		final String token = header.substring(BourseConstant.AUTHENTICATION_SCHEME.length());

		UtilisateurDtoLight user;
		try {
			user = TokenUtils.verifierToken(token);
		} catch (final Exception e) {

			if (e instanceof InvalidClaimException) {
				response.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
			} else {
				response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE, e.getMessage());
			}

			return null;
		}

		// Vérification de la conformité du jeton avec le dernier jeton actif de
		// l'utilisateur.
		final boolean tokenOk = utilisateurFacade.verifierToken(user.getId(),
				user.getNom(), token);
		if (!tokenOk) {
			response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE,
					"Le jeton fourni n'est plus actif.");
		}

		final UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken("ANONYME_KEY",
				"ANONYME", AuthorityUtils.createAuthorityList(user.getUserProfil().name()));

		final Authentication auth = getAuthenticationManager().authenticate(authRequest);
		SecurityContextHolder.getContext().setAuthentication(auth);

		return auth;
	}

	@Override
	protected void successfulAuthentication(final HttpServletRequest request, final HttpServletResponse response,
			final FilterChain chain, final Authentication authResult) throws IOException, ServletException {
		super.successfulAuthentication(request, response, chain, authResult);

		// As this authentication is in HTTP header, after success we need to
		// continue the request normally and return the response as if the
		// resource was not secured at all
		chain.doFilter(request, response);
	}

}
