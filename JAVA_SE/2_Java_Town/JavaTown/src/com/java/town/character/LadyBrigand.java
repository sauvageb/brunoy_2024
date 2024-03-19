package com.java.town.character;

import com.java.town.character.base.Outlaw;

public class LadyBrigand extends Lady implements Outlaw {

    private int nbKidnappedLadies;
    private double rewards;
    private boolean isInJail;

    public LadyBrigand(String name) {
        super(name);
    }

    @Override
    public void beCaptured(Cowboy cowboy) {
        this.speak("Damned, je suis fait !" + cowboy.getName() + ", tu m'as eu !");
        this.isInJail = true;
    }

    @Override
    public void kidnap(Lady lady) {
        this.speak("Ah ah !" + lady.getName() + ", tu es mienne désormais");
        lady.beKidnapped(this);
        this.nbKidnappedLadies++;
        this.rewards += this.rewards;
    }

    @Override
    public double getRewards() {
        return this.rewards;
    }
}
