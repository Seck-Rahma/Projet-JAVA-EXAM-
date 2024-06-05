package com.devoirjava.services;

import com.devoirjava.entities.Classe;
import com.devoirjava.entities.Professeur;
import com.devoirjava.repositories.AffectationRepository;
import com.devoirjava.repositories.ProfesseurRepository;

import java.util.List;

public class ProfesseurService {

    private final ProfesseurRepository professeurRepository;
    private final AffectationRepository affectationRepository;

    public ProfesseurService(ProfesseurRepository professeurRepository, AffectationRepository affectationRepository) {
        this.professeurRepository = professeurRepository;
        this.affectationRepository = affectationRepository;
    }

    public void save(Professeur professeur) {
        professeurRepository.saveProfesseur(professeur);
    }

    public List<Professeur> findAll() {
        return professeurRepository.findAllProfesseurs();
    }

    public void affecterClasse(int idProfesseur, int idClasse) {
        affectationRepository.creerAffectation(idProfesseur, idClasse);
    }

    public List<Classe> findClasses(int idProfesseur) {
        return professeurRepository.findClasses(idProfesseur);
    }
}
