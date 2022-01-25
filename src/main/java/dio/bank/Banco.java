package dio.bank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Banco {

    private String nome;
    private List<IConta> contas;

    public Banco (String nome){
        this.nome = nome;
    }

    public void setConta(Conta conta) {
        if (this.contas == null)
            this.contas = new ArrayList<>();
        this.contas.add(conta);
    }
}
