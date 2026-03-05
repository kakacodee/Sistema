package dev.java10x.Sistema.repository;


import dev.java10x.Sistema.Model.FinancasFuncionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancasFuncionarioInterface extends JpaRepository<FinancasFuncionario, Long> {

}
