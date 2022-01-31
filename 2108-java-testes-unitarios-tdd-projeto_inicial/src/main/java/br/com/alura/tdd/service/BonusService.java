package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;

import br.com.alura.tdd.modelo.Funcionario;

public class BonusService {

	public BigDecimal calcularBonus(Funcionario funcionario) {
		BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
		if (valor.compareTo(new BigDecimal("1000")) > 0) {
			valor = BigDecimal.ZERO;
			throw new IllegalArgumentException("O salário desse funcionário já é alto. > R$10.000,00");
		}

		return valor.setScale(2, RoundingMode.HALF_UP);
	}

}
