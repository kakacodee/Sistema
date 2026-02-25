package dev.java10x.Sistema.repository;

import dev.java10x.Sistema.Model.Conta;
import dev.java10x.Sistema.Model.Financas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaInterface extends JpaRepository<Conta, Long> {
}
