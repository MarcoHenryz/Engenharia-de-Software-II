package codigos;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertEquals;

public class TrianguloTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testEquilatero() throws LadoInvalidoException {
        String resultado = Triangulo.classificaTriangulo(5, 5, 5);
        assertEquals("EQUILATERO", resultado);
    }

    @Test
    public void testIsoscelesAB() throws LadoInvalidoException {
        String resultado = Triangulo.classificaTriangulo(5, 5, 4);
        assertEquals("ISOSCELES", resultado);
    }

    @Test
    public void testIsoscelesAC() throws LadoInvalidoException {
        String resultado = Triangulo.classificaTriangulo(5, 4, 5);
        assertEquals("ISOSCELES", resultado);
    }

    @Test
    public void testIsoscelesBC() throws LadoInvalidoException {
        String resultado = Triangulo.classificaTriangulo(4, 5, 5);
        assertEquals("ISOSCELES", resultado);
    }

    @Test
    public void testEscaleno() throws LadoInvalidoException {
        String resultado = Triangulo.classificaTriangulo(5, 6, 7);
        assertEquals("ESCALENO", resultado);
    }

    @Test
    public void testLadoAInvalidoNegativo() throws LadoInvalidoException {
        thrown.expect(LadoInvalidoException.class);
        thrown.expectMessage("lado invalido");
        Triangulo.classificaTriangulo(-5, 5, 5);
    }

    @Test
    public void testLadoBInvalidoNegativo() throws LadoInvalidoException {
        thrown.expect(LadoInvalidoException.class);
        thrown.expectMessage("lado invalido");
        Triangulo.classificaTriangulo(5, -5, 5);
    }

    @Test
    public void testLadoCInvalidoNegativo() throws LadoInvalidoException {
        thrown.expect(LadoInvalidoException.class);
        thrown.expectMessage("lado invalido");
        Triangulo.classificaTriangulo(5, 5, -5);
    }

    @Test
    public void testLadoAInvalidoZero() throws LadoInvalidoException {
        thrown.expect(LadoInvalidoException.class);
        thrown.expectMessage("lado invalido");
        Triangulo.classificaTriangulo(0, 5, 5);
    }

    @Test
    public void testLadoBInvalidoZero() throws LadoInvalidoException {
        thrown.expect(LadoInvalidoException.class);
        thrown.expectMessage("lado invalido");
        Triangulo.classificaTriangulo(5, 0, 5);
    }

    @Test
    public void testNegativoZero() throws LadoInvalidoException{
        thrown.expect(LadoInvalidoException.class);
        thrown.expectMessage("lado invalido");
        Triangulo.classificaTriangulo(-1, -1, 0);
    }

    @Test
    public void testLadoCInvalidoZero() throws LadoInvalidoException {
        String resultado = Triangulo.classificaTriangulo(5, 5, 0);
        assertEquals("NAO FORMA TRIANGULO", resultado);
    }

    @Test
    public void testNaoFormaTrianguloASomaDeDoisLadosMenorQueTerceiro1() throws LadoInvalidoException {
        String resultado = Triangulo.classificaTriangulo(1, 2, 5);
        assertEquals("NAO FORMA TRIANGULO", resultado);
    }

    @Test
    public void testNaoFormaTrianguloASomaDeDoisLadosMenorQueTerceiro2() throws LadoInvalidoException {
        String resultado = Triangulo.classificaTriangulo(5, 1, 2);
        assertEquals("NAO FORMA TRIANGULO", resultado);
    }

    @Test
    public void testNaoFormaTrianguloASomaDeDoisLadosMenorQueTerceiro3() throws LadoInvalidoException {
        String resultado = Triangulo.classificaTriangulo(1, 5, 2);
        assertEquals("NAO FORMA TRIANGULO", resultado);
    }

    @Test
    public void testNaoFormaTrianguloASomaDeDoisLadosIgualAoTerceiro() throws LadoInvalidoException {
        String resultado = Triangulo.classificaTriangulo(1, 2, 3);
        assertEquals("NAO FORMA TRIANGULO", resultado);
    }

    @Test
    public void testNaoFormaIgual() throws LadoInvalidoException {
        String resultado = Triangulo.classificaTriangulo(3, 2, 1);
        assertEquals("NAO FORMA TRIANGULO", resultado);
    }

    @Test
    public void testNaoFormaIgual2() throws LadoInvalidoException {
        String resultado = Triangulo.classificaTriangulo(2, 3, 1);
        assertEquals("NAO FORMA TRIANGULO", resultado);
    }

    @Test
    public void testConstrutorParaCoberturaTriangulo() {
        @SuppressWarnings("unused")
        Triangulo instancia = new Triangulo();
        org.junit.Assert.assertNotNull(instancia);
    }
}