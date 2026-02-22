package dev.java10x.Sistema.Controller;


import dev.java10x.Sistema.Model.User;
import dev.java10x.Sistema.repository.UserInterface;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Usuario")
public class UserController {
    private final UserInterface userInterface;
    public UserController(UserInterface userInterface){
        this.userInterface = userInterface;
    }
    @GetMapping
    public String listar(Model model){
        model.addAttribute("users", userInterface.findAll());
        return "usuarios";
    }
    @PostMapping
    public String Salvar(User user){
        userInterface.save(user);
        return "redirect:/Usuario";
    }
    @GetMapping("/delete/{id}")
    public String Deletar(@PathVariable Long id){
        userInterface.deleteById(id);
        return "redirect:/Usuario";
    }
}
