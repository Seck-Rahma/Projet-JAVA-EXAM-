package com.devoirjava.entities;


public class Classe {
    private final int id;
    private final String libelle;
    private final String filliere;
    private final String niveau;

    public Classe(int id, String libelle, String filliere, String niveau) {
        this.id = id;
        this.libelle = libelle;
        this.filliere = filliere;
        this.niveau = niveau ;
    }

    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getFilliere() {
        return filliere;
    }

    public String getNiveau() {
        return niveau;
    }

  
    @Override
    public String toString() {
        return "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", filliere='" + filliere + '\'' +
                ", niveau='" + niveau;
    }
}

