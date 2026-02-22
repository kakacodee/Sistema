package dev.java10x.Sistema.RequestDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

public class UserRequestDTO {
    @Setter
    @Getter
    @NotBlank
    private String nome;
    @Setter
    @Getter
    @NotBlank

    private String senha;
    @Setter
    @Getter
    @NotBlank
    @Email
    private String email;
}
