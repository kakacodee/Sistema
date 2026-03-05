package dev.java10x.Sistema.Controller;

import dev.java10x.Sistema.repository.FinancasInterface;
import jakarta.persistence.Index;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class InitialController {
    @GetMapping("/index")
    public String welcome(){

        return "index";
    }
    @GetMapping("/indexFuncionario")
    public String welcomeFu(){

        return "indexFuncionario";
    }
    @GetMapping("/indexFornecedor")
    public String welcomeFo(){

        return "indexFornecedor";
    }
}
