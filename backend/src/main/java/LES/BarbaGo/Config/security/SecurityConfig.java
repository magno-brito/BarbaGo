package LES.BarbaGo.Config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .cors().and()
            .csrf().disable()
            .authorizeRequests()
            .requestMatchers("/register", "/usuario").permitAll()
            .anyRequest().authenticated()
            .and()
            .httpBasic();  // Você pode mudar para formLogin() ou outra configuração de autenticação conforme necessário

        return http.build();
    }
}
