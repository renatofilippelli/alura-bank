package br.com.alura.alurabank.repository;

import br.com.alura.alurabank.domain.ContaCorrente;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Repository
public class ContaCorrenteRepository {
    private Set<ContaCorrente> contas;

    public ContaCorrenteRepository(){
        this.contas = new HashSet<>();
    }

    public void salvar(ContaCorrente conta){
        contas.add(conta);
    }

    public boolean fechar(ContaCorrente conta){
        return contas.remove(conta);
    }
    public Optional<ContaCorrente> buscar(Integer banco, Integer agencia, Integer numero){
        return contas.stream()
                .filter(contaCorrente -> contaCorrente.existeConta(banco, agencia, numero))
                .findFirst();
    }
}
