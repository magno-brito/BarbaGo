package LES.BarbaGo.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="servicos")
@Getter
@Setter
public class Servicos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Float valor;

    public void Servicos(String nome, Float valor) {
        this.nome = nome;
        this.valor = valor;
    }

}
