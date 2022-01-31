import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.ReajusteService;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReajusteServiceTest {
    //TDD DESENVOLVIMENTO GUIADO POR TESTE
    //BASICAMENTE OS TESTE ANTES DO DESENVOLVIMENTO
    private ReajusteService reajusteService;
    private Funcionario funcionario;

    @BeforeEach
    public void inicializar(){
        System.out.println("Iniciando teste");
        this.reajusteService = new ReajusteService();
        this.funcionario =
                new Funcionario("matheus", LocalDate.now(), new BigDecimal("1000.00"));
    }
    @AfterEach
    public void terminando(){
        System.out.println("finalizando teste");
    }
    @BeforeAll
    public static void primeiroDeTudo(){
        System.out.println("Iniciando testes...");
    }

    @AfterAll
    public static void finalizando(){
        System.out.println("Terminou todos os testes");
    }


    @Test
    public void reajusteDe3PorcentoParaDesempenhoADesejar(){
        reajusteService.concedeReajuste(funcionario, Desempenho.A_DESEJAR);
        Assertions.assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDe10PorcentoParaDesempenhoRegular(){
        reajusteService.concedeReajuste(funcionario, Desempenho.REGULAR);
        Assertions.assertEquals(new BigDecimal("1100.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDe20PorcentoParaDesempenhoOtimo(){
        reajusteService.concedeReajuste(funcionario, Desempenho.OTIMO);
        Assertions.assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
