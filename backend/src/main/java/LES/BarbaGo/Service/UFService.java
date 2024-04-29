package LES.BarbaGo.Service;


import LES.BarbaGo.Model.UF;
import LES.BarbaGo.Model.Usuario;
import LES.BarbaGo.Repository.UFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UFService {

    @Autowired
    private UFRepository ufRepository;
    public UF salvar(UF uf) {
        return ufRepository.save(uf);
    }

    public List<UF> listaUF(){
        return ufRepository.findAll();
    }

    public Optional<UF> buscarPorId(Long id) {
        return ufRepository.findById(id);
    }

    public void removerPorId(Long id) {
        ufRepository.deleteById(id);
    }

}
