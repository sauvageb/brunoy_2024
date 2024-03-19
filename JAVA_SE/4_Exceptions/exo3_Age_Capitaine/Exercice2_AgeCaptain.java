package com.java.project.exceptions.exo2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercice2_AgeCaptain {

    public static void main(String[] args) {
        Exercice2_AgeCaptain exo2 = new Exercice2_AgeCaptain();

        boolean isOk = false;
        int nbTentatives = 0;
        while (!isOk) {
            try {
                exo2.getAgeCap();
                isOk = true;
            } catch (Exception e) {
                nbTentatives++;
                System.err.println("Essai infructueux nº" + nbTentatives + " : " + e.getMessage());
            }
        }
    }

    public void getAgeCap() throws Exception {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Saisir l'âge du capitaine :");
            int age = scanner.nextInt();
            if (age < 18 || age > 65) {
                throw new AgeCapException(age);
            } else {
                System.out.println("L'âge du capitaine est : " + age);
            }
        } catch (InputMismatchException e) {
            throw new Exception("L'âge du capitaine doit être un entier");
        }
    }

}
