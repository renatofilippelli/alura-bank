package br.com.alura.alurabank.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.awt.event.ContainerAdapter;
import java.math.BigDecimal;
@Getter
public class MovimentacaoConta {
    @JsonProperty
    private ContaCorrente conta;
    @JsonProperty
    private BigDecimal valor;
    @JsonProperty
    private int operacao;

    public void executarEm(ContaCorrente conta){
        Operacao operacao = Operacao.values()[this.operacao];
        conta.executar(operacao, valor);
    }
}
