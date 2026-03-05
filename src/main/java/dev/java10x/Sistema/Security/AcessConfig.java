package dev.java10x.Sistema.Security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AcessConfig implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse response, Authentication authentication) throws IOException {
        {
            String role = authentication.getAuthorities().iterator().next().getAuthority();
            switch (role) {
                case "ROLE_FORNECEDOR":
                    response.sendRedirect("/indexFornecedor");
                    break;
                case "ROLE_FUNCIONARIO":
                    response.sendRedirect("/indexFuncionario");
                    break;
                case "ROLE_GERENTE":
                    response.sendRedirect("/index");
            }
        }
    }
}
