package br.com.alura.tdd.modelo;

import java.math.BigDecimal;

public enum Desempenho {
    A_DESEJAR{
        @Override
        public BigDecimal percentualReajuste(){
            return new BigDecimal("0.03");
        }
    },
    REGULAR{
        @Override
        public BigDecimal percentualReajuste(){
            return new BigDecimal("0.1");
        }
    },
    OTIMO{
        @Override
        public BigDecimal percentualReajuste(){
            return new BigDecimal("0.2");
        }
    };

    public abstract BigDecimal percentualReajuste();
}
