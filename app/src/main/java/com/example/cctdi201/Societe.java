package com.example.cctdi201;

import java.io.Serializable;

public class Societe implements Serializable {
    public int id;
    public String nom;
    public String secteuractivite;
    public int nombreemploye;

    public Societe() {
    }

    public Societe(int id, String nom, String secteuractivite, int nombreemploye) {
        this.id = id;
        this.nom = nom;
        this.secteuractivite = secteuractivite;
        this.nombreemploye = nombreemploye;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSecteuractivite() {
        return secteuractivite;
    }

    public void setSecteuractivite(String secteuractivite) {
        this.secteuractivite = secteuractivite;
    }

    public int getNombreemploye() {
        return nombreemploye;
    }

    public void setNombreemploye(int nombreemploye) {
        this.nombreemploye = nombreemploye;
    }
}
