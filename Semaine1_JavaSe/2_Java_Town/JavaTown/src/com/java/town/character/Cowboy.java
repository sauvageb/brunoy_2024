package com.java.town.character;

import com.java.town.character.base.Human;
import com.java.town.character.base.Outlaw;
import com.java.town.character.base.PaleFace;

public class Cowboy extends Human implements PaleFace {

    private int popularity;
    private String adjective;


    public Cowboy(String name) {
        super(name, "whisky");
        this.adjective = "vaillant";
    }

    public void shoot(Outlaw outlaw) {
        System.out.println("Le " + this.adjective + " " + this.getName() +
                " tire sur " + outlaw.getName() + ". PAN !");
        this.speak("Prend ça, rascal !");
    }

    @Override
    public void introduce() {
        super.introduce();
        this.speak("je suis vraiment " + this.adjective + " et j'ai déjà sauvé " + this.popularity + " dames !");
    }


    public void release(Lady lady) {
        lady.beReleased(this);
        this.popularity++;
    }

    @Override
    public void isScalped() {
        System.out.println("Aïe ma tête");
    }
}
