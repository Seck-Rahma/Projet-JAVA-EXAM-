package com.devoirjava.views;

import com.devoirjava.entities.Professeur;
import com.devoirjava.services.ClasseService;
import com.devoirjava.services.ProfesseurService;

import java.util.Scanner;

public class ProfesseurView {
    private final ProfesseurService professeurService;
    private final ClasseService classeService;

    public ProfesseurView(ProfesseurService professeurService, ClasseService classeService) {
        this.professeurService = professeurService;
        this.classeService = classeService;
    }

    public void menu(Scanner clavier) {
        int choix;
        do {
            System.out.println();
            System.out.println("==== Menu Professeur ====");
            System.out.println("1. Lister");
            System.out.println("2. Ajouter");
            System.out.println("3. Affectation classe");
            System.out.println("4. Lister les classes d'un professeur");
            System.out.println("5. Retour au menu principale");
            System.out.println("Faites votre choix");
            choix = clavier.nextInt();
            clavier.nextLine();
            int idProfesseur;
            switch (choix) {
                case 1:
                    System.out.println("Liste des professeurs : ");
                    afficherProfesseurs();
                    break;
                case 2:
                    System.out.println("Entrer l'id : ");
                    int id = clavier.nextInt();
                    clavier.nextLine();

                    System.out.println("Entrer le nom : ");
                    String nom = clavier.nextLine();

                    System.out.println("Entrer le prenom : ");
                    String prenom = clavier.nextLine();

                    System.out.println("Entrer le grade : ");
                    String grade = clavier.nextLine();

                    System.out.println("Entrer le NCI : ");
                    String NCI = clavier.nextLine();
                    
                    Professeur professeur = new Professeur(id, nom, prenom, grade, NCI);
                    professeurService.save(professeur);
                    break;
                case 3:
                    System.out.println("Affectation classe");
                    System.out.println("Selectionner l'id du professeur");
                    afficherProfesseurs();
                    idProfesseur = clavier.nextInt();
                    System.out.println("Selectionner l'id de la classe du professeur");
                    classeService.findAll().forEach(System.out::println);
                    int idClasse = clavier.nextInt();
                    professeurService.affecterClasse(idProfesseur, idClasse);
                    break;
                case 4:
                    System.out.println("Lister les classes d'un professeur");
                    System.out.println("Selectionner l'id du professeur");
                    afficherProfesseurs();
                    idProfesseur = clavier.nextInt();
                    professeurService.findClasses(idProfesseur).forEach(System.out::println);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Mauvais choix. Veillez réessayer");
            }
        } while (choix != 5);
    }

    public void afficherProfesseurs(){
        professeurService.findAll().forEach(System.out::println);
    }
}
