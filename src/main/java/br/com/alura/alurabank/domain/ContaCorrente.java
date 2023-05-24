package br.com.alura.alurabank.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;


import java.math.BigDecimal;

@Getter
@EqualsAndHashCode
public class ContaCorrente {
    @JsonProperty
    private Integer banco;
    @JsonProperty
    private Integer agencia;
    @JsonProperty
    private Integer numero;
    @JsonProperty
    @EqualsAndHashCode.Exclude
    private BigDecimal saldo;
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    private Correntista correntista;

    public ContaCorrente(){
        this.saldo = BigDecimal.ZERO;
    }
    public ContaCorrente(Integer banco, Integer agencia, Integer numero, Correntista correntista){
        this();
        this.banco = banco;
        this.agencia = agencia;
        this.numero = numero;
        this.correntista = correntista;
    }

    public boolean existeConta(Integer banco, Integer agencia, Integer numero){
        return this.banco.equals(banco) && this.agencia.equals(agencia) && this.numero.equals(numero);
    }

    public BigDecimal lerSaldo(){
        return this.saldo;
    }

    public void executar(Operacao operacao, BigDecimal valor){
        saldo = operacao.executar(saldo, valor);
    }
}
