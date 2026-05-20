package dev.java10x.Sistema.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final AcessConfig acessConfig;
    public SecurityConfig(AcessConfig acessConfig){
        this.acessConfig = acessConfig;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/", "/telaCliente", "/cadastro").permitAll()
                    .requestMatchers("/indexFornecedor").hasRole("FORNECEDOR")
                    .requestMatchers("/indexFuncionario").hasRole("FUNCIONARIO")
                    .requestMatchers("/index").hasRole("GERENTE")
                    .anyRequest().authenticated()
                )
                .formLogin(form -> form
                    .loginPage("/login")
                        .defaultSuccessUrl("/telaCliente", true)
                    .successHandler(acessConfig)
                    .permitAll()
                )
                    .logout(logout  -> logout.permitAll());
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }
}
