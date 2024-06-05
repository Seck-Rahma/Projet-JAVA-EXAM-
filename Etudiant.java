package com.devoirjava.entities;

//{}
public class Etudiant extends Personne {
   private final String tuteur; 
   private final String matricule; 

   public Etudiant(int id, String nom,String prenom, String tuteur, String matricule) {
    super(id, nom, prenom);
    this.tuteur = tuteur;
    this.matricule = matricule;  
   }


    public String getTuteur() {
        return tuteur;
    }

    public String getMatricule() {
        return matricule;
    }
    @Override
    public String toString() {
        return "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", tuteur='" + tuteur + '\'' +
                ", matricule='" + matricule + '\'';
    }

}
