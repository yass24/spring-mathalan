package tn.esprit.kaddem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.kaddem.Entity.ENTREPRISE;
import tn.esprit.kaddem.Entity.ProjetDetail;

import java.util.List;

public interface ProjetDetailRepo extends JpaRepository<ProjetDetail,Long >
{
    //Liste ProjetDetails dont la description contient le mot "finance"
    List<ProjetDetail> findByDescription(String aaa);
    //Methode semi prete qui recupere la liste des projetsDetails
    List<ProjetDetail> findPROJET_DETAILByProjetSujetNotNull();
    @Query("SELECT e FROM ENTREPRISE e WHERE e.adresse =:adresse")
    List<ENTREPRISE> retrieveEntreprisesByAdresse(@Param("adresse") String adresse);


 
}
