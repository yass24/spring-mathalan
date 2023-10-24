package tn.esprit.kaddem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.kaddem.Entity.EQUIPE;
import tn.esprit.kaddem.Entity.Projet;
import tn.esprit.kaddem.Entity.ProjetDetail;
import tn.esprit.kaddem.Repository.EquipeRepo;
import tn.esprit.kaddem.Repository.ProjetDetailRepo;
import tn.esprit.kaddem.Repository.ProjetRepo;

import java.util.List;
@Service


public class ProjetServiceImp implements ProjetService{
    @Autowired
    ProjetRepo projetRepository;
    @Autowired
    ProjetDetailRepo projetDetailRepo;
    @Autowired
    EquipeRepo equipeRepo;
    public List<Projet> retrieveAllProjet()
    {

        return projetRepository.findAll();

    }

    public Projet retrieveProjet(Long projetId)
    {

        return projetRepository.findById(projetId).get();

    }
    public Projet addProjet(Projet pp)
    {

        return projetRepository.save(pp);

    }

    public void removeProjet(Long projetId)
    {

        projetRepository.deleteById(projetId);

    }

    public Projet modifyProjet(Projet projet)
    {

        return projetRepository.save(projet);

    }
    public Projet addProjetAndProjetDetailAndAssign(Projet projet) {
        return projetRepository.save(projet);
    }
    public void assignProjetDetailToProjet(Long projetId, Long projetDetailId) {
        Projet projet = projetRepository.findById(projetId).get();
        ProjetDetail projetDetail = projetDetailRepo.findById(projetDetailId).get();
// on set le fils dans le parent :
        projet.setProjetDetail(projetDetail);
        projetRepository.save(projet);
    }
    public void assignProjetToEquipe(Long projetId, Long equipeId) {
        Projet projet = projetRepository.findById(projetId).get();
        EQUIPE equipe = equipeRepo.findById(equipeId).get();
// on set le fils dans le parent :
        equipe.getProjets().add(projet);
        equipeRepo.save(equipe);
    }
    public Projet addProjetAndAssignProjetToProjetDetail(Projet projet, Long projetDetailId) {
        ProjetDetail projetDetail = projetDetailRepo.findById(projetDetailId).get();
// on set le fils dans le parent :
        projet.setProjetDetail(projetDetail);
        return projetRepository.save(projet);
    }
    public Projet DesaffecterProjetDetailFromProjet(Long projetId) {
        Projet projet = projetRepository.findById(projetId).get();
        projet.setProjetDetail(null);
        return projetRepository.save(projet);
    }
    public void desaffecterProjetFromEquipe(Long projetId, Long equipeId) {
        Projet projet = projetRepository.findById(projetId).get();
        EQUIPE equipe = equipeRepo.findById(equipeId).get();
// on enlève le fils du parent :
        equipe.getProjets().remove(projet);
        equipeRepo.save(equipe);
    }

}
