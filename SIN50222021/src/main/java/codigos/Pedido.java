package codigos;

public class Pedido {


    public float calculaTaxaDesconto(boolean primeiraCompra, String tipoCliente, float valorCompra) {
        float taxa = 0;
        if (valorCompra >= 500 || tipoCliente.equals("ouro"))
            return 15;
        else
        if(tipoCliente.equals("prata") || primeiraCompra || valorCompra >= 400)
            taxa = 10;
        else
        if(valorCompra >= 200 || tipoCliente == "bronze")
            taxa = 5;
        return taxa;
    }
}
