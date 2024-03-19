package com.java.project.exceptions.exo6;

public class AdresseIP {

    private int[] octet;

    public AdresseIP(int o1, int o2, int o3, int o4) throws ExceptionAdrIP {

        if (o1 < 0 || o1 > 255) {
            throw new ExceptionAdrIP("valeur incorrecte pour le premier octet");
        }
        if (o2 < 0 || o2 > 255) {
            throw new ExceptionAdrIP("valeur incorrecte pour le deuxième octet");
        }
        if (o3 < 0 || o3 > 255) {
            throw new ExceptionAdrIP("valeur incorrecte pour le troisième octet");
        }
        if (o4 < 0 || o4 > 255) {
            throw new ExceptionAdrIP("valeur incorrecte pour le quatrième octet");
        }
        octet = new int[]{o1, o2, o3, o4};
    }

    @Override
    public String toString() {

        return octet[0] + "." + octet[1] + "." + octet[2] + "." + octet[3];
    }


}
