package LES.BarbaGo.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Barbeiro extends  Pessoa{
    private Set servicos;

    public Barbeiro(String nome, String email, String senha, Bairro bairro){
        super(nome, email, senha, bairro);
        servicos = new HashSet<Servicos>();
    }

    public void adicionarServico(Servicos servico) {
        this.servicos.add(servico);
    }


}
