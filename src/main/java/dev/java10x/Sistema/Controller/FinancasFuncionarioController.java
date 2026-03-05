package dev.java10x.Sistema.Controller;
import dev.java10x.Sistema.Model.Financas;
import dev.java10x.Sistema.Model.FinancasFuncionario;
import dev.java10x.Sistema.repository.ContaFuncionarioInterface;
import dev.java10x.Sistema.repository.ContaInterface;
import dev.java10x.Sistema.repository.FinancasFuncionarioInterface;
import dev.java10x.Sistema.repository.FinancasInterface;
import dev.java10x.Sistema.services.FinancasFuncionarioService;
import dev.java10x.Sistema.services.FinancasService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

@Controller
@RequestMapping("/FinancasFuncionario")
public class FinancasFuncionarioController {
    private final FinancasFuncionarioInterface financasFuncionarioInterface;
    private final FinancasFuncionarioService financasFuncionarioService;
    private final ContaFuncionarioInterface contaFuncionarioInterface;
    public FinancasFuncionarioController(FinancasFuncionarioService financasFuncionarioService, FinancasFuncionarioInterface financasFuncionarioInterface, ContaFuncionarioInterface contaFuncionarioInterface){
        this.financasFuncionarioService = financasFuncionarioService;
        this.financasFuncionarioInterface = financasFuncionarioInterface;
        this.contaFuncionarioInterface = contaFuncionarioInterface;

    }
    @GetMapping
    public String listar(Model model){
        model.addAttribute("financasFuncionario", financasFuncionarioInterface.findAll());
        BigDecimal resultado = financasFuncionarioService.obterOuCriarConta().getTotal();

        model.addAttribute("resultado", resultado);
        return "financasFuncionario";
    }


    @PostMapping
    public String Salvar(FinancasFuncionario financasFuncionario){
financasFuncionarioService.salvarTransacao(financasFuncionario);
        return "redirect:/FinancasFuncionario";
    }
    @GetMapping("/delete/{id}")
    public String Deletar(@PathVariable Long id){
        financasFuncionarioService.deletar(id);
        return "redirect:/FinancasFuncionario";
    }
    @GetMapping("/deleteall")
    public String DeletarTudo(){
        financasFuncionarioService.ApagarTudo();
        return "redirect:/FinancasFuncionario";
    }
}

