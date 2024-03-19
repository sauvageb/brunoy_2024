package com.training.example;

import java.util.Scanner;

public class BanqueInteraction {

    private Scanner scanner;
    private Banque banque;

    public BanqueInteraction() {
        this.scanner = new Scanner(System.in);
        this.banque = new Banque("CIC");
    }

    public void interaction() {
        System.out.println();
        System.out.println("### MINI-BANQUE INTERACTIVE ###");
        System.out.println("Quelle opération voulez-vous effectuer ?");
        System.out.println("1) Ajouter un client");
        System.out.println("2) Effectuer une operation sur un client");
        System.out.println("3) Afficher un bilan général");
        System.out.println("4) Quitter");
        int choice = this.scanner.nextInt();

        switch (choice) {
            case 1:
                interactionAjoutClient();
                break;
            case 2:
                interactionOperationClient();
                break;
            case 3:
                interactionAfficherBilan();
                break;
            case 4:
                interactionStop();
                break;
            default:
                System.out.println("Votre choix n'existe pas. Veuillez recommencer");
                interaction();
        }
    }

    private void interactionStop() {
        this.scanner.close();
        System.out.println("Merci et à bientôt");
        System.exit(0);
    }

    private void interactionAfficherBilan() {
        this.banque.afficherBilan();
    }

    private void interactionOperationClient() {
        System.out.println("Quel client ?");

        Client[] clients = this.banque.getClients();
        for (int i = 0; i < clients.length; i++) {
            Client c = clients[i];
            if (c != null) {
                System.out.println(i + 1 + ")" + c.getNom());
            }
        }
        System.out.println("#############");
        int indexClient = this.scanner.nextInt();
        Client client = clients[indexClient - 1];
        interactionOperationMenuClient(client);
    }

    private void interactionOperationMenuClient(Client client) {
        System.out.println();
        System.out.println("Quelle operation voulez-vous effectuer sur le client " + client.getNom() + " ?");
        System.out.println("1) Ajouter un compte");
        System.out.println("2) Afficher un bilan");
        System.out.println("3) Faire un retrait");
        System.out.println("4) Faire un dépôt");
        System.out.println("5) Faire un virement");
        System.out.println("6) Quitter");
        int choice = this.scanner.nextInt();
        switch (choice) {
            case 1:
                client.ajouterCompte();
                System.out.println("Un compte a été ajouté au client " + client.getNom());
                break;
            case 2:
                client.afficherSolde();
                break;
            case 3:
                System.out.println("Sur quel compte voulez-vous retirer de l'argent ?");
                Compte compteDebit = selectionCompte(client);
                System.out.println("Quel montant voulez-vous retirer ?");
                float valeur = this.scanner.nextFloat();
                compteDebit.retrait(valeur);
                System.out.println(valeur + " a été retiré du compte " + compteDebit.getNumero());
                client.afficherSolde();
                break;
            case 4:
                System.out.println("Sur quel compte voulez-vous déposer de l'argent ?");
                Compte compteCredit = selectionCompte(client);
                System.out.println("Quel montant voulez-vous déposer ?");
                valeur = this.scanner.nextFloat();
                compteCredit.depot(valeur);
                System.out.println(valeur + " a été déposé sur le compte " + compteCredit.getNumero());
                client.afficherSolde();
                break;
            case 5:
                System.out.println("Depuis quel compte voulez-vous retirer l'argent ?");
                compteDebit = selectionCompte(client);
                System.out.println("Vers quel compte voulez-vous envoyer l'argent ?");
                Compte compteDestination = selectionCompte(client);
                System.out.println("Quel montant voulez-vous utiliser pour le virement ?");
                valeur = this.scanner.nextFloat();
                compteDebit.virer(valeur, compteDestination);
                System.out.println(valeur + " a été déposé sur le compte " + compteDestination.getNumero());
                client.afficherSolde();
                break;
            case 6:
                interactionStop();
                break;
            default:
                System.out.println("Votre choix n'existe pas. Veuillez recommencer");
                interactionOperationMenuClient(client);
                break;
        }
        System.out.println("1) Revenir au menu principal");
        System.out.println("2) Revenir au menu operation sur client");
        System.out.println("3) Quitter");
        int choixInteraction = this.scanner.nextInt();
        switch (choixInteraction) {
            case 1:
                interaction();
                break;
            case 2:
                interactionOperationClient();
                break;
            case 3:
            default:
                interactionStop();
        }
    }

    private Compte selectionCompte(Client client) {
        for (Compte compte : client.getComptes()) {
            if (compte != null) {
                System.out.println(compte.getNumero() + ") Compte nº " + compte.getNumero());
            }
        }
        int numeroCompte = this.scanner.nextInt();
        return client.getComptes()[numeroCompte - 1];
    }

    private void interactionAjoutClient() {
        System.out.println("Entrez le nom du client :");
        String nomDuClient = this.scanner.next();
        this.banque.ajouterClient(nomDuClient);
        System.out.println("Le client " + nomDuClient + " a été créé");
        interaction();
    }
}
