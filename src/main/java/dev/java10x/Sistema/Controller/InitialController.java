package dev.java10x.Sistema.Controller;

import dev.java10x.Sistema.Model.Mensagem;
import dev.java10x.Sistema.Model.MensagemDTO;
import dev.java10x.Sistema.Model.Papel;
import dev.java10x.Sistema.repository.FinancasInterface;
import dev.java10x.Sistema.repository.MensagemInterface;
import dev.java10x.Sistema.repository.Produtointerface;
import dev.java10x.Sistema.services.MensagemService;
import jakarta.persistence.Index;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class InitialController {
    private final MensagemInterface mensagemInterface;
    private final MensagemService mensagemService;
    private final Produtointerface produtointerface;
    public InitialController(MensagemInterface mensagemInterface, MensagemService mensagemService, Produtointerface produtointerface){
        this.mensagemInterface = mensagemInterface;
        this.mensagemService = mensagemService;
        this.produtointerface = produtointerface;
    }
    @GetMapping("/")
    public String Cliente(Model model){
        model.addAttribute("produtos", produtointerface.findAll());
        return "telaCliente";
    }
    @GetMapping("/index")
    public String welcome(Model model){

        model.addAttribute("mensagemGerente", mensagemService.filtrarMensagens(Papel.GERENTE));


        return "index";
    }
    @PostMapping("/index")
    public String messageGe(@ModelAttribute MensagemDTO dto){
        mensagemService.Mensagens(new Mensagem(dto.getPapel(), dto.getMensagem()));

        return "redirect:/index";
    }
    @GetMapping("/indexFuncionario")
    public String welcomeFu(Model model){
        model.addAttribute("mensagemFuncionario", mensagemService.filtrarMensagens(Papel.FUNCIONARIO));
        return "indexFuncionario";
    }
    @PostMapping("/indexFuncionario")
    public String messageFu(@ModelAttribute MensagemDTO dto){
        mensagemService.Mensagens(new Mensagem(dto.getPapel(), dto.getMensagem()));

        return "redirect:/indexFuncionario";
    }
    @GetMapping("/indexFornecedor")
    public String welcomeFo(Model model){
        model.addAttribute("mensagemFornecedor", mensagemService.filtrarMensagens(Papel.FORNECEDOR));
        return "indexFornecedor";
    }
    @PostMapping("/indexFornecedor")
    public String messageFo(@ModelAttribute MensagemDTO dto){
        mensagemService.Mensagens(new Mensagem(dto.getPapel(), dto.getMensagem()));

        return "redirect:/indexFornecedor";
    }
}
/*
* @GetMapping("/mensagem/delete/{id}")
    public String deletarMensagem(@PathVariable Long id) {
        mensagemInterface.deleteById(id);
        return "redirect:/indexFuncionario"; // ou /index, /indexFornecedor dependendo da página
    }
* */