package com.example.ssogithub.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ProjectConfig {
    @Value("${sso.github.client.id}")
    private String clientId;

    @Value("${sso.github.client.secret}")
    private String clientSecret;

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        //http.oauth2Login();
        http.oauth2Login(c -> c.clientRegistrationRepository(clientRegistrationRepository()));

        http.authorizeHttpRequests(
                authz -> authz.anyRequest().authenticated()
        );
        return http.build();
    }

    private ClientRegistration clientRegistration(){
        return CommonOAuth2Provider.GITHUB.getBuilder("github")
                .clientId(clientId)
                .clientSecret(clientSecret)
                .build();
    }
    @Bean
    public ClientRegistrationRepository clientRegistrationRepository(){
        var c = clientRegistration();
        return new InMemoryClientRegistrationRepository(c);
    }
}
