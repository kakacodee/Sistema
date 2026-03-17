package dev.java10x.Sistema.Security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import dev.java10x.Sistema.repository.UserInterface;
import dev.java10x.Sistema.Model.User;
import java.io.IOException;
import java.time.LocalDateTime;

@Component
public class AcessConfig implements AuthenticationSuccessHandler {
    @Autowired
    private UserInterface userInterface;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse response, Authentication authentication) throws IOException {
        {
            String role = authentication.getAuthorities().iterator().next().getAuthority();
            String name;
            User user;
            switch (role) {
                case "ROLE_FORNECEDOR":
                    name = authentication.getName();
                    user = userInterface.findByEmail(name).orElseThrow(() -> new RuntimeException("User não encontrado"));
                    user.setUltimoLogin(LocalDateTime.now());
                    userInterface.save(user);
                    response.sendRedirect("/indexFornecedor");
                    break;
                case "ROLE_FUNCIONARIO":
                    name = authentication.getName();
                    user = userInterface.findByEmail(name).orElseThrow(() -> new RuntimeException("User não encontrado"));
                    user.setUltimoLogin(LocalDateTime.now());
                    userInterface.save(user);
                    response.sendRedirect("/indexFuncionario");
                    break;
                case "ROLE_GERENTE":
                    name = authentication.getName();
                    user = userInterface.findByEmail(name).orElseThrow(() -> new RuntimeException("User não encontrado"));
                    user.setUltimoLogin(LocalDateTime.now());
                    userInterface.save(user);
                    response.sendRedirect("/index");
            }
        }
    }

}
