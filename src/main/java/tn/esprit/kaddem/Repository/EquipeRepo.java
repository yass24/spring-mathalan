package tn.esprit.kaddem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.kaddem.Entity.EQUIPE;


public interface EquipeRepo extends JpaRepository<EQUIPE,Long > {
}
