import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.fail;

public class BonusServiceTest {
    @Test
    public void bonusDeveriaSerZeroParaFuncionarioComSalarioAlto(){
        BonusService bonusService = new BonusService();

//        Assertions.assertThrows(IllegalArgumentException.class,
//                () -> bonusService.calcularBonus(
//                new Funcionario("matheus",
//                        LocalDate.now(),
//                        new BigDecimal("15000"))));
        try{
            bonusService.calcularBonus(
                new Funcionario("matheus", LocalDate.now(), new BigDecimal("15000")));

            fail("Nao deu a exception");//obrigo a falhar caso a exception nao seja lancada
        }catch (IllegalArgumentException e){
            Assertions
                    .assertEquals("O salário desse funcionário já é alto. > R$10.000,00", e.getMessage());
        }


//        Assertions.assertEquals(new BigDecimal("0.00"), valor);
    }

    @Test
    public void bonusDeveriaSer10PorCentoDoSalario(){
        BonusService bonusService = new BonusService();
        BigDecimal valor =
                bonusService.calcularBonus(
                        new Funcionario("matheus",
                                LocalDate.now(),
                                new BigDecimal("2500")));

        Assertions.assertEquals(new BigDecimal("250.00"), valor);
    }

    @Test
    public void bonusDeveriaSer1000Reais(){
        BonusService bonusService = new BonusService();
        BigDecimal valor =
                bonusService.calcularBonus(
                        new Funcionario("matheus",
                                LocalDate.now(),
                                new BigDecimal("10000")));

        Assertions.assertEquals(new BigDecimal("1000.00"), valor);
    }
}
