package LES.BarbaGo.Service;

import LES.BarbaGo.Model.Servicos;
import LES.BarbaGo.Model.UF;
import LES.BarbaGo.Repository.ServicosRepository;
import LES.BarbaGo.Repository.UFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicosService {
    @Autowired
    private ServicosRepository servicosRepository;
    public Servicos salvar(Servicos servicos) {
        return servicosRepository.save(servicos);
    }

    public List<Servicos> listaServicos(){
        return servicosRepository.findAll();
    }

    public Optional<Servicos> buscarPorId(Long id) {
        return servicosRepository.findById(id);
    }

    public void removerPorId(Long id) {
        servicosRepository.deleteById(id);
    }
}
