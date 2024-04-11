package Model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Pessoa {

    private String nome;
    private String email;
    private String senha;
    private Bairro bairro;

    public Pessoa(String nome, String email, String senha, Bairro bairro) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.bairro = bairro;
    }


}