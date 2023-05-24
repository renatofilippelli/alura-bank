package br.com.alura.alurabank.controller;

import br.com.alura.alurabank.controller.form.CorrentistaForm;
import br.com.alura.alurabank.domain.ContaCorrente;
import br.com.alura.alurabank.domain.Correntista;
import br.com.alura.alurabank.domain.MovimentacaoConta;
import br.com.alura.alurabank.repository.ContaCorrenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    private ContaCorrenteRepository contaCorrenteRepository;

    @GetMapping
    public String consultarSaldo(
            @RequestParam(name = "banco") Integer banco,
            @RequestParam(name = "agencia") Integer agencia,
            @RequestParam(name = "numero") Integer numero
    ){

        ContaCorrente contaCorrente = contaCorrenteRepository.buscar(banco, agencia, numero)
                .orElse(new ContaCorrente());

        return String.format("[Banco: %s, Agência: %s, Número: %s]. Saldo: %s"
                , contaCorrente.getBanco(), contaCorrente.getAgencia()
                , contaCorrente.getNumero(), contaCorrente.lerSaldo());
    }
    @PostMapping
    public ResponseEntity<ContaCorrente> criarConta(
            @RequestBody CorrentistaForm correntistaForm
    ){

        Correntista correntista = correntistaForm.toCorrentista();
        Integer banco = 111;
        Integer agencia = 222;
        Integer numero = new Random().nextInt(999999);
        ContaCorrente conta = new ContaCorrente(banco, agencia, numero, correntista);
        contaCorrenteRepository.salvar(conta);

        return ResponseEntity.status(HttpStatus.CREATED).body(conta);
    }
    @DeleteMapping
    public ResponseEntity<String> fecharConta(
            @RequestBody ContaCorrente conta
    ){
        if(contaCorrenteRepository.fechar(conta)){
           return ResponseEntity.status(HttpStatus.OK)
                   .body("Conta encerrada com sucesso!");
       } else {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                   .body("ixi, não conseguimos encerrar sua conta");
       }
    }

    @PutMapping
    public ResponseEntity<String> movimentarConta(
            @RequestBody MovimentacaoConta movimentacaoConta
    ){
        Optional<ContaCorrente> contaCorrenteOptional = contaCorrenteRepository.buscar(
                movimentacaoConta.getConta().getBanco(),
                movimentacaoConta.getConta().getAgencia(),
                movimentacaoConta.getConta().getNumero());

        if(contaCorrenteOptional.isEmpty()){
            return ResponseEntity.badRequest()
                    .body("Ixi, não encontramos sua conta..");
        } else {
            ContaCorrente contaCorrente = contaCorrenteOptional.get();
            movimentacaoConta.executarEm(contaCorrente);
            contaCorrenteRepository.salvar(contaCorrente);
            return ResponseEntity.ok()
                    .body("Movimentação realizada com sucesso!!");
        }
    }
}
