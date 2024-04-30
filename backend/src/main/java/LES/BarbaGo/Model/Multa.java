package LES.BarbaGo.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="multa")
@Getter
@Setter
@NoArgsConstructor
public class Multa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
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
