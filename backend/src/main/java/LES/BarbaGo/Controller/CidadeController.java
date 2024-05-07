package LES.BarbaGo.Controller;

import LES.BarbaGo.Model.Cidade;
import LES.BarbaGo.Model.Servicos;
import LES.BarbaGo.Service.CidadeService;
import LES.BarbaGo.Service.ServicosService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {
    @Autowired
    private CidadeService cidadeService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cidade salvar(Cidade cidade) {
        return cidadeService.salvar(cidade);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Cidade> listaCidades() {
        return cidadeService.listaCidades();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cidade buscarPorId(@PathVariable("id") Long id) {
        return cidadeService.buscarPorId(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerPorId(@PathVariable("id") Long id) {
        cidadeService.buscarPorId(id).map(
                cidade -> {
                    cidadeService.removerPorId(id);
                    return Void.TYPE;
                }
        ).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
