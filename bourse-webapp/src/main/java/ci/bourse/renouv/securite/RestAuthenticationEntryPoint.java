/**
 * 
 */
package ci.bourse.renouv.securite;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * @author euchoux
 *
 */
@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

	/**
	 * 
	 */
	public RestAuthenticationEntryPoint() {
	}

	@Override
	public void commence(final HttpServletRequest request, final HttpServletResponse response,
			final AuthenticationException authException) throws IOException, ServletException {
		// super.commence(request, response, authException);
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
	}

}
