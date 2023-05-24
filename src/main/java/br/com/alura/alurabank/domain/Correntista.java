package br.com.alura.alurabank.domain;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Correntista {
    private String cpf;
    private String nome;

    private LocalDate dataEntrada = LocalDate.now();
    public Correntista(String cpf, String nome){
        this.cpf = cpf;
        this.nome = nome;
    }
}
