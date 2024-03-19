package com.java.project.exceptions.exo6;

public class Exo6 {

    public static void main(String... params){
        try {
            AdresseIP addressIP = new AdresseIP(240, 235, 654, 236);
            System.out.println(addressIP);
        } catch (ExceptionAdrIP e) {
            System.out.println(e.getMessage());
        }

        try {
            AdresseIP addressIP = new AdresseIP(192, 168, 1, 1);
            System.out.println(addressIP);
        } catch (ExceptionAdrIP e) {
            System.out.println(e.getMessage());
        }
    }
}
