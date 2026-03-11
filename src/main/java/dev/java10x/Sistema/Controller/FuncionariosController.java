package dev.java10x.Sistema.Controller;

import dev.java10x.Sistema.Model.Conta;
import dev.java10x.Sistema.Model.Financas;
import dev.java10x.Sistema.Model.Funcionarios;
import dev.java10x.Sistema.Model.Tarefas;
import dev.java10x.Sistema.repository.FuncionariosInterface;
import dev.java10x.Sistema.services.FinancasService;
import dev.java10x.Sistema.services.FuncionariosService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Funcionarios")
public class FuncionariosController {
    private final FuncionariosInterface funcionariosInterface;
    private final FuncionariosService funcionariosService;
    private final FinancasService financasService;
    public FuncionariosController(FuncionariosInterface funcionariosInterface, FuncionariosService funcionariosService, FinancasService financasService){
        this.funcionariosInterface = funcionariosInterface;
        this.funcionariosService = funcionariosService;
        this.financasService = financasService;
    }
    @PostMapping
    public String salvar(Financas financas, Funcionarios funcionarios, Conta conta){
        funcionariosService.SalvarFuncionarios(funcionarios);

        financasService.AdicionarSalarioFuncionario(financas, funcionarios);
        return "redirect:/Funcionarios";
    }
    @GetMapping
    public String listar(Model model){
        model.addAttribute("funcionarios", funcionariosInterface.findAll());
        return "funcionarios";
    }
    @GetMapping("/delete/{id}")
    public String Deletar(@PathVariable Long id){
        funcionariosService.DeleteFuncionarios(id);
        return "redirect:/Funcionarios";
    }
    @GetMapping("/deleteall")
    public String DeletarTudo(){
        funcionariosService.DeleteTodosFuncionarios();
        return "redirect:/Funcionarios";
    }
}
