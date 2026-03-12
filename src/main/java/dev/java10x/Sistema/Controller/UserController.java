package dev.java10x.Sistema.Controller;


import dev.java10x.Sistema.Model.User;
import dev.java10x.Sistema.repository.UserInterface;
import dev.java10x.Sistema.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
@Controller
@RequestMapping("/Usuario")
public class UserController {
    private final UserInterface userInterface;
    private final UserService userService;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public UserController(UserInterface userInterface, UserService userService){
        this.userInterface = userInterface;
        this.userService = userService;
    }
    @GetMapping
    public String listar(Model model){
        model.addAttribute("users", userInterface.findAll());
        return "usuarios";
    }

    @PostMapping
    public String Salvar(User user){
        userService.salvarUser(user);
        return "redirect:/Usuario";
    }
    @GetMapping("/delete/{id}")
    public String Deletar(@PathVariable Long id){
        userInterface.deleteById(id);
        return "redirect:/Usuario";
        jdbcTemplate.execute("alter table financas_funcionario AUTO_INCREMENT = 1");
    }
}
