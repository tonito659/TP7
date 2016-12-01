package com.antoine;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
    public static ListeEtudiant ajouteEtudiantDebut(ListeEtudiant liste, int numero, String prenom, String nom){
        ListeEtudiant maliste = new ListeEtudiant(numero, prenom, nom);
        maliste.setSuivant(liste);
        return maliste;

    }

    public static void ajouteEtudiantFin(ListeEtudiant liste, int numero, String prenom, String nom){
        ListeEtudiant maliste = new ListeEtudiant(numero, prenom, nom);
        liste.setSuivant(maliste);
    }

    public static ListeEtudiant getEtudiant (ListeEtudiant liste, int numero){
        // EN partant du numéro de la listen, on réccupère les infos étudiantes
        // Attention, aucun check implémenté si l'etudiant n'est pas dans la liste // Fixed
        if (liste.getNumero() == numero){
            ListeEtudiant newliste = new ListeEtudiant(numero, liste.getPrenom(), liste.getNom());
            return newliste;

        }else if(liste.getSuivant() != null){  // Fixed
            getEtudiant(liste.getSuivant(), numero);
            return null;
        }else{
            System.out.print("ERR 404");
            return null;
        }
    }

    public static void afficheListe (ListeEtudiant maliste){
        if(maliste.getSuivant() != null){  // Fixed
            System.out.println(maliste.getNom() + " "+maliste.getPrenom()+" numéro : "+maliste.getNumero());
            afficheListe(maliste.getSuivant());
        }else System.out.println("fin");
    }



    public static ListeEtudiant trieListeParNumero (ListeEtudiant maliste){
        // Tri par insertion
        // implémenter trieListeParNumerobis, obligé
        int i = maliste.getNumero();
        while (maliste.getSuivant() != null){
            if (maliste.getNumero() < i){
                i = maliste.getNumero();
            }
            maliste = maliste.getSuivant();
        }
        ListeEtudiant liste_tri_debut = getEtudiant(maliste,i);
        maliste = trieListeParNumerobis(maliste,liste_tri_debut);
        return maliste;
    }

    static ListeEtudiant trieListeParNumerobis(ListeEtudiant a,ListeEtudiant l){
        //Qu’est-ce que c’est que ce pays ? C’est pas possible. Il fait au moins... -8000 ! -Numérobis (embauché pour trier cette fois)
        ListeEtudiant f,b,i; // cops
        while(a.getSuivant()!=null){
            f=a.getSuivant(); // élément à insérer
            b=f.getSuivant();
            a.setSuivant(b); // supprimer cet élément de la liste a
            // chercher la place de f.v dans la liste que l'on trie
            for(i=l;i.getSuivant()!=null;i=i.getSuivant()) // On peut faire ça et c'est fou
                if (i.getSuivant().getNumero() > f.getNumero())break;
            // insérer f après i
            f.setSuivant(i.getSuivant());
            i.setSuivant(f);
        }
        return(l);
    }
    public void ajouteListeTrie(ListeEtudiant liste,int numero , String prenom, String nom){
        ajouteEtudiantFin(liste, numero, prenom, nom);
        trieListeParNumero(liste);

    }
}
