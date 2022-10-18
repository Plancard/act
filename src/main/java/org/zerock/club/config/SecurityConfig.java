
package org.zerock.club.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.zerock.club.security.filter.ApiCheckFilter;
import org.zerock.club.security.filter.ApiLoginFilter;
import org.zerock.club.security.handler.ApiLoginFailHandler;
import org.zerock.club.security.handler.ClubLoginSuccessHandler;
import org.zerock.club.security.util.JWTUtil;

// 8080, 3000 포트와 채팅 메세지를 허용
@Configuration
@Log4j2
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

                http.httpBasic().disable()
                .cors().configurationSource(corsConfigurationSource())
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/api/v1/shops/**").hasRole("OWNER")
                .antMatchers(HttpMethod.PUT, "/api/v1/users/**").hasAnyRole("USER", "OWNER")
                .antMatchers(HttpMethod.DELETE, "/api/v1/users/**").hasAnyRole("USER", "OWNER")
                .antMatchers(HttpMethod.GET, "/api/v1/users/").hasAnyRole("USER", "OWNER")
                .anyRequest().permitAll();
    }

    public CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);
        configuration.addAllowedOrigin("http://localhost:3000");
        configuration.addAllowedOrigin("http://localhost:8080/ws");
        configuration.addAllowedOrigin("http://localhost:8080/app/message");
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        configuration.addExposedHeader("X-AUTH-TOKEN");
        configuration.setAllowCredentials(false);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public ApiLoginFilter apiLoginFilter() throws Exception{

        ApiLoginFilter apiLoginFilter =  new ApiLoginFilter("/api/login", jwtUtil());
        apiLoginFilter.setAuthenticationManager(authenticationManager());

        apiLoginFilter
                .setAuthenticationFailureHandler(new ApiLoginFailHandler());

        return apiLoginFilter;
    }

    @Bean
    public JWTUtil jwtUtil() {
        return new JWTUtil();
    }

    @Bean
    public ApiCheckFilter apiCheckFilter() {

        return new ApiCheckFilter("/notes/**/*", jwtUtil());
    }



    @Bean
    public ClubLoginSuccessHandler successHandler() {
        return new ClubLoginSuccessHandler(passwordEncoder());
    }

}
