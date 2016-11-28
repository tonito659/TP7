package com.antoine;

public class ListeEtudiant {

    private int numero;
    private String prenom;
    private String nom;
    private ListeEtudiant suivant;

    private ListeEtudiant(int numero, String prenom, String nom){
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

    public void setNom(String nom) { this.nom = nom;}

    public String getNom() { return nom;}

    public ListeEtudiant getSuivant() {
        return suivant;
    }

    private void setSuivant(ListeEtudiant suivant) {
        this.suivant = suivant;
    }
    //////////////////////////////////////////////////////




    public ListeEtudiant ajouteEtudiantDebut(ListeEtudiant liste, int numero, String prenom, String nom){
        ListeEtudiant maliste = new ListeEtudiant(numero, prenom, nom);
        maliste.setSuivant(liste);
        return maliste;

    }

    public void ajouteEtudiantFin(ListeEtudiant liste, int numero, String prenom, String nom){
        ListeEtudiant maliste = new ListeEtudiant(numero, prenom, nom);
        liste.setSuivant(maliste);
    }

    private String getEtudiant (ListeEtudiant liste, int numero){
        // EN partant du numéro de la listen, on réccupère les infos étudiantes
        // Attention, aucun check implémenté si l'etudiant n'est pas dans la liste // Fixed
        if (liste.numero == numero){
            return (liste.nom + " " + liste.prenom);

        }else if(liste.suivant != null){  // Fixed
            getEtudiant(liste.suivant, numero);
            return null;
        }else{
            return "L'étudiant n'est pas là";
        }
    }

    private void afficheListe (ListeEtudiant maliste){
        if(maliste.suivant != null){  // Fixed
            System.out.println(maliste.nom + " "+maliste.prenom+" numéro : "+maliste.numero);
            afficheListe(maliste.suivant);
        }else System.out.println("fin");
    }



    public void trieListeParNumero (ListeEtudiant maliste){
        // idée pas propre : créer un nouvel objet, parcourir toute maliste et remplir avec le premier plus petit, continuer
        // en prenant le second et ainsi de suite

        // implémenter trieListeParNumerobis, obligé

    }

}
