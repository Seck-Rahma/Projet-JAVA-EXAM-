import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
    String nomModule = scanner.nextLine();
moduleService.ajouterModule(nomModule);
private void gererModules(Scanner scanner) {
    while (true) {
        System.out.println("\nGestion des modules:");
        System.out.println("1. Ajouter un module");
        System.out.println("2. Lister les modules");
        System.out.println("3. Retour au menu principal");

        System.out.print("Votre choix: ");
        int choix = scanner.nextInt();
        scanner.nextLine();

        switch (choix) {
            case 1:
                System.out.print("Nom du module: ");
break;
                case 2:
                    List<Module> modules = moduleService.listerModules();
                    if (modules.isEmpty()) {
                        System.out.println("Aucun module n'est disponible.");
                    } else {
                        System.out.println("Liste des modules:");
                        for (Module module : modules) {
                            System.out.println("- " + module.getNomModule());
                        }
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    private void gererCours(Scanner scanner) {
        while (true) {
            System.out.println("\nGestion des cours:");
            System.out.println("1. Créer un cours");
            System.out.println("2. Lister tous les cours");
            System.out.println("3. Lister les cours d'un module et d'un professeur");
            System.out.println("4. Retour au menu principal");

            System.out.print("Votre choix: ");
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    System.out.print("Date du cours (YYYY-MM-DD): ");
                    String dateStr = scanner.nextLine();
                    LocalDate date = LocalDate.parse(dateStr);

                    System.out.print("Heure de début du cours (HH:mm:ss): ");
                    String heureDebutStr = scanner.nextLine();
                    LocalTime heureDebut = LocalTime.parse(heureDebutStr);

                    System.out.print("Heure de fin du cours (HH:mm:ss): ");
                    String heureFinStr = scanner.nextLine();
                    LocalTime heureFin = LocalTime.parse(heureFinStr);

                    System.out.print("Nom du professeur: ");
                    String nomProfesseur = scanner.nextLine();
                    System.out.print("Prénom du professeur: ");
                    String prenomProfesseur = scanner.nextLine();
                    System.out.print("Numéro de téléphone du professeur: ");
                    String telephoneProfesseur = scanner.nextLine();
                    Professeur professeur = new Professeur(nomProfesseur, prenomProfesseur, telephoneProfesseur);

                    System.out.print("Nom du module: ");
                    String nomModule = scanner.nextLine();

                    Module module = new Module(nomModule);
                    coursService.creerCours(date, heureDebut, heureFin, professeur, module);
                    break;
                case 2:
                    List<Cours> tousCours = coursService.listerTousCours();
                    if (tousCours.isEmpty()) {
                        System.out.println("Aucun cours n'est disponible.");
                    } else {
                        System.out.println("Liste de tous les cours:");
                        for (Cours cours : tousCours) {
                            System.out.println("Informations du cours");
                            System.out.println("Date du cours: " + cours.getDate());
                            System.out.println("heure de début: " + cours.getHeureDebut());
                            System.out.println("Heure de fin: " + cours.getHeureFin());
                            System.out.println("Professeur: " + cours.getProfesseur().getNom() + " " + cours.getProfesseur().getPrenom());
                            System.out.println("Module: " + cours.getModule().getNomModule());
                
                        }
                    }
                    break;
                case 3:
                    System.out.print("Nom du module: ");
                    String nomModuleCours = scanner.nextLine();
                    Module moduleCours = new Module(nomModuleCours);

                    System.out.print("Nom du professeur: ");
                    String nomProfesseurCours = scanner.nextLine();
                    System.out.print("Prénom du professeur: ");
                    String prenomProfesseurCours = scanner.nextLine();
                    Professeur professeurCours = new Professeur(nomProfesseurCours, prenomProfesseurCours);

                    List<Cours> coursModuleProfesseur = coursService.listerCoursModuleProfesseur(moduleCours, professeurCours);
                    if (coursModuleProfesseur.isEmpty()) {
                        System.out.println("Aucun cours n'a été trouvé pour ce module et ce professeur.");
                    } else {
                        System.out.
}
