package codigos;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PedidoTest { 

    private Pedido pedido;

    @BeforeClass
    public static void setupClass(){
    
    }

    @Before
    public void setup(){
    
        pedido = new Pedido();
    }

    @Test
    public void testTaxaZero(){
        float taxa = pedido.calculaTaxaDesconto(false,"",100);
        assertEquals(0,taxa,0.001);
    }

    @Test
    public void testTaxa15PeloValorCompraMaior500(){
        float taxa = pedido.calculaTaxaDesconto(false,"",600);
        assertEquals(15,taxa,0.001);
    }

    @Test
    public void testTaxa15PeloValorCompraIgual500(){
        float taxa = pedido.calculaTaxaDesconto(false,"",500);
        assertEquals(15,taxa,0.001);
    }

    @Test
    public void testTaxa15PeloTipoClienteOuro(){
        float taxa = pedido.calculaTaxaDesconto(false,"ouro",300);
        assertEquals(15,taxa,0.001);
    }

    @Test
    public void testTaxa10PeloTipoClientePrata(){
        // tipoCliente "prata", valor < 400, nao primeiraCompra
        float taxa = pedido.calculaTaxaDesconto(false,"prata",300);
        assertEquals(10,taxa,0.001);
    }

    @Test
    public void testTaxa10PelaPrimeiraCompra(){
        // primeiraCompra, tipoCliente "", valor < 400
        float taxa = pedido.calculaTaxaDesconto(true,"",300);
        assertEquals(10,taxa,0.001);
    }

    @Test
    public void testTaxa10PeloValorCompraMaiorIgual400(){
        // valorCompra >= 400, < 500, nao "ouro", nao "prata", nao primeiraCompra
        float taxa = pedido.calculaTaxaDesconto(false,"bronze",400);
        assertEquals(10,taxa,0.001);
    }
     @Test
    public void testTaxa10PeloValorCompraMaiorIgual400ClienteNormal(){
        // valorCompra >= 400, < 500, nao "ouro", nao "prata", nao primeiraCompra
        float taxa = pedido.calculaTaxaDesconto(false,"normal",450);
        assertEquals(10,taxa,0.001);
    }


    @Test
    public void testTaxa5PeloValorCompraMaiorIgual200(){
        // valorCompra >= 200, < 400, cliente nao "ouro", "prata", nao primeiraCompra
        float taxa = pedido.calculaTaxaDesconto(false,"",200);
        assertEquals(5,taxa,0.001);
    }

    @Test
    public void testTaxa5PeloTipoClienteBronze(){
        // tipoCliente "bronze" (note: uses == in implementation), valor < 200
        // nao primeiraCompra
        float taxa = pedido.calculaTaxaDesconto(false,"bronze",100);
        assertEquals(5,taxa,0.001);
    }

    @Test
    public void testTaxa5PeloTipoClienteBronzeComValorMaiorMasOutrasCondicoesDe10NaoAtendidas(){
        // tipoCliente "bronze", valor >=200 but <400, not primeiraCompra
        float taxa = pedido.calculaTaxaDesconto(false,"bronze",250);
        assertEquals(5,taxa,0.001); // Will hit the valorCompra >= 200 first
    }

     @Test
    public void testPrioridadeTaxa15OuroSobrePrata() {
        // tipoCliente "ouro" deve dar 15% mesmo se valor qualificaria para 10% por "prata"
        float taxa = pedido.calculaTaxaDesconto(false, "ouro", 450); // valor >= 400
        assertEquals(15, taxa, 0.001);
    }

    @Test
    public void testPrioridadeTaxa10PrataSobreBronze() {
        // tipoCliente "prata" deve dar 10% mesmo se valor qualificaria para 5% por "bronze"
        float taxa = pedido.calculaTaxaDesconto(false, "prata", 250); // valor >= 200
        assertEquals(10, taxa, 0.001);
    }

    @Test
    public void testPrioridadeTaxa10PrimeiraCompraSobreBronze() {
        float taxa = pedido.calculaTaxaDesconto(true, "bronze", 250); // primeiraCompra, valor >=200
        assertEquals(10, taxa, 0.001);
    }
}