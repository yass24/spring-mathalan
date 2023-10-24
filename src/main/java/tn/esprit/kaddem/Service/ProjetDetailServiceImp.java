package tn.esprit.kaddem.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.kaddem.Entity.ProjetDetail;
import tn.esprit.kaddem.Repository.ProjetDetailRepo;

import java.util.List;
@Service
@Slf4j
public class ProjetDetailServiceImp implements ProjetDetailService {
    @Autowired
    ProjetDetailRepo projetDetailRepository;
   // @Scheduled(fixedDelay = 5000)
    public List<ProjetDetail> retrieveAllProjetDetails()
    {
        List<ProjetDetail> xyz =projetDetailRepository.findAll();
        for (ProjetDetail projetDetail : xyz) {

            log.info("je vais afficher une liste de tout les projet detail :" + projetDetail);
        }
        return xyz;

    }
    @Scheduled(fixedDelay = 5000)
    //@Scheduled(cron = "* * 13 * * *")
    @Query("SELECT pd FROM ProjetDetail pd WHERE pd.cout_provisoire > 100000")
    public List<ProjetDetail> retrieveAndCoutProjetDetail()
    {

        List<ProjetDetail> xyz =projetDetailRepository.findAll();


        for (ProjetDetail projetDetail : xyz ) {

            log.info("c'est la liste  des couts provisoires elevés :" + projetDetail);
        }
        return xyz;
    }

    public ProjetDetail retrieveProjetDetail(Long projetDetailId)
    {

        ProjetDetail xyz= projetDetailRepository.findById(projetDetailId).get();
        log.info("je vais afficher un projet detail :" +xyz);
        return xyz;

    }

    public ProjetDetail addProjetDetail(ProjetDetail p)
    {

        return projetDetailRepository.save(p);

    }

    public void removeProjetDetail(Long projetDetailId)
    {

        projetDetailRepository.deleteById(projetDetailId);

    }

    public ProjetDetail modifyProjetDetail(ProjetDetail projetDetail)
    {

        return projetDetailRepository.save(projetDetail);

    }
}
