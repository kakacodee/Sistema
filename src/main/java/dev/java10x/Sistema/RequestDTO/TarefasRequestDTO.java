package dev.java10x.Sistema.RequestDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class TarefasRequestDTO {
    @Getter
    @Setter
    @NotBlank
    private String nome;
    @Getter
    @Setter
    @NotBlank
    private String descricao;
    @Getter
    @Setter
    @NotBlank
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data_inicio;
    @Getter
    @Setter
    @NotBlank
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data_fim;
}
