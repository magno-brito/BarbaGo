package Model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Multa {
    private Agendamento agendamento;
    private Float valor;

    public Multa(Agendamento agendamento) {
        this.agendamento = agendamento;
        gerarMulta();
    }

    private void gerarMulta() {
        //cálculo para gerar multa  com base no valor do agendamento
    }

}
