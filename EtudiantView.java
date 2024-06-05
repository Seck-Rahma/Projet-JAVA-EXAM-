package com.devoirjava.views;

import com.devoirjava.entities.Etudiant;
import com.devoirjava.services.ClasseService;
import com.devoirjava.services.EtudiantService;

import java.util.Scanner;

public class EtudiantView {
    private final EtudiantService etudiantService;
    private final ClasseService classeService;

    public EtudiantView(EtudiantService etudiantService, ClasseService classeService) {
        this.etudiantService = etudiantService;
        this.classeService = classeService;
    }

    public void menu(Scanner clavier) {
        int choix;
        int idEtudiant;
        String annee;
        do {
            System.out.println();
            System.out.println("==== Menu Etudiant ====");
            System.out.println("1. Lister");
            System.out.println("2. Ajouter");
            System.out.println("3. Inscrire");
            System.out.println("4. Lister les etudiants inscrit dans une annee");
            System.out.println("5. Lister les etudiants d'une classe");
            System.out.println("6. Retour au menu principale");
            System.out.println("Faites votre choix");
            choix = clavier.nextInt();
            clavier.nextLine();
            
            switch (choix) {
                case 1:
                    etudiantService.findAll().forEach(System.out::println);
                    break;
                case 2:
                    System.out.println("Entrer l'id : ");
                    int id = clavier.nextInt();
                    clavier.nextLine();

                    System.out.println("Entrer le nom : ");
                    String nom = clavier.nextLine();

                    System.out.println("Entrer le prenom : ");
                    String prenom = clavier.nextLine();

                    System.out.println("Entrer le tuteur : ");
                    String tuteur = clavier.nextLine();

                    System.out.println("Entrer le matricule : ");
                    String matricule = clavier.nextLine();

                    Etudiant etudiant = new Etudiant(id, nom, prenom, tuteur, matricule);
                    etudiantService.save(etudiant);
                    break;
                case 3:
                    System.out.println("Inscrire un etudiant");
                    System.out.println("Choisir un etudiant");
                    afficherEtudiants();
                    idEtudiant = clavier.nextInt();
                    System.out.println("Choisir une classe");
                    afficherClasses();
                    int idClasse = clavier.nextInt();
                    clavier.nextLine();
                    System.out.println("Choisir une annee");
                    annee = clavier.nextLine();
                    etudiantService.inscrire(idEtudiant, idClasse, annee);
                    break;
                case 4:
                    System.out.println("Lister les etudiants inscrit dans une annee");
                    System.out.println("Entrer l'annee scolaire");
                    annee = clavier.nextLine();
                    etudiantService.findEtudiantsByAnnee(annee).forEach(System.out::println);
                    break;           
                case 5:
                    System.out.println("Lister les etudiants d'une classe");
                    afficherClasses();
                    System.out.println("Entrer l'id de la classe");
                    idClasse = clavier.nextInt();
                    etudiantService.findEtudiantsByClasse(idClasse).forEach(System.out::println);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Mauvais choix. Veillez réessayer");
            }
        } while (choix != 6);
    }

    public void afficherEtudiants() {
        etudiantService.findAll().forEach(System.out::println);
    }
    public void afficherClasses() {
        classeService.findAll().forEach(System.out::println);
    }
}
