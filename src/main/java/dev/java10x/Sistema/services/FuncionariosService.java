package dev.java10x.Sistema.services;

import dev.java10x.Sistema.Model.Funcionarios;
import dev.java10x.Sistema.Model.Tarefas;
import dev.java10x.Sistema.repository.FuncionariosInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
@Service
public class FuncionariosService {
    private final FuncionariosInterface funcionariosInterface;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public FuncionariosService(FuncionariosInterface funcionariosInterface){
        this.funcionariosInterface = funcionariosInterface;
    }
    public void SalvarFuncionarios(Funcionarios funcionarios){

        funcionariosInterface.save(funcionarios);

    }
    @Transactional
    public void DeleteFuncionarios(Long id){

        funcionariosInterface.deleteById(id);
        jdbcTemplate.execute("alter table financas_funcionario AUTO_INCREMENT = 1");
    }
    @Transactional
    public void DeleteTodosFuncionarios(){

        funcionariosInterface.deleteAll();
        jdbcTemplate.execute("alter table financas_funcionario AUTO_INCREMENT = 1");
    }

}
