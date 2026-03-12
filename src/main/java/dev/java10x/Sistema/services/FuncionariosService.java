package dev.java10x.Sistema.services;

import dev.java10x.Sistema.Model.Funcionarios;
import dev.java10x.Sistema.Model.Tarefas;
import dev.java10x.Sistema.repository.FuncionariosInterface;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FuncionariosService {
    private final FuncionariosInterface funcionariosInterface;
    public FuncionariosService(FuncionariosInterface funcionariosInterface){
        this.funcionariosInterface = funcionariosInterface;
    }
    public void SalvarFuncionarios(Funcionarios funcionarios){

        funcionariosInterface.save(funcionarios);

    }
    @Transactional
    public void DeleteFuncionarios(Long id){

        funcionariosInterface.deleteById(id);
    }
    @Transactional
    public void DeleteTodosFuncionarios(){

        funcionariosInterface.deleteAll();
    }

}
