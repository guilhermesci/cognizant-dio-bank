package dio.bank;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@NoArgsConstructor
public abstract class Conta implements IConta{
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta (Cliente cliente){
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        this.saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public void transferir(double valor, @NotNull IConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    @Override
    public void imprimirExtrato(){
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente: "+this.cliente.getNome()+System.lineSeparator());
        sb.append("Agencia: "+this.agencia+System.lineSeparator());
        sb.append("Conta: "+this.numero+System.lineSeparator());
        sb.append("Saldo: "+this.saldo+System.lineSeparator());
        System.out.println(sb);
    }
}
