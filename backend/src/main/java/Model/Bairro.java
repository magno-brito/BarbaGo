package Model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bairro {
    private String nome;
    private Cidade cidade;
    private UF uf;

    public Bairro( String nome, Cidade cidade, UF uf) {
        this.nome = nome;
        this.cidade = cidade;
        this.uf = uf;
    }

}
