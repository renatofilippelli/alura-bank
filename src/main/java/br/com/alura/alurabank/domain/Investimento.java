package br.com.alura.alurabank.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.math.BigDecimal;
@Getter
public class Investimento {
    @JsonProperty
    String nome;
    @JsonProperty
    BigDecimal rendimento;

    public Investimento(String nome, BigDecimal rendimento){
        this.nome = nome;
        this.rendimento = rendimento;
    }

    public BigDecimal render(BigDecimal valorEntrada, Investimento investimento){
        return valorEntrada.add(
                investimento.rendimento
                        .multiply(valorEntrada)
                        .divide(BigDecimal.valueOf(100)));
    }
}
