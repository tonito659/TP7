package com.antoine;

public class ListeEtudiant {

    private int numero;
    private String prenom;
    private String nom;
    private ListeEtudiant Suivant;

    public ListeEtudiant(int numero, String prenom, String nom) {
        this.numero = numero;
        this.prenom = prenom;
        this.nom = nom;
    }

    ////////////////////////////////////////////////////

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ListeEtudiant getSuivant() {
        return Suivant;
    }

    public void setSuivant(ListeEtudiant suivant) {
        this.Suivant = suivant;
    }

    //////////////////////////////////////////////////////
}