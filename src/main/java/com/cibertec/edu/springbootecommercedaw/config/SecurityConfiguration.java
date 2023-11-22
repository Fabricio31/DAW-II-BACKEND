package com.cibertec.edu.springbootecommercedaw.config;

import com.okta.spring.boot.oauth.Okta;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;

@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        // proteger endpoint /api/orders
        http.authorizeHttpRequests(configurer->
                        configurer.requestMatchers("/api/orders/**")
                                .authenticated()
                                .anyRequest().permitAll())
                .oauth2ResourceServer((oauth2) -> oauth2
                        .jwt(Customizer.withDefaults()));

        // añadir filtros CORS
        http.cors(Customizer.withDefaults());

        // añadir estrategia de negociación de contenidos
        http.setSharedObject(ContentNegotiationStrategy.class,
                new HeaderContentNegotiationStrategy());

        // forzar un cuerpo de respuesta no vacío para 401's para hacer la respuesta más amigable
        Okta.configureResourceServer401ResponseBody(http);

        //desactivar CSRF ya que no estamos utilizando cookies para el seguimiento de la sesión
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}