package com.devoirjava.services;

import com.devoirjava.entities.Classe;
import com.devoirjava.repositories.ClasseRepository;

import java.util.List;

public class ClasseService {

    private final ClasseRepository classeRepository;

    public ClasseService(ClasseRepository classeRepository) {
        this.classeRepository = classeRepository;
    }

    public void save(Classe classe) {
        classeRepository.saveClasse(classe);
    }

    public List<Classe> findAll() {
        return classeRepository.findAllClasses();
    }

   
}
