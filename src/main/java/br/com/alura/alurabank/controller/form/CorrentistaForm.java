package br.com.alura.alurabank.controller.form;

import br.com.alura.alurabank.domain.Correntista;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CorrentistaForm {

    static final String MESSS = "Animal, qual seu nome?";
    @JsonProperty
    @CPF(message = "CPF Invlálido")
    @NotNull
    private String cpf;
    @JsonProperty
    @NotBlank(message = MESSS)
    private String nome;

    public Correntista toCorrentista(){
        return new Correntista(cpf, nome);
    }
}
