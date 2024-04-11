package Model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Cidade {
    private String nome;
    private UF uf;

    public Cidade(String nome, UF uf) {
        this.nome = nome;
        this.uf = uf;
    }


}
