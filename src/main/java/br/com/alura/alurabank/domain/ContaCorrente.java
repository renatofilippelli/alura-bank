package br.com.alura.alurabank.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ContaCorrente {
    @JsonProperty
    private Integer banco;
    @JsonProperty
    private Integer agencia;
    @JsonProperty
    private Integer numero;

    public ContaCorrente(Integer banco, Integer agencia, Integer numero){
        this.banco = banco;
        this.agencia = agencia;
        this.numero = numero;
    }
}
