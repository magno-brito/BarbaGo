package LES.BarbaGo.Service;


import LES.BarbaGo.Model.Atendimento;
import LES.BarbaGo.Repository.AtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtendimentoService {
    @Autowired
    private AtendimentoRepository atendimentoRepository;

    public Atendimento salvar(Atendimento atendimento) {
        return atendimentoRepository.save(atendimento);
    }

    public List<Atendimento> listaAtendimentos(){
        return atendimentoRepository.findAll();
    }

    public Optional<Atendimento> buscarPorId(Long id) {
        return atendimentoRepository.findById(id);
    }

    public void removerPorId(Long id) {
        atendimentoRepository.deleteById(id);
    }
}
