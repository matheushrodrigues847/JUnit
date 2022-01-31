package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {
    public void concedeReajuste(Funcionario funcionario, Desempenho desempenho){
        //padrao de projeto stategy
        BigDecimal reajuste =
                desempenho.percentualReajuste().multiply(funcionario.getSalario());
        funcionario.reajustaSalario(reajuste);

    }

    private int testeDeMetodoPrivado(){
        return 1;
    }

}
