package org.bugmakers404.hermes.api.config.auth;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

  @Value("${hermes.api.key}")
  private String AUTH_TOKEN;

  @Bean
  public WebMvcConfigurer webMvcConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(@NonNull CorsRegistry registry) {
        registry.addMapping("/**").allowedOriginPatterns("*").allowedMethods("*")
            .allowedHeaders("*").allowCredentials(true);
      }
    };
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    http.authorizeHttpRequests(
            authorize -> authorize.requestMatchers("/swagger-ui/**", "/v3/api-docs/**",
                "/swagger-ui.html", "/").permitAll().anyRequest().authenticated())
        .addFilterBefore(authenticationFilter(), UsernamePasswordAuthenticationFilter.class)
        .cors(Customizer.withDefaults());

    return http.build();
  }

  @Bean
  public OncePerRequestFilter authenticationFilter() {
    return new OncePerRequestFilter() {
      @Override
      protected void doFilterInternal(@NonNull HttpServletRequest request,
          @NonNull HttpServletResponse response, @NonNull FilterChain filterChain)
          throws ServletException, IOException {
        String authToken = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (AUTH_TOKEN.equals(authToken)) {
          SecurityContextHolder.getContext().setAuthentication(
              new UsernamePasswordAuthenticationToken("user", null, new ArrayList<>()));
        }

        filterChain.doFilter(request, response);
      }
    };
  }

}