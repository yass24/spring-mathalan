package tn.esprit.kaddem.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "T_PROJET_DETAIL")
public class ProjetDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PD_ID")
    private Long id; // Identifiant projet detail (Clé primaire)
    @Column(name = "PD_DESCRIPTION")
    private String description;
    @Column(name = "PD_TECHNOLOGIE")
    private String technologie;
    @Column(name = "PD_COUT_PROVISOIRE")
    private Long cout_provisoire;
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @OneToOne(mappedBy = "projetDetail")
    @JsonIgnore
    @ToString.Exclude
    private Projet projet;


}
