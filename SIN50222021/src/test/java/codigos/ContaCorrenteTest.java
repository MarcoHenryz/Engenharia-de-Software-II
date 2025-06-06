package codigos;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertEquals;

public class ContaCorrenteTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private ContaCorrente conta;

    @Before
    public void setUp() {
        conta = new ContaCorrente(500, 100);
    }

    @Test
    public void testSaqueValorZero() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("Valor invalido");
        ContaCorrente cc = new ContaCorrente(100, 100);
        cc.saque(0); 
    }

    @Test
    public void testSaqueValorNegativo() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("Valor invalido");
        conta.saque(-50); 
    }

    @Test
    public void testSaqueComSucessoSaldoPositivoSemLimiteUsado() throws Exception {
        
        ContaCorrente cc = new ContaCorrente(500, 0);
        float novoSaldo = cc.saque(100);
        assertEquals(400, novoSaldo, 0.001);
        assertEquals(400, cc.getSaldo(), 0.001);
    }

    @Test
    public void testSaqueComSucessoUsandoLimiteSaldoNegativo() throws Exception {

        ContaCorrente cc = new ContaCorrente(200, 200);
        float novoSaldo = cc.saque(300);
        assertEquals(-100, novoSaldo, 0.001);
        assertEquals(-100, cc.getSaldo(), 0.001);
    }
    
    @Test
    public void testSaqueExatoSaldoMaisLimite() throws Exception {
        ContaCorrente cc = new ContaCorrente(100, 50); // Saldo+Limite = 150
        float novoSaldo = cc.saque(150);
        assertEquals(-50, novoSaldo, 0.001);
        assertEquals(-50, cc.getSaldo(), 0.001);
    }
    
    @Test
    public void testSaqueExatoSaldoSemLimite() throws Exception {
        ContaCorrente cc = new ContaCorrente(100, 0); // Saldo+Limite = 100
        float novoSaldo = cc.saque(100);
        assertEquals(0, novoSaldo, 0.001);
        assertEquals(0, cc.getSaldo(), 0.001);
    }

    @Test
    public void testSaqueSaldoInsuficiente() throws Exception {
    
        thrown.expect(Exception.class);
        thrown.expectMessage("Saldo Insuficiente");
        ContaCorrente cc = new ContaCorrente(200, 100); // Saldo+Limite = 300
        cc.saque(400);
    }

    @Test
    public void testGettersESetters() {
        ContaCorrente cc = new ContaCorrente(0, 0); 

        cc.setSaldo(1000);
        assertEquals(1000, cc.getSaldo(), 0.001); 

        cc.setLimite(500);
        assertEquals(500, cc.getLimite(), 0.001); 
    }
    
    @Test
    public void testConstrutor() {
        ContaCorrente cc = new ContaCorrente(750, 250);
        assertEquals(750, cc.getSaldo(), 0.001);
        assertEquals(250, cc.getLimite(), 0.001);
    }
}