package tn.esprit.kaddem.Entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
@Entity
@Table(name = "T_ENTREPRISE")
public class ENTREPRISE implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ENTREPRISE_ID")
    private Long id; // Identifiant entreprise (Clé primaire)

    @Column(name = "ENTREPRISE_NOM")
    private String nom;

    @Column(name = "ENTREPRISE_ADRESSE")
    private String adresse;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="entreprise")
    private Set<EQUIPE> Equipes;


}
