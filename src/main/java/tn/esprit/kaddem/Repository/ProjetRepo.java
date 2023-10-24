package tn.esprit.kaddem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.kaddem.Entity.Projet;


public interface ProjetRepo extends JpaRepository<Projet,Long > {
}
