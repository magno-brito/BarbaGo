package LES.BarbaGo.Controller;

import LES.BarbaGo.Model.Multa;
import LES.BarbaGo.Model.Pessoa;
import LES.BarbaGo.Service.MultaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/multa")
public class MultaController {

    @Autowired
    private MultaService multaService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Multa salvar(Multa multa) {
        return multaService.salvar(multa);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Multa> listaMulta() {
        return multaService.listaMultas();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Multa buscarPorId(@PathVariable("id") Long id) {
        return multaService.buscarPorId(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerPorId(@PathVariable("id") Long id) {
        multaService.buscarPorId(id).map(
                usuario -> {
                    multaService.removerPorId(id);
                    return Void.TYPE;
                }
        ).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
