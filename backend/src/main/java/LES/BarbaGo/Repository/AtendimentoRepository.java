package LES.BarbaGo.Repository;

import LES.BarbaGo.Model.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtendimentoRepository  extends JpaRepository<Atendimento, Long> {
}
