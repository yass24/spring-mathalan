package tn.esprit.kaddem.Controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jdk.nashorn.internal.ir.PropertyKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddem.Entity.Projet;
import tn.esprit.kaddem.Entity.ProjetDetail;
import tn.esprit.kaddem.Service.ProjetDetailService;
import tn.esprit.kaddem.Service.ProjetService;


import java.util.List;

@Tag(name="Voici les methodes de la classe Projet")

@RestController
@RequestMapping("/projet")
public class ProjetRestController {
   @Autowired
   ProjetService projetService;
   ProjetDetailService projetDetailService;
    @Operation(description = "c'est une methode de recuperation de tout les projets")
    @GetMapping("/retrieve-projet")
    //http://localhost:8089/SpringMVC/projet/retrieve-projet
    public List<Projet> getProjet() {
        List< Projet > listProjet = projetService.retrieveAllProjet();
        return listProjet;
    }
    // http://localhost:8089/SpringMVC/projet/retrieve-projet/8
    @Operation(description = "c'est une methode de recuperation d'un projet par ID ")
    @GetMapping("/retrieve-projet/{projet-id}")
    public Projet retrieveProjet(@PathVariable("projet-id") Long projetId) {
        Projet projet = projetService.retrieveProjet(projetId);
        return projet;
    }
    // http://localhost:8089/SpringMVC/projet/add-projet
    @Operation(description = "c'est une methode d'ajout d'un projet'")
    @PostMapping("/add-projet")
    public Projet addProjet(@RequestBody Projet pp)
    {
        Projet projet = projetService.addProjet(pp);
        return projet;
    }
    // http://localhost:8089/SpringMVC/projet/remove-projet/{projet-id}
    @Operation(description = "c'est une methode de suppression d'un projet'")
    @DeleteMapping("/remove-projet/{projet-id}")
    public void removeProjet(@PathVariable("projet-id") Long projetId) {
        projetService.removeProjet(projetId);

    }
    // http://localhost:8089/SpringMVC/projet/modify-projet
    @Operation(description = "c'est une methode de modification d'un projet'")
    @PutMapping("/modify-projet")
    public Projet modifyProjet(@RequestBody Projet pp) {
        Projet projet = projetService.modifyProjet(pp);
        return projet;
    }
    // http://localhost:8089/SpringMVC/projet/add-projet-and-projet-detail
    @Operation(description = "c'est une methode d'affectation d'un projetdetail a un projet'")
    @PostMapping("/add-projet-and-projet-detail")
    public Projet addProjetAndProjetDetailAndAssign(@RequestBody Projet p) {
        Projet projet = projetService.addProjetAndProjetDetailAndAssign(p);
        return projet;
    }
    // http://localhost:8089/SpringMVC/projet/affecter-projet-detail-a-projet/1/1
    @Operation(description = "c'est une methde d'affectation d'un projet detail a un projet crées deja dans la base")
    @PutMapping("/affecter-projet-detail-a-projet/{projet-id}/{projet-detail-id}")
    public void assignProjetDetailToProjet(@PathVariable("projet-id") Long projetId,@PathVariable("projet-detail-id") Long projetDetailId){
         projetService.assignProjetDetailToProjet(projetId,projetDetailId);


    }
    // http://localhost:8089/SpringMVC/projet/affecter-projet-a-equipe/1/1
    @Operation(description = "c'est une methode d'affectation d'un projet  a une equipe crées deja dans la base")
    @PutMapping("/affecter-projet-a-equipe/{projet-id}/{equipe-id}")
    public void assignProjetToEquipe(@PathVariable("projet-id") Long projetId,@PathVariable("equipe-id") Long equipeId){
        projetService.assignProjetToEquipe(projetId,equipeId);


    }
    // http://localhost:8089/SpringMVC/projet/affecter-projetdetailcree-a-projet/1
    @Operation(description = "c'est une methode d'affectation d'un projet a un projetdetail deja crée dans la base")
    @PutMapping("/affecter-projetdetailcree-a-projet/{projet-detail-id}")
public Projet addProjetAndAssignProjetToProjetDetail(@RequestBody Projet p,@PathVariable("projet-detail-id") Long projetDetailId) {
   Projet projet = projetService.addProjetAndAssignProjetToProjetDetail(p,projetDetailId);
   return projet;
    }
    // http://localhost:8089/SpringMVC/projet/desaffecter-projetdetail-de-projet/1
    @Operation(description = "c'est une methode de desaaffectation d'un projetdetail d'un projet ")
    @PutMapping("/desaffecter-projetdetail-de-projet/{projet-id}")
    public Projet DesaffecterProjetDetailFromProjet(@PathVariable("projet-id") Long projetId)
    {
        Projet projet = projetService.DesaffecterProjetDetailFromProjet(projetId);
        return projet;
    }
    // http://localhost:8089/SpringMVC/projet/desaffecter-projet-de-equipe/1/1
    @Operation(description = "c'est une methode de desaaffectation d'un projet d'une equipe crées deja dans la base ")
    @PutMapping("/desaffecter-projet-de-equipe/{projet-id}/{equipe-id}")
    public void desaffecterProjetFromEquipe(@PathVariable("projet-id") Long projetId,@PathVariable("equipe-id") Long equipeId)
    {
        projetService.desaffecterProjetFromEquipe(projetId,equipeId);
    }
    }
