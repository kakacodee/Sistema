package dev.java10x.Sistema.interfaces;

import dev.java10x.Sistema.Model.Financas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancasInterface extends JpaRepository<Financas, Long> {
}
