package dev.java10x.Sistema.repository;

import dev.java10x.Sistema.Model.Conta;
import dev.java10x.Sistema.Model.ContaFuncionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaFuncionarioInterface extends JpaRepository<ContaFuncionario, Long> {

}
