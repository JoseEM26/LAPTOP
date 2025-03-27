package SpringSecurity_lll.Security_lll.Security;

import SpringSecurity_lll.Security_lll.Security.Auth.JwtAuthenticationFilter;
import SpringSecurity_lll.Security_lll.Security.Auth.JwtAuthorizationFilter;
import SpringSecurity_lll.Security_lll.Security.JWT.JwtUtils;
import SpringSecurity_lll.Security_lll.Service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

@Configuration
public class SecurityConfig {


    @Bean
    public JwtAuthorizationFilter jwtAuthorizationFilter() {
        return new JwtAuthorizationFilter(jwtUtils, userDetailsService);
    }

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    JwtUtils jwtUtils;

    @Bean
    public JwtAuthenticationFilter jwtAuthFilter() {
        JwtAuthenticationFilter jwtAuthFilter = new JwtAuthenticationFilter(jwtUtils);
        jwtAuthFilter.setAuthenticationManager(authenticationManager());  // 🔹 Asigna AuthenticationManager
        return jwtAuthFilter;    }


    @Bean
     SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity , AuthenticationManager authenticationManager) throws Exception {

        return httpSecurity
                .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {authorizationManagerRequestMatcherRegistry
                        .requestMatchers("/hello" ,"/createUser").permitAll()
                        .anyRequest().authenticated();
                })
                .sessionManagement(httpSecuritySessionManagementConfigurer -> {httpSecuritySessionManagementConfigurer
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                })
                //.httpBasic(Customizer.withDefaults())
                //.addFilter(jwtAuthFilter)
                .addFilter(jwtAuthFilter())
                .addFilterBefore(jwtAuthorizationFilter() ,UsernamePasswordAuthenticationFilter.class  )
                .build();
    }

    @Bean
     PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }



     @Bean
     AuthenticationManager authenticationManager(){
        DaoAuthenticationProvider daoAuthenticationProvider= new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return new ProviderManager(List.of(daoAuthenticationProvider));
    }


}


//ESTO SOLO ME SIRVE PARA PODER INGRESAR UN USUARIO EN MEMORIA
//@Bean
// UserDetailsService userDetailsService(){
//    InMemoryUserDetailsManager manager=new InMemoryUserDetailsManager();
//    manager.createUser(User.withUsername("jose")
//            .password(passwordEncoder().encode("123"))
//            .roles()
//           .build());

//      return  manager;
// }
