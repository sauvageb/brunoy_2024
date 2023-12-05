package com.java.town.character.base;

public class Human {

    private String name;
    private String drink;

    public Human(String name) {
        this.name = name;
        this.drink = "eau";
    }

    protected Human(String name, String favoriteDrink) {
        this.name = name;
        this.drink = favoriteDrink;
    }

    public void speak(String text) {
        System.out.println(this.name + " - " + text);
    }

    public void introduce() {
        this.speak("Bonjour, je suis " + this.getName() + ", et j'adore drink de " + this.drink);
    }

    public void drink() {
        this.speak("Ah ! un bon verre de " + this.drink + "! GLOUPS !");
    }

    public String getName() {
        return name;
    }
}
