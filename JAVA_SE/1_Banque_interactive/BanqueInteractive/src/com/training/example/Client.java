package com.training.example;

public class Client {

    private String nom;
    private Compte[] comptes;
    private int nbComptes;

    public Client(String nomDuClient) {
        this.nom = nomDuClient;
        this.comptes = new Compte[100];
        this.ajouterCompte();
    }

    public void ajouterCompte() {
        this.comptes[nbComptes++] = new Compte(nbComptes);
    }

    public float getSolde() {
        float totalSolde = 0;
        for (int i = 0; i < nbComptes; i++) {
            Compte c = comptes[i];
            totalSolde += c.getSolde();
        }
        return totalSolde;
    }

    public void afficherSolde() {
        System.out.println("## Informations pour le client " + this.nom + " ##");
        for (int i = 0; i < nbComptes; i++) {
            Compte c = comptes[i];
            c.afficherSolde();
        }
        System.out.println("## Solde total des comptes : " + this.getSolde() + " ##");
        System.out.println();
    }

    public String getNom() {
        return this.nom;
    }

    public Compte[] getComptes() {
        return comptes;
    }
}
