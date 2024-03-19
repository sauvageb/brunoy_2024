package fr.sauvageboris.training.exercice9.map.model;

public enum Region {

    FRANCE("+33"),
    SUISSE("+41"),
    POLYNESIE("+689"),
    MARTINIQUE("+596"),
    INDONESIE("+62");

    private final String areaCode;

    Region(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaCode() {
        return areaCode;
    }
}
