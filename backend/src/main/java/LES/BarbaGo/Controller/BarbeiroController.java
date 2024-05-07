package LES.BarbaGo.Controller;

import LES.BarbaGo.Model.Barbeiro;
import LES.BarbaGo.Model.Cidade;
import LES.BarbaGo.Service.BarbeiroService;
import LES.BarbaGo.Service.CidadeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/barbeiros")
public class BarbeiroController {
    @Autowired
    private BarbeiroService barbeiroService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Barbeiro salvar(Barbeiro barbeiro) {
        return barbeiroService.salvar(barbeiro);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Barbeiro> listaBarbeiros() {
        return barbeiroService.listaBarbeiros();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Barbeiro buscarPorId(@PathVariable("id") Long id) {
        return barbeiroService.buscarPorId(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerPorId(@PathVariable("id") Long id) {
        barbeiroService.buscarPorId(id).map(
                cidade -> {
                    barbeiroService.removerPorId(id);
                    return Void.TYPE;
                }
        ).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
