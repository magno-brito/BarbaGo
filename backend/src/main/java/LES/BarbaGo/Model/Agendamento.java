package LES.BarbaGo.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;

@Entity
@Table(name="agendamento")
@Getter
@Setter
@NoArgsConstructor
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Barbeiro barbeiro;
    @OneToOne
    private Usuario usuario;
    private Calendar data;
}
