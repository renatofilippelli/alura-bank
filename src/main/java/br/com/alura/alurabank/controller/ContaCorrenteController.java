package br.com.alura.alurabank.controller;

import br.com.alura.alurabank.domain.ContaCorrente;
import br.com.alura.alurabank.domain.Correntista;
import br.com.alura.alurabank.domain.MovimentacaoConta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conta")
public class ContaCorrenteController {
    @GetMapping
    public String consultarSaldo(
            @RequestParam(name = "banco") Integer banco,
            @RequestParam(name = "agencia") Integer agencia,
            @RequestParam(name = "numero") Integer numero
    ){
        return String.format("[Banco: %s, Agência: %s, Número: %s]. Saldo: R$0.000,00",banco,agencia,numero);
    }
    @PostMapping
    public ResponseEntity<ContaCorrente> criarConta(
            @RequestBody Correntista correntista
    ){
        ContaCorrente conta = new ContaCorrente(111, 222, 333);
        return ResponseEntity.status(HttpStatus.CREATED).body(conta);
    }
    @DeleteMapping
    public String fecharConta(
            @RequestBody ContaCorrente conta
    ){
        return "Tchau conta!!";
    }

    @PutMapping
    public ResponseEntity<MovimentacaoConta> movimentarConta(
            @RequestBody MovimentacaoConta movimentacaoConta
    ){
        return ResponseEntity.ok(movimentacaoConta);
    }
}
