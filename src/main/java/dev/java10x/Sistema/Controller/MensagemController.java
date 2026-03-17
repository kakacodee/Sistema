package dev.java10x.Sistema.Controller;

import dev.java10x.Sistema.Model.Mensagem;
import dev.java10x.Sistema.repository.MensagemInterface;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MensagemController {
    private final MensagemInterface mensagemInterface;
     public MensagemController(MensagemInterface mensagemInterface){
         this.mensagemInterface = mensagemInterface;
     }
    @PostMapping
    public String message(Mensagem mensagem){
        mensagemInterface.save(mensagem);

        return "redirect:/index";
    }
    @GetMapping("/index")
    public String message(){
        mensagemInterface.findAll();
        return "index";
    }
    @GetMapping("/indexFuncionario")
    public String messageFu(){
        mensagemInterface.findAll();
        return "indexFuncionario";
    }
    @GetMapping("/indexFornecedor")
    public String messageFo(){

        mensagemInterface.findAll();
        return "indexFornecedor";
    }
}
