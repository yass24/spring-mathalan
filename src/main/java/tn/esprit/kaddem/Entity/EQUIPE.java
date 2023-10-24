package tn.esprit.kaddem.Entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
@Entity
@Getter
@Setter
@Table(name = "T_EQUIPE")
public class EQUIPE implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EQUIPE_ID")
    private Long id; // Identifiant equipe (Clé primaire)

    @Column(name = "EQUIPE_NOM")
    private String nom;

    @Column(name = "EQUIPE_SPECIALITE")
    private String specialite;
    @ManyToOne(cascade = CascadeType.ALL)
    ENTREPRISE entreprises;
    @ManyToOne(cascade = CascadeType.ALL)
    ENTREPRISE entreprise;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Projet> projets;

}