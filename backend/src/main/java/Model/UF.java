package Model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UF {
    private String nome;

    public UF(String nome) {
        this.nome = nome;
    }


}
