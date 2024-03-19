package fr.sauvageboris.training.exercice9.map;

import fr.sauvageboris.training.exercice9.map.model.Region;
import fr.sauvageboris.training.exercice9.map.model.User;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // a) Initialisation des contacts
        Map<String, String> contactBooks = new HashMap<>();
        contactBooks.put("Boris", "0680000000");
        contactBooks.put("Arthur", "0607070606");
        contactBooks.put("Thibault", "0605000005");
        contactBooks.put("Estelle", "0700000700");

        // b) Récupération et affichage du numéro d'Arthur
        String arthurPhone = contactBooks.get("Arthur");
        System.out.println("Téléphone d'Arthur : " + arthurPhone);

        // c) Affichage du phones de contacts
        System.out.println();
        for (Map.Entry<String, String> entry : contactBooks.entrySet()) {
            System.out.println("Nom : " + entry.getKey() + "=> Téléphone : " + entry.getValue());
        }

        // d) Mise à jour du numéro de Boris
        System.out.println();
        System.out.println("Carnet à jour :");
        contactBooks.put("Boris", "0799999907");
        for (Map.Entry<String, String> entry : contactBooks.entrySet()) {
            System.out.println("Nom : " + entry.getKey() + "=> Téléphone : " + entry.getValue());
        }


        // e) Méthode pour afficher le phones de contacts
        System.out.println();
        printContacts(contactBooks);

        // f) Mise à jour du phones de contacts avec la nouvelle HashMap
        Map<String, User> userContactBooks = new HashMap<>();
        userContactBooks.put("0605000005", new User("Thibault", Region.INDONESIE));
        userContactBooks.put("0607070606", new User("Arthur", Region.POLYNESIE));
        userContactBooks.put("0680000000", new User("Boris", Region.FRANCE));
        userContactBooks.put("0700000700", new User("Estelle", Region.MARTINIQUE));

        System.out.println();
        printUserContacts(userContactBooks);
    }

    private static void printUserContacts(Map<String, User> phones) {
        for (Map.Entry<String, User> entry : phones.entrySet()) {
            System.out.println("Nom : " + entry.getValue().getFirstName() + "=> Téléphone : " + formatPhoneNumber(entry.getValue().getRegion(), entry.getKey()));
        }
    }

    private static String formatPhoneNumber(Region region, String phoneNumber) {
        StringBuilder sb = new StringBuilder();
        sb.append(region.getAreaCode());
        for (int i = 0; i < phoneNumber.length(); i++) {
            sb.append(phoneNumber.charAt(i));
            if (i % 2 == 1 && i != phoneNumber.length() - 1) {
                sb.append(".");
            }
        }
        return sb.toString().replaceFirst("0", "(0)");
    }

    // Méthode pour afficher le carnet de contacts
    private static void printContacts(Map<String, String> phones) {
        for (Map.Entry<String, String> entry : phones.entrySet()) {
            System.out.println("Nom : " + entry.getKey() + "=> Téléphone : " + formatPhoneNumber(entry.getValue()));
        }
    }

    private static String formatPhoneNumber(String phoneNumber) {
        StringBuilder formattedNumber = new StringBuilder();
        for (int i = 0; i < phoneNumber.length(); i++) {
            formattedNumber.append(phoneNumber.charAt(i));
            if (i % 2 == 1 && i != phoneNumber.length() - 1) {
                formattedNumber.append(".");
            }
        }
        return formattedNumber.toString();
    }
}
