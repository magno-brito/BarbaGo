package LES.BarbaGo.Model;

import LES.BarbaGo.Model.Bairro;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pessoa")
@Getter
@Setter
@NoArgsConstructor
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String senha;

    @OneToOne
    private Bairro bairro;

    public Pessoa(String nome, String email, String senha, Bairro bairro) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.bairro = bairro;
    }
}
