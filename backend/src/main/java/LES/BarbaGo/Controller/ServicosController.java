package LES.BarbaGo.Controller;


import LES.BarbaGo.Model.Servicos;
import LES.BarbaGo.Model.UF;
import LES.BarbaGo.Service.ServicosService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/servico")
public class ServicosController {
    @Autowired
    private ServicosService servicosService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Servicos salvar(Servicos servicos) {
        return servicosService.salvar(servicos);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Servicos> listaServicos() {
        return servicosService.listaServicos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Servicos buscarPorId(@PathVariable("id") Long id) {
        return servicosService.buscarPorId(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerPorId(@PathVariable("id") Long id) {
        servicosService.buscarPorId(id).map(
                uf -> {
                    servicosService.removerPorId(id);
                    return Void.TYPE;
                }
        ).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
