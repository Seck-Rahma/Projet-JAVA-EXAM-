package com.devoirjava.entities;

public class Personne {
    protected final int id;
    protected final String nom;
    protected final String prenom;

    public Personne(int id, String nom,String prenom){
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }


    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
      
}
