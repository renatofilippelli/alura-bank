package br.com.alura.alurabank.domain;

import java.math.BigDecimal;

public enum Operacao {
    SAQUE{
        @Override
        public BigDecimal executar(BigDecimal saldo, BigDecimal valor){
            return saldo.subtract(valor);
        }
    }, DEPOSITO {
        @Override
        public BigDecimal executar(BigDecimal saldo, BigDecimal valor){
            return saldo.add(valor);
        }
    };

    public abstract BigDecimal executar(BigDecimal saldo, BigDecimal valor);
}
