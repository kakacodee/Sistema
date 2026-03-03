package dev.java10x.Sistema.Controller;

import dev.java10x.Sistema.repository.FinancasInterface;
import jakarta.persistence.Index;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class InitialController {
    @GetMapping
    public String welcome(){
        return "index";
    }
}
