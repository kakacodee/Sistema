package dev.java10x.Sistema.repository;

import dev.java10x.Sistema.Model.Funcionarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionariosInterface extends JpaRepository<Funcionarios, Long> {
}
