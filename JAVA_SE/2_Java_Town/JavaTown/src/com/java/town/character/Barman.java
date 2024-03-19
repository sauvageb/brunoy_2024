package com.java.town.character;

import com.java.town.character.base.Human;

public class Barman extends Human {

    private String barName;

    public Barman(String name) {
        this(name, name);
    }

    public Barman(String name, String barName) {
        super(name, "vin");
        this.barName = "Chez " + barName;
    }

    public void serve(Human human) {
        this.speak("Voilà votre boisson " + human.getName() + " !");
    }

    @Override
    public void introduce() {
        super.introduce();
        this.speak("Oh..et mon bar c'est " + this.barName);
    }

    @Override
    public void speak(String text) {
        super.speak(text + ", Coco");
    }
}
