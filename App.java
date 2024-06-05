package com.devoirjava;

import com.devoirjava.repositories.AffectationRepository;
import com.devoirjava.repositories.ClasseRepository;
import com.devoirjava.repositories.EtudiantRepository;
import com.devoirjava.repositories.InscriptionRepository;
import com.devoirjava.repositories.ProfesseurRepository;
import com.devoirjava.services.ClasseService;
import com.devoirjava.services.EtudiantService;
import com.devoirjava.services.ProfesseurService;
import com.devoirjava.views.ClasseView;
import com.devoirjava.views.EtudiantView;
import com.devoirjava.views.ProfesseurView;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
       
     
        ClasseRepository classeRepository = new ClasseRepository();
        EtudiantRepository etudiantRepository = new EtudiantRepository();
        ProfesseurRepository professeurRepository = new ProfesseurRepository();
        AffectationRepository affectationRepository = new AffectationRepository();
        InscriptionRepository inscriptionRepository = new InscriptionRepository();
        ClasseService classeService = new ClasseService(classeRepository);
        EtudiantService etudiantService = new EtudiantService(etudiantRepository, inscriptionRepository);
        ProfesseurService professeurService = new ProfesseurService(professeurRepository, affectationRepository);

        ClasseView classeView = new ClasseView(classeService);
        EtudiantView etudiantView = new EtudiantView(etudiantService, classeService);
        ProfesseurView professeurView = new ProfesseurView(professeurService, classeService);

        Scanner clavier = new Scanner(System.in);
        int choix;
        do {
            System.out.println();
            System.out.println("Menu Principal");
            System.out.println("1. Classe");
            System.out.println("2. Etudiant");1
            System.out.println("3. Professeur");
            System.out.println("4. Quitter");
            System.out.println("Faites votre choix");
            choix = clavier.nextInt();
            switch (choix) {
                case 1:
                    classeView.menu(clavier);
                    break;
                case 2:
                    etudiantView.menu(clavier);
                    break;
                case 3:
                    professeurView.menu(clavier);
                    break;
                case 4:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Mauvais choix. Veuillez réessayer");
            }
        } while (choix != 4);
    }
}
