package LES.BarbaGo.Service;

import LES.BarbaGo.Model.Cidade;
import LES.BarbaGo.Model.Multa;
import LES.BarbaGo.Repository.CidadeRepository;
import LES.BarbaGo.Repository.MultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {
    @Autowired
    private CidadeRepository cidadeRepository;

    public Cidade salvar(Cidade cidade) {
        return cidadeRepository.save(cidade);
    }

    public List<Cidade> listaCidades(){
        return cidadeRepository.findAll();
    }

    public Optional<Cidade> buscarPorId(Long id) {
        return cidadeRepository.findById(id);
    }

    public void removerPorId(Long id) {
        cidadeRepository.deleteById(id);
    }
}
