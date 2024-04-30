package LES.BarbaGo.Repository;

import LES.BarbaGo.Model.Servicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicosRepository extends JpaRepository<Servicos, Long> {
}
