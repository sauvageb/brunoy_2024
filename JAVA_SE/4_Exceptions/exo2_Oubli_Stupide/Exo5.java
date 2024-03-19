package com.java.project.exceptions.exo5;

public class Exo5 {

    public static void main(String[] args) {
        int[] tab = null;
        try {
            System.out.println(tab[2]);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}
