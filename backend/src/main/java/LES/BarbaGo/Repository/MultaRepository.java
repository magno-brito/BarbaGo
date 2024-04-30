package LES.BarbaGo.Repository;

import LES.BarbaGo.Model.Multa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MultaRepository extends JpaRepository<Multa, Long> {
}
