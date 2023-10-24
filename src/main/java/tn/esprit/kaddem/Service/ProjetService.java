package tn.esprit.kaddem.Service;

import tn.esprit.kaddem.Entity.Projet;


import java.util.List;

public interface ProjetService {
    public List<Projet> retrieveAllProjet();
    public Projet retrieveProjet(Long projetId);
    public Projet addProjet(Projet pp);
    public void removeProjet(Long projetId);
    public Projet modifyProjet(Projet projet);
    public Projet addProjetAndProjetDetailAndAssign(Projet projet);
    public void assignProjetDetailToProjet(Long projetId, Long projetDetailId);
    public void assignProjetToEquipe(Long projetId, Long equipeId);

    public Projet addProjetAndAssignProjetToProjetDetail(Projet projet, Long projetDetailId);
    public Projet DesaffecterProjetDetailFromProjet(Long projetId);
    public void desaffecterProjetFromEquipe(Long projetId, Long equipeId);
}
