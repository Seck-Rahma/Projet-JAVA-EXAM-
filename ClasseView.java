package com.devoirjava.views;

import com.devoirjava.entities.Classe;
import com.devoirjava.services.ClasseService;


import java.util.Scanner;

public class ClasseView {
    private final ClasseService classeService;

    public ClasseView(ClasseService classeService) {
        this.classeService = classeService;
    }

    public void menu(Scanner clavier) {
        int choix;
        do {
            System.out.println();
            System.out.println("==== Menu Classe ====");
            System.out.println("1. Lister");
            System.out.println("2. Ajouter");
            System.out.println("3. Lister les etudiants d'une classe");
            System.out.println("4. Retour au menu principale");
            System.out.println("Faites votre choix");
            choix = clavier.nextInt();
            clavier.nextLine();
            switch (choix) {
                case 1:
                    classeService.findAll().forEach(System.out::println);
                    break;
                case 2:
                    System.out.println("Entrer l'id : ");
                    int id = clavier.nextInt();
                    clavier.nextLine();

                    System.out.println("Entrer le libelle : ");
                    String libelle = clavier.nextLine();

                    System.out.println("Entrer la filliere : ");
                    String filliere = clavier.nextLine();

                    System.out.println("Entrer le niveau : ");
                    String niveau = clavier.nextLine();
                    
                    Classe classe = new Classe(id, libelle, filliere, niveau);
                    classeService.save(classe);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Mauvais choix. Veillez réessayer");
            }
        } while (choix != 3);
    }
}
