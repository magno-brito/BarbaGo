package LES.BarbaGo.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="bairro")
@Getter
@Setter
@NoArgsConstructor
public class Bairro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToOne
    @JoinColumn(name="cidade")
    private Cidade cidade;


    public Bairro( String nome, Cidade cidade) {
        this.nome = nome;
        this.cidade = cidade;
    }

}
