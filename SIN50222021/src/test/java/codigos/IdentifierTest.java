package codigos;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class IdentifierTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void identvalidar(){
        Identifier identifier = new Identifier();
        Assert.assertNotNull( "A instância de Identifier não deveria ser nula.", identifier);
    }

    @Test
    public void testIDValido(){
        Assert.assertTrue(Identifier.validaIdentificador("a1"));
    }

    @Test
    public void testIDValidoSimples() {
        Assert.assertTrue(Identifier.validaIdentificador("abc"));
    }

    @Test
    public void testIDValidomenortam() {
        Assert.assertTrue(Identifier.validaIdentificador("a"));
    }

    @Test
    public void testIDValidomaiortam() {
        Assert.assertTrue(Identifier.validaIdentificador("abcdef"));
    }

    @Test
    public void testIDValidomaiortamComNumero() {
        Assert.assertTrue(Identifier.validaIdentificador("abcde1"));
    }

    @Test
    public void testIDInvalidoNull() {
        Assert.assertFalse(Identifier.validaIdentificador(null));
    }

    @Test
    public void testIDInvalidovazio() {
        Assert.assertFalse(Identifier.validaIdentificador(""));
    }

    @Test
    public void testIDInvalidoLongo() {
        Assert.assertFalse(Identifier.validaIdentificador("abcdefg"));
    }

    @Test
    public void testIDInvalidoiniciodigito() {
        Assert.assertFalse(Identifier.validaIdentificador("1abc"));
    }

    @Test
    public void testIDInvalidocaracterediferente() {
        Assert.assertFalse(Identifier.validaIdentificador("ab-c"));
    }

    @Test
    public void testIDInvalidoespaço() {
        Assert.assertFalse(Identifier.validaIdentificador("ab c"));
    }
}