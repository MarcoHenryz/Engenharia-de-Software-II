package codigos;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class WordsTest {

    private Words wordsInstance = new Words();

    @Test
    public void testStringNula() {
        assertEquals(-1, wordsInstance.countWords(null));
    }

    @Test
    public void testStringVazia() {
        assertEquals(0, wordsInstance.countWords(""));
    }

    @Test
    public void testStringSoEspacos() {
        assertEquals(0, wordsInstance.countWords("   "));
    }

    @Test
    public void testStringSemLetras() {
        assertEquals(0, wordsInstance.countWords("123 !@# $%^ .,;"));
    }

    @Test
    public void testPalavraUmCharR() {
        assertEquals(0, wordsInstance.countWords("r"));
    }

    @Test
    public void testPalavraUmCharS() {
        assertEquals(0, wordsInstance.countWords("s"));
    }

    @Test
    public void testPalavraDoisCharsR() {
        assertEquals(1, wordsInstance.countWords("ar"));
    }

    @Test
    public void testPalavraDoisCharsS() {
        assertEquals(1, wordsInstance.countWords("as"));
    }

    @Test
    public void testPalavraNaoTerminaRS() {
        assertEquals(0, wordsInstance.countWords("teste"));
    }

    @Test
    public void testPalavraValidaTerminaS() {
        assertEquals(1, wordsInstance.countWords("casas"));
    }

    @Test
    public void testPalavraValidaTerminaR() {
        assertEquals(1, wordsInstance.countWords("andar"));
    }

    @Test
    public void testExemploArPuro() {
        assertEquals(1, wordsInstance.countWords("Ar puro"));
    }

    @Test
    public void testExemploFazerValer() {
        assertEquals(2, wordsInstance.countWords("Fazer valer a pena"));
    }

    @Test
    public void testExemploAsLetrasRes() {
        assertEquals(4, wordsInstance.countWords("As letras res são usadas sempre"));
    }

    @Test
    public void testMultiplasPalavrasTerminamRS() {
        assertEquals(2, wordsInstance.countWords("amores flores cantam"));
    }

    @Test
    public void testPalavrasComMultiplosEspacos() {
        assertEquals(2, wordsInstance.countWords("carros  motoristas"));
    }

    @Test
    public void testPalavraFimStringTerminaS() {
        assertEquals(1, wordsInstance.countWords("atlas"));
    }

    @Test
    public void testPalavraFimStringNaoTerminaRS() {
        assertEquals(0, wordsInstance.countWords("agua"));
    }
    
    @Test
    public void testPalavraFimStringTerminaR() {
        assertEquals(1, wordsInstance.countWords("solar"));
    }

    @Test
    public void testPalavrasCurtasRSNaoContadas() {
        assertEquals(0, wordsInstance.countWords("a s e r"));
    }

    @Test
    public void testPalavrasCasoMisto() {
        assertEquals(2, wordsInstance.countWords("Sabores Cores"));
    }
    
    @Test
    public void testPalavrasComNumerosSimbolos() {
        assertEquals(1, wordsInstance.countWords("programadores1 gostam de Java!"));
    }

    @Test
    public void testPalavraTerminaRComNaoLetra() {
        assertEquals(1, wordsInstance.countWords("amor."));
    }

    @Test
    public void testPalavraTerminaSComNaoLetra() {
        assertEquals(1, wordsInstance.countWords("casas!"));
    }

    @Test
    public void testFraseVariasPalavras() {
        assertEquals(7, wordsInstance.countWords("Os programadores devem criar testes para validar seus algoritmos."));
    }

    @Test
    public void testPalavraAcentoTerminaS() {
        assertEquals(1, wordsInstance.countWords("país"));
    }

    @Test
    public void testPalavraAcentoTerminaR() {
        assertEquals(1, wordsInstance.countWords("éter"));
    }
}