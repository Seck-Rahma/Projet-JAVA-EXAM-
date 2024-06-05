package com.devoirjava.entities;

public class Professeur extends Personne {
    private final String grade;
    private final String NCI;
    public Professeur(int id, String nom,String prenom, String grade, String NCI){
        super(id, nom, prenom);
        this.grade = grade;
        this.NCI = NCI;
    }
    @Override
    public String toString() {
        return "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", grade='" + grade + '\'' +
                ", NCI='" + NCI + '\'';
    }
    
       public String getGrade() {
        return grade;
    }
       public String getNCI() {
        return NCI;
    }
}
