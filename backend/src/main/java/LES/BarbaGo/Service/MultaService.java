package LES.BarbaGo.Service;

import LES.BarbaGo.Model.Multa;
import LES.BarbaGo.Model.Pessoa;
import LES.BarbaGo.Repository.MultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MultaService {
    @Autowired
    private MultaRepository multaRepository;

    public Multa salvar(Multa multa) {
        return multaRepository.save(multa);
    }

    public List<Multa> listaMultas(){
        return multaRepository.findAll();
    }

    public Optional<Multa> buscarPorId(Long id) {
        return multaRepository.findById(id);
    }

    public void removerPorId(Long id) {
        multaRepository.deleteById(id);
    }
}
