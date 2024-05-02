package LES.BarbaGo.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="barbeiro")
@Getter
@Setter
@NoArgsConstructor
public class Barbeiro extends  Pessoa{
    @OneToMany
    @JoinColumn(name="barbeiro_id")
    private Set<Servicos> servicos;

    public Barbeiro(String nome, String email, String senha){
        super(nome, email, senha);
        servicos = new HashSet<Servicos>();
    }

    public void adicionarServico(Servicos servico) {
        this.servicos.add(servico);
    }


}
