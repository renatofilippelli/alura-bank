package br.com.alura.alurabank.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Correntista {
    private String cpf;
    private String nome;
    @JsonIgnore
    private LocalDate dataEntrada = LocalDate.now();
    public Correntista(String cpf, String nome){
        this.cpf = cpf;
        this.nome = nome;
    }
}
