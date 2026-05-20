package dev.java10x.Sistema.Controller;

import dev.java10x.Sistema.Model.Papel;
import dev.java10x.Sistema.Model.User;
import dev.java10x.Sistema.repository.UserInterface;
import dev.java10x.Sistema.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    private final UserService userService;
    public LoginController(UserService userService){
        this.userService = userService;

    }
    @GetMapping("/login")
    public String Login(){

        return "login";
    }
    @GetMapping("/cadastro")
    public String cadastroForm() {
        return "Cadastro"; //
    }

    @PostMapping("/cadastro")
    public String cadastrar(@ModelAttribute User usuario) {
        userService.salvarUser(usuario);
        return "redirect:/telaCliente";
    }

}
