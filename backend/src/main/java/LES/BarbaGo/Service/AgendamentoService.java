package LES.BarbaGo.Service;


import LES.BarbaGo.Model.Agendamento;
import LES.BarbaGo.Repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {
    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public Agendamento salvar(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }

    public List<Agendamento> listaAgendamentos(){
        return agendamentoRepository.findAll();
    }

    public Optional<Agendamento> buscarPorId(Long id) {
        return agendamentoRepository.findById(id);
    }

    public void removerPorId(Long id) {
        agendamentoRepository.deleteById(id);
    }
}
