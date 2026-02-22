package dev.java10x.Sistema.repository;

import dev.java10x.Sistema.Model.Financas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface FinancasInterface extends JpaRepository<Financas, Long> {

}
