package LES.BarbaGo.Model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Servicos {
    private String nome;
    private Float valor;

    public void Servico(String nome, Float valor) {
        this.nome = nome;
        this.valor = valor;
    }

}
