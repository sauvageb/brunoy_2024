package com.training.exercice;

import com.training.exercice.comparator.CountryComparator;
import com.training.exercice.exception.ListEmptyException;
import com.training.exercice.model.Country;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // a
        System.out.println("a) Créer un programme Java qui crée une collection de pays (Classe Country avec un attribut name) puis alimenter cette collection avec quelques valeurs et afficher la taille de la collection");
        List<Country> countries = initCountries();
        System.out.println("La collection créée contient " + countries.size() + " pays");

        // b
        System.out.println("b) Compléter le programme pour afficher le contenu de la collection.");
        displayList(countries);

        // c
        System.out.println("c) Trouver une méthode pour vider la collection et modifier votre programme afin d’afficher un message lorsqu’elle est vide et afficher le contenu lorsqu’elle n’est pas vide.");
        countries.clear();
        try {
            displayList(countries);
        } catch (ListEmptyException e) {
            System.err.println(e.getMessage());
        }

        // d
        System.out.println("d) Après avoir de nouveau alimenté votre liste de pays, modifiez le nom d’un pays et affichez de nouveau la liste des pays.");
        countries = initCountries();
        countries.set(0, new Country("FRANCE"));

        // e
        System.out.println("e) Triez votre collection et réaffichez la liste des pays.");
        displayList(countries);

        // Solution 1
        Collections.sort(countries, new CountryComparator());
        // Solution 2 (Avec Classe anonyme)
        Collections.sort(countries, new Comparator<Country>() {
            @Override
            public int compare(Country c1, Country c2) {
                return c1.getName().compareTo(c2.getName());
            }
        });
        // Solution 2 Bis (Avec Classe anonyme + écriture Lambda)
        countries.sort((c1, c2) -> c1.getName().compareTo(c2.getName()));
        // Solution 2 Bis (Avec Classe anonyme + écriture Lambda + Methodes Références)
        countries.sort(Comparator.comparing(Country::getName));

        // Tri inversé
        System.out.println("Tri inversé");
        displayList(countries);
        countries.sort(new CountryComparator().reversed());
        displayList(countries);

        // f
        System.out.println("f) Tri du plus petit au plus grand mot");
        // Solution 1
        countries.sort((Comparator<Country>) (c1, c2) -> {
            return c1.getName().length() - c2.getName().length();
        });
        // Solution 2
        countries.sort(Comparator.comparingInt(c -> c.getName().length()));

        // g
        System.out.println("g) Gestion des exceptions");
        displayList(countries);

    }


    private static List<Country> initCountries() {
        List<Country> countries = new ArrayList<>();
        countries.add(new Country("France"));
        countries.add(new Country("Allemagne"));
        countries.add(new Country("USA"));
        countries.add(new Country("Chine"));
        return countries;
    }

    public static void displayList(List<Country> list) {
        System.out.println("#### \n");
        if (list.isEmpty()) {
            throw new ListEmptyException();
        }
        list
                .stream()
                .forEach(country -> System.out.println(country.getName()));
        System.out.println("#### \n");
    }

}
