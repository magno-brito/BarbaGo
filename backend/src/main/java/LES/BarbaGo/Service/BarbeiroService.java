package LES.BarbaGo.Service;


import LES.BarbaGo.Model.Barbeiro;
import LES.BarbaGo.Model.Cidade;
import LES.BarbaGo.Repository.BarbeiroRepository;
import LES.BarbaGo.Repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BarbeiroService {
    @Autowired
    private BarbeiroRepository barbeiroRepository;

    @Autowired
    private EmailVerificationService emailVerificationService;

    public Barbeiro salvar(Barbeiro barbeiro) {
        if (emailVerificationService.emailExists(barbeiro.getEmail())) {
            throw new RuntimeException("Email já está em uso.");
        }
        return barbeiroRepository.save(barbeiro);
    }

    public List<Barbeiro> listaBarbeiros(){
        return barbeiroRepository.findAll();
    }

    public Optional<Barbeiro> buscarPorId(Long id) {
        return barbeiroRepository.findById(id);
    }

    public void removerPorId(Long id) {
        barbeiroRepository.deleteById(id);
    }
}
