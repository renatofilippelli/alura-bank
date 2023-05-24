package br.com.alura.alurabank.controller.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaCorrenteForm {

    @JsonProperty
    private Integer banco;
    @JsonProperty
    private Integer agencia;
    @JsonProperty
    private Integer numero;
}
