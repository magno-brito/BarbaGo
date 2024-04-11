package Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Usuario  extends Pessoa{
    public Usuario(String nome, String email, String senha, Bairro bairro) {
        super(nome, email, senha, bairro);
    }
}
