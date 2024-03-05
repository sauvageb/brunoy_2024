package com.training.exercice;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        //create a HashSet and initialize it HashSet
        Set<String> colors = new HashSet<>();
        colors.add("Rouge");
        colors.add("Vert");
        colors.add("Bleu");
        colors.add("Cyan");
        System.out.println("Initialialisation de la HashSet colors : " + colors);

        colors.remove("Rouge");
        System.out.println("HashSet colors après suppression de la couleur Rouge : " + colors);

        Set<String> others = new HashSet<>();
        others.add("Jaune");
        others.add("Magenta");
        colors.addAll(others);
        System.out.println("HashSet colors après ajout de la 2nd Hashset (others): " + colors);

        colors.removeAll(others);
        System.out.println("HashSet colors après suppression de tous éléments contenus dans others" + colors);

        colors.removeIf(set -> set.contains("Vert"));
        System.out.println("HashSet colors après suppression de Vert SI colors contient Vert: " + colors);

        //delete all elements from the HashSet
        colors.clear();
        System.out.println("HashSet colors après avoir vidé les éléments " + colors);
    }
}
