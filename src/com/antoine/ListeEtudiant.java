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

    private ListeEtudiant getEtudiant (ListeEtudiant liste, int numero){
        // EN partant du numéro de la listen, on réccupère les infos étudiantes
        // Attention, aucun check implémenté si l'etudiant n'est pas dans la liste // Fixed
        if (liste.numero == numero){
            ListeEtudiant newliste = new ListeEtudiant(numero, liste.prenom, liste.nom);
            return newliste;

        }else if(liste.suivant != null){  // Fixed
            getEtudiant(liste.suivant, numero);
            return null;
        }else{
            System.out.print("ERR 404");
            return null;
        }
    }

    private void afficheListe (ListeEtudiant maliste){
        if(maliste.suivant != null){  // Fixed
            System.out.println(maliste.nom + " "+maliste.prenom+" numéro : "+maliste.numero);
            afficheListe(maliste.suivant);
        }else System.out.println("fin");
    }



    public ListeEtudiant trieListeParNumero (ListeEtudiant maliste){
        // Tri par insertion
        // implémenter trieListeParNumerobis, obligé
        int i = maliste.numero;
        while (maliste.suivant != null){
            if (maliste.numero < i){
                i = maliste.numero;
            }
            maliste = maliste.suivant;
        }
        ListeEtudiant liste_tri_debut = getEtudiant(maliste,i);
        maliste = trieListeParNumerobis(maliste,liste_tri_debut);
        return maliste;
    }

    static ListeEtudiant trieListeParNumerobis(ListeEtudiant a,ListeEtudiant l){
        //Qu’est-ce que c’est que ce pays ? C’est pas possible. Il fait au moins... -8000 ! -Numérobis (embauché pour trier cette fois)
        ListeEtudiant t,u,x;
        while(a.suivant!=null){
            t=a.suivant; // élément à insérer
            u=t.suivant;
            a.suivant=u; // supprimer cet élément de la liste a
                         // chercher la place de t.v dans la liste que l'on trie
            for(x=l;x.suivant!=null;x=x.suivant) // On peut faire ça et c'est fou
                if (x.suivant.numero > t.numero)break;
            // insérer t après x
            t.suivant=x.suivant;
            x.suivant=t;
        }
        return(l);
    }
    public void ajouteListeTrie(ListeEtudiant liste,int numero , String prenom, String nom){
        ajouteEtudiantFin(liste, numero, prenom, nom);
        trieListeParNumero(liste);

    }
}
