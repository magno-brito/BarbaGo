package Model;

import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;

@Getter
@Setter
public class Agendamento {

    private Barbeiro barbeiro;
    private Usuario usuario;
    private Calendar data;
}
