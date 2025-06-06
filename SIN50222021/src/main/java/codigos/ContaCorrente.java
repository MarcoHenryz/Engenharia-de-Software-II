package codigos;

public class ContaCorrente {

    private float saldo;
    private float limite;


    public ContaCorrente(float saldo, float limite){
        this.saldo=saldo;
        this.limite=limite;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public float getLimite() {
        return limite;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }

    public float saque(float valor) throws Exception {
        if (valor<=0)
            throw new Exception("Valor invalido");
        if (valor<=saldo+limite)
            saldo = saldo - valor;
        else
            throw new Exception("Saldo Insuficiente");
        return saldo;
    }

}
