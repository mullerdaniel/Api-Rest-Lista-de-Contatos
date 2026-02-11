package com.listadecontatos.crud.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class telefoneDTO {

    @NotBlank(message = "O nome não pode ficar vazio")
    private String nome;

    @NotBlank(message = "O número não pode ficar vazio")
    @Pattern(regexp = "\\d{8,11}", message = "O número deve ter entre 8 e 11 dígitos")
    private String numero;

    // Construtor padrão obrigatório para frameworks como Jackson
    public telefoneDTO() {}

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
