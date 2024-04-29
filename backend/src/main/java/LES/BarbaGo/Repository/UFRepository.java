package LES.BarbaGo.Repository;


import LES.BarbaGo.Model.UF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UFRepository  extends JpaRepository<UF, Long>{
}
