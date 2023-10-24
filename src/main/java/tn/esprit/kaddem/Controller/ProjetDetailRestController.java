package tn.esprit.kaddem.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddem.Entity.ProjetDetail;
import tn.esprit.kaddem.Service.ProjetDetailService;

import java.util.List;

@Tag(name="Web Services pour la guestion du projet de projetDetail")

@RestController
@RequestMapping("/projetdetail")
public class ProjetDetailRestController {
@Autowired
    ProjetDetailService projetDetailService;
@Operation(description = "cette une methode de recuperation de tout les projetsDetails")
    @GetMapping("/retrieve-projetdetail")
    //http://localhost:8089/SpringMVC/projetdetail/retrieve-projetdetail
    public List<ProjetDetail> getProjectDetail() {
        List< ProjetDetail > listProjetDetails = projetDetailService.retrieveAllProjetDetails();
        return listProjetDetails;
    }
    // http://localhost:8089/SpringMVC/projetdetail/retrieve-projetdetail/8
    @Operation(description = "cette une methode de recuperation d'un projetdetail par ID ")
    @GetMapping("/retrieve-projetdetail/{projet-detail-id}")
    public ProjetDetail retrieveProjetDetail(@PathVariable("projet-detail-id") Long projetDetailId) {
        ProjetDetail projetDetail = projetDetailService.retrieveProjetDetail(projetDetailId);
        return projetDetail;
    }
    // http://localhost:8089/SpringMVC/projetdetail/add-projet-detail
    @Operation(description = "cette une methode d'ajout d'un projetdetail'")
    @PostMapping("/add-projet-detail")
    public ProjetDetail addProjetDetail(@RequestBody ProjetDetail p)
    {
        ProjetDetail projetDetail = projetDetailService.addProjetDetail(p);
        return projetDetail;
    }
    // http://localhost:8089/SpringMVC/projetdetail/remove-projet-detail/{projet-detail-id}
    @Operation(description = "cette une methode de suppression d'un projetdetail'")
    @DeleteMapping("/remove-projet-detail/{projet-detail-id}")
    public void removeProjetDetail(@PathVariable("projet-detail-id") Long projetDetailId) {
        projetDetailService.removeProjetDetail(projetDetailId);

    }
    // http://localhost:8089/SpringMVC/projetdetail/modify-projet-detail
    @Operation(description = "cette une methode de modification d'un projetdetail'")
    @PutMapping("/modify-projet-detail")
    public ProjetDetail modifyProjetDetail(@RequestBody ProjetDetail p) {
        ProjetDetail projetDetail = projetDetailService.modifyProjetDetail(p);
        return projetDetail;
    }
}
