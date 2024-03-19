package com.java.town.character;

import com.java.town.character.base.Outlaw;

public class Sherif extends Cowboy {

    private int nbBrigandCaptured;

    public Sherif(String name) {
        super(name);
    }

    public void capture(Outlaw outlaw) {
        this.speak("Au nom de la loi, je vous arrête !");
        outlaw.beCaptured(this);
        nbBrigandCaptured++;
    }


    @Override
    public String getName() {
        return "Shérif " + super.getName();
    }

    @Override
    public void introduce() {
        super.introduce();
        this.speak("J'ai déjà coffré " + this.nbBrigandCaptured + " brigands");
    }

    public void lookingFor(Brigand brigand) {
        this.speak("OYEZ OYE BRAVE GENS !! " + brigand.getRewards() + "$ a qui arretera " + brigand.getName() + " mort ou vif !!");
    }
}
