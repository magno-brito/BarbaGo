package LES.BarbaGo.Controller;


import LES.BarbaGo.Model.Agendamento;
import LES.BarbaGo.Service.AgendamentoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {
    @Autowired
    private AgendamentoService agendamentoService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Agendamento salvar(Agendamento agendamento) {
        return agendamentoService.salvar(agendamento);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Agendamento> listaAgendamentos() {
        return agendamentoService.listaAgendamentos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Agendamento buscarPorId(@PathVariable("id") Long id) {
        return agendamentoService.buscarPorId(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerPorId(@PathVariable("id") Long id) {
        agendamentoService.buscarPorId(id).map(
                cidade -> {
                    agendamentoService.removerPorId(id);
                    return Void.TYPE;
                }
        ).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
