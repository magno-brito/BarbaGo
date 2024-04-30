package LES.BarbaGo.Controller;


import LES.BarbaGo.Model.Pessoa;

import LES.BarbaGo.Service.PessoaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa salvar(Pessoa pessoa) {
        return pessoaService.salvar(pessoa);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Pessoa> listaPessoa() {
        return pessoaService.listaPessoas();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pessoa buscarPorId(@PathVariable("id") Long id) {
        return pessoaService.buscarPorId(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerPorId(@PathVariable("id") Long id) {
        pessoaService.buscarPorId(id).map(
                usuario -> {
                    pessoaService.removerPorId(id);
                    return Void.TYPE;
                }
        ).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
