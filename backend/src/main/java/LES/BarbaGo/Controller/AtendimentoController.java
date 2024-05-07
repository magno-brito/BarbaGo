package LES.BarbaGo.Controller;


import LES.BarbaGo.Model.Atendimento;
import LES.BarbaGo.Service.AtendimentoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/atendimentos")
public class AtendimentoController {
    @Autowired
    private AtendimentoService atendimentoService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Atendimento salvar(Atendimento atendimento) {
        return atendimentoService.salvar(atendimento);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Atendimento> listaAtendimentos() {
        return atendimentoService.listaAtendimentos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Atendimento buscarPorId(@PathVariable("id") Long id) {
        return atendimentoService.buscarPorId(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerPorId(@PathVariable("id") Long id) {
        atendimentoService.buscarPorId(id).map(
                cidade -> {
                    atendimentoService.removerPorId(id);
                    return Void.TYPE;
                }
        ).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
