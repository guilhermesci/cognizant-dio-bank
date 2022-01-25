package dio.bank;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco("DioBank");
        List<IConta> contas = new ArrayList<>();

        Cliente cliente = new Cliente();
        cliente.setNome("Guilherme");

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Antonella");

        ContaCorrente cc = new ContaCorrente(cliente);
        cc.depositar(100);
        cc.sacar(30);

        ContaPoupanca cp = new ContaPoupanca(cliente2);
        cc.transferir(50,cp);

//        cc.imprimirExtrato();
//        cp.imprimirExtrato();

//        contas.add(cc);
//        contas.add(cp);
//        banco.setContas(contas);

        banco.setConta(cc);
        banco.setConta(cp);

        System.out.println("Contas cadastradas no "+banco.getNome()+System.lineSeparator());
        banco.getContas().stream().forEach(x -> x.imprimirExtrato());
    }
}
