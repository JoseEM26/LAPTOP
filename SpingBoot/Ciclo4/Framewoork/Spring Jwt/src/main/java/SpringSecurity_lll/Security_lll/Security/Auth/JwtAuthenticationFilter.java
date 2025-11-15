    package SpringSecurity_lll.Security_lll.Security.Auth;

    import SpringSecurity_lll.Security_lll.Model.UserEntity;
    import SpringSecurity_lll.Security_lll.Security.JWT.JwtUtils;
    import com.fasterxml.jackson.databind.ObjectMapper;
    import jakarta.servlet.FilterChain;
    import jakarta.servlet.ServletException;
    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpServletResponse;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.MediaType;
    import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
    import org.springframework.security.core.Authentication;
    import org.springframework.security.core.AuthenticationException;
    import org.springframework.security.core.userdetails.UserDetails;
    import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

    import java.io.IOException;
    import java.util.HashMap;
    import java.util.Map;

////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////Valida si el correo o el usuario es correcto////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////

    public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

        public JwtAuthenticationFilter(JwtUtils jwtUtils) {
            this.jwtUtils=jwtUtils;
        }

        private final JwtUtils jwtUtils;


        //Recibimos lo que es la peticion con el usuario y password y lo authenticamos
        @Override
        public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
            try {
                UserEntity user = new ObjectMapper().readValue(request.getInputStream(), UserEntity.class);

                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());

                return getAuthenticationManager().authenticate(authenticationToken);

            } catch (IOException e) {
                throw new RuntimeException("Error al leer los datos de autenticación", e);
            }
        }

        //Despues de validar solo enviamos una mensaje httpResponse
        //Dspues de validar y ingresar el usuario , creamos el token
        @Override
        protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
            UserDetails user = (UserDetails) authResult.getPrincipal();
            String token = jwtUtils.GenerateAccessToken(user.getUsername());

            response.addHeader("Authorization", "Bearer " + token);
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setStatus(HttpStatus.OK.value());

            Map<String, Object> httpResponse = new HashMap<>();
            httpResponse.put("token", token);
            httpResponse.put("message", "Authentication Successful");
            httpResponse.put("username", user.getUsername());

            response.getWriter().write(new ObjectMapper().writeValueAsString(httpResponse));
            response.getWriter().flush();
        }
    }
