package com.training.example;

public class Banque {

    private String nom;
    private Client[] clients;
    private int nbClients;

    public Banque(String nom) {
        this.nom = nom;
        this.clients = new Client[100];
    }

    public void ajouterClient(String nomDuClient) {
        this.clients[nbClients++] = new Client(nomDuClient);
    }

    public void bilanClient(String nomDuClient) {
        for (int i = 0; i < nbClients; i++) {
            Client c = this.clients[i];
            if (c.getNom().equals(nomDuClient)) {
                c.afficherSolde();
            }
        }
    }

    public void afficherBilan() {
        System.out.println("### BILAN GÉNÉRAL pour " + this.nom + " ###");

        for (int i = 0; i < nbClients; i++) {
            Client c = this.clients[i];
            c.afficherSolde();
        }
        System.out.println("################################################");
    }

    public Client[] getClients() {
        return clients;
    }
}
