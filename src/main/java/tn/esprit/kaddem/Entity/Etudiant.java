package tn.esprit.kaddem.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.security.DomainCombiner;

@Entity
@Table(name="T_etudiant")
public class Etudiant implements Serializable{
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name= "ID_Etudiant")
    private Long idEtudiant;
    private String prenomE;
    private String nomE;
    @Enumerated(EnumType.STRING)
    private Domaine domaine;
}
