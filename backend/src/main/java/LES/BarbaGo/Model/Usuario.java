package LES.BarbaGo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
public class Usuario extends Pessoa {
    public Usuario(String nome, String email, String senha, Bairro bairro) {
        super(nome, email, senha, bairro);
    }
}