package LES.BarbaGo.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="cidade")
@Getter
@Setter
@NoArgsConstructor
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToOne
    @JoinColumn(name="uf")
    private UF uf;

    public Cidade(String nome, UF uf) {
        this.nome = nome;
        this.uf = uf;
    }
}
