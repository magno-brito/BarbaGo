package LES.BarbaGo.Service;

import LES.BarbaGo.Model.Bairro;
import LES.BarbaGo.Repository.BairroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BairroService {
    @Autowired
    private BairroRepository bairroRepository;

    public Bairro salvar(Bairro bairro) {
        return bairroRepository.save(bairro);
    }

    public List<Bairro> listaBairros(){
        return bairroRepository.findAll();
    }

    public Optional<Bairro> buscarPorId(Long id) {
        return bairroRepository.findById(id);
    }

    public void removerPorId(Long id) {
        bairroRepository.deleteById(id);
    }
}
