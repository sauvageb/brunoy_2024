package com.java.town.character;

import com.java.town.character.base.Human;
import com.java.town.character.base.Outlaw;
import com.java.town.character.base.PaleFace;

public class Brigand extends Human implements Outlaw, PaleFace {

    private String look;
    private int nbKidnappedLadies;
    private double rewards;
    private boolean isInJail;

    public Brigand(String name) {
        super(name, "tord-boyaux");
        this.look = "méchant";
        this.rewards = 100;
    }

    @Override
    public void introduce() {
        super.introduce();
        this.speak("J'ai l'air " + this.look + " et j'ai déjà kidnappé " + this.nbKidnappedLadies + " dames !");
        this.speak("Ma tête est mise à prix à " + this.rewards + "$ !");
    }

    @Override
    public void beCaptured(Cowboy cowboy) {
        if (this.isInJail) {
            this.speak("Whatttt !! Je suis déjà en prisonn");
        } else {
            this.speak("Damned, je suis fait !" + cowboy.getName() + ", tu m'as eu !");
            this.isInJail = true;
        }
    }

    public void kidnap(Lady lady) {
        this.speak("Ah ah !" + lady.getName() + ", tu es mienne désormais");
        lady.beKidnapped(this);
        this.nbKidnappedLadies++;
        this.rewards += this.rewards;
    }

    public double getRewards() {
        return rewards;
    }


    @Override
    public String getName() {
        return super.getName() + " le " + this.look;
    }

    @Override
    public void isScalped() {
        System.out.println("Aïe ma tête");
    }
}
