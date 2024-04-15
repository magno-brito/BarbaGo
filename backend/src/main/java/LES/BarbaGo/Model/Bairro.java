package LES.BarbaGo.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bairro")
@Getter
@Setter
@NoArgsConstructor
public class Bairro {
    @Id
    private String nome;
    private Cidade cidade;
    private UF uf;

    public Bairro( String nome, Cidade cidade, UF uf) {
        this.nome = nome;
        this.cidade = cidade;
        this.uf = uf;
    }

}
