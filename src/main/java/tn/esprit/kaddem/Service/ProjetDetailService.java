package tn.esprit.kaddem.Service;

import tn.esprit.kaddem.Entity.ProjetDetail;

import java.util.List;

public interface ProjetDetailService {
    public List<ProjetDetail> retrieveAllProjetDetails();
    public ProjetDetail retrieveProjetDetail(Long projetDetailId);
    public ProjetDetail addProjetDetail(ProjetDetail p);
    public void removeProjetDetail(Long projetDetailId);
    public ProjetDetail modifyProjetDetail(ProjetDetail projetDetail);
    public List<ProjetDetail> retrieveAndCoutProjetDetail();
}
