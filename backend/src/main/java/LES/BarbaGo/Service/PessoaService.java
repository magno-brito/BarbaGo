package LES.BarbaGo.Service;


import LES.BarbaGo.Model.Pessoa;
import LES.BarbaGo.Model.Servicos;
import LES.BarbaGo.Repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;
    public Pessoa salvar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> listaPessoas(){
        return pessoaRepository.findAll();
    }

    public Optional<Pessoa> buscarPorId(Long id) {
        return pessoaRepository.findById(id);
    }

    public void removerPorId(Long id) {
        pessoaRepository.deleteById(id);
    }
}
