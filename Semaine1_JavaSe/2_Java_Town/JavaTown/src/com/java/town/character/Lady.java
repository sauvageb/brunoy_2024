package com.java.town.character;

import com.java.town.character.base.Human;
import com.java.town.character.base.Outlaw;
import com.java.town.character.base.PaleFace;

public class Lady extends Human implements PaleFace {

    private String dressColor;
    private boolean isCaptive;

    public Lady(String name) {
        super(name, "lait");
        this.dressColor = "blanche";
    }

    public void beKidnapped(Outlaw outlaw) {
        this.speak("Au secouuurs !!");
        this.isCaptive = true;
    }

    @Override
    public void introduce() {
        super.introduce();
        this.speak("En passant, Ma robe " + this.dressColor + " est vraiment belle..");
    }

    public void changeDress(String dressColor) {
        this.dressColor = dressColor;
        this.speak("Regardez ma nouvelle robe " + this.dressColor + " !");
    }

    public void beReleased(Cowboy cowboy) {
        this.speak("Merci " + cowboy.getName() + " !");
        this.isCaptive = false;
    }

    @Override
    public String getName() {
        return "Miss " + super.getName();
    }

    @Override
    public void isScalped() {
        System.out.println("Aïe ma tête");
    }
}
