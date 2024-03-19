package com.java.town.character;

import com.java.town.character.base.Human;
import com.java.town.character.base.PaleFace;

public class Indian extends Human {

    private String totem;
    private int nbFeathers;

    public Indian(String name) {
        super(name, "jus de racine");
        this.totem = "Coyote";
    }

    @Override
    public void introduce() {
        super.introduce();
        this.speak("Mon totem est " + this.totem + ", et j'ai " + nbFeathers + " plumes");
    }

    @Override
    public void speak(String text) {
        super.speak(text + " Ugh !");
    }

    public void scalp(PaleFace paleFace) {
        paleFace.isScalped();
        nbFeathers++;
    }

}
