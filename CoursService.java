package Services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import Cours.Cours;
import Cours.Professeur;

public class CoursService {
    void creerCours(LocalDate date, LocalTime heureDebut, LocalTime heureFin, Professeur professeur, Module module);
    List<Cours> listerTousCours();
    List<Cours> listerCoursModuleProfesseur(Module module, Professeur professeur);
}
