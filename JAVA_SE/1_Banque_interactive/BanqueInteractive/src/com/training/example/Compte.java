package com.training.example;

public class Compte {

    private int numero;
    private float solde;

    public Compte(int numero) {
        this.numero = numero;
    }

    public Compte(int numero, float solde) {
        this.numero = numero;
        this.solde = solde;
    }

    public void depot(float valeur){
        this.solde += valeur;
    }

    public void retrait(float valeur){
        this.solde -= valeur;
    }

    public void virer(float valeur, Compte destinataire){
        this.retrait(valeur);
        destinataire.depot(valeur);
    }

    public void afficherSolde(){
        System.out.println("Le compte numéro " + this.numero + " a un solde de : " + this.solde);
    }

    public int getNumero() {
        return numero;
    }

    public float getSolde() {
        return solde;
    }


}
