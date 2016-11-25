package com.antoine;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Antoine on 25/11/2016.
 */
public class ListeEtudiant {

    int numero;
    String prenom;
    String nom;
    ListeEtudiant suivant;

    public ListeEtudiant(int numero, String prenom, String nom){
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

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {

        return nom;
    }
    //////////////////////////////////////////////////////




    public void ajouteEtudiantDebut(ListeEtudiant liste, int numero, String prenom, String nom){

    }

    public void ajouteEtudiantFin(ListeEtudiant liste, int numero, String prenom, String nom){

    }

    public ListeEtudiant getEtudiant (ListeEtudiant liste, int numero){
        // permet d'obtenir la liste d

    }

    public void afficheListe (ListeEtudiant maliste){

    }



    public void trieListeParNumero (ListeEtudiant maliste){

    }

}
