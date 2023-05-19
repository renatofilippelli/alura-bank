package br.com.alura.alurabank.controller;

import br.com.alura.alurabank.domain.Investimento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/investimento")
public class InvestimentoController {

    private Map<String,Investimento> investimentos = new HashMap<String, Investimento>();

    @PostMapping
    public ResponseEntity<Investimento> criaInvestimento(
            @RequestBody Investimento investimento
    ){
        investimentos.put(investimento.getNome(),investimento);
        return ResponseEntity.status(HttpStatus.CREATED).body(investimento);
    }

    @GetMapping
    public ResponseEntity<List<Investimento>> listaInvestimento(){
       List<Investimento> investimento = investimentos.values().stream().toList();
        return ResponseEntity.status(HttpStatus.OK).body(investimento);
    }

    @PutMapping
    public ResponseEntity<String> aplicaRendimento(
            @RequestParam String nome,
            @RequestParam BigDecimal valor
    ){
        Investimento investimento = investimentos.get(nome);

        if (investimento != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(investimento.render(valor, investimento).toString());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Investimento não encontrado.");
        }
    }
}
