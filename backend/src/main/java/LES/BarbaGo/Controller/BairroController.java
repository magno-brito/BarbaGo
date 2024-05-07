package LES.BarbaGo.Controller;


import LES.BarbaGo.Model.Bairro;
import LES.BarbaGo.Service.BairroService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/bairros")
public class BairroController {
    @Autowired
    private BairroService bairroService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Bairro salvar(Bairro bairro) {
        return bairroService.salvar(bairro);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Bairro> listaBairros() {
        return bairroService.listaBairros();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Bairro buscarPorId(@PathVariable("id") Long id) {
        return bairroService.buscarPorId(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerPorId(@PathVariable("id") Long id) {
        bairroService.buscarPorId(id).map(
                cidade -> {
                    bairroService.removerPorId(id);
                    return Void.TYPE;
                }
        ).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
