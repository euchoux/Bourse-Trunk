package ci.bourse.renouv.securite;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;


/**
 * @author euchoux
 */
@Component
public class JwtAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	public JwtAuthenticationSuccessHandler() {
	}

	@Override
	public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response,
			final Authentication authentication) {
		// We do not need to do anything extra on REST authentication success,
		// because there is no page to redirect to
	}
}
