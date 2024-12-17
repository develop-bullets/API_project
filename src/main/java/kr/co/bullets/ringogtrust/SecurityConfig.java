package kr.co.bullets.ringogtrust;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CsrfTokenRepository csrfTokenRespository() {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setHeaderName("X-CSRF-TOKEN");
        return repository;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //csrf 토큰 비활성화
        http.csrf((csrf)-> csrf.disable());

        //jwt 토큰 인증
//        http.sessionManagement((session) ->
//                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); //세션 사용하지 않음(JWT는 필요없음)

//        http.addFilterBefore(new JwtFilter(), ExceptionTranslationFilter.class);
        //csrf 토큰 활성화
//        http.csrf(csrf
//                -> csrf.csrfTokenRepository(csrfTokenRespository())
//                .ignoringRequestMatchers("/login")
//        );


        http.authorizeHttpRequests((authorize) ->
                authorize.requestMatchers("/**").permitAll()
        );

        //로그인 페이지 설정
//        http.formLogin((formLogin)
//                -> formLogin.loginPage("/login")
//                        .defaultSuccessUrl("/")
//        );

//        http.logout((logout) ->
//                logout.logoutSuccessUrl("/logout")
//        );

        return http.build();
    }
}