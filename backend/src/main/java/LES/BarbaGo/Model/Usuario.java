package LES.BarbaGo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@Getter
@Setter
public class Usuario extends Pessoa {
    public Usuario(String nome, String email, String senha, Bairro bairro) {
        super(nome, email, senha, bairro);
    }
}