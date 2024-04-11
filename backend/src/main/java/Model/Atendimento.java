package Model;

import java.util.HashSet;
import java.util.Set;

public class Atendimento {

    private Set servicos;
    private Float preco;
    private Agendamento agendamento;

    public Atendimento(HashSet servicos, Float preco, Agendamento agendamento) {

        this.servicos = servicos;
        this.preco = preco;
        this.agendamento = agendamento;
    }


    public Set getServicos() {
        return this.servicos;
    }

    public void setServicos(Set servicos) {
        this.servicos = servicos;
    }

    public Float getPreco() {
        return this.preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Agendamento getAgendamento() {
        return this.agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

}
