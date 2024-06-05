package com.devoirjava.services;

import com.devoirjava.entities.Etudiant;
import com.devoirjava.repositories.EtudiantRepository;
import com.devoirjava.repositories.InscriptionRepository;
import java.util.List;

public class EtudiantService {

    private final EtudiantRepository etudiantRepository;
    private final InscriptionRepository inscriptionRepository;

    public EtudiantService(EtudiantRepository etudiantRepository, InscriptionRepository inscriptionRepository) {
        this.etudiantRepository = etudiantRepository;
        this.inscriptionRepository = inscriptionRepository;
    }

    public void save(Etudiant etudiant) {
        etudiantRepository.saveEtudiant(etudiant);
    }

    public List<Etudiant> findAll() {
        return etudiantRepository.findAllEtudiants();
    }

    public void inscrire(int idEtudiant, int idClasse, String annee) {
        inscriptionRepository.creerInscription(idEtudiant, idClasse, annee);
    }

    public List<Etudiant> findEtudiantsByAnnee(String annee) {
       return etudiantRepository.findEtudiantsByAnnee(annee);
    }
    public List<Etudiant> findEtudiantsByClasse(int idClasse) {
        return etudiantRepository.findEtudiantsByClasse(idClasse);
     }
}
