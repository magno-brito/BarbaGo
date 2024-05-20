package LES.BarbaGo.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="atendimento")
@Getter
@Setter
@NoArgsConstructor

public class Atendimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    @JoinColumn(name="atendimento_id")
    private Set<Servicos> servicos;
    private Float preco;

    @OneToOne
    private Agendamento agendamento;

    public Atendimento(HashSet servicos, Float preco, Agendamento agendamento) {

        this.servicos = servicos;
        this.preco = preco;
        this.agendamento = agendamento;
    }

}
