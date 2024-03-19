package com.java.town;

import com.java.town.character.*;
import com.java.town.character.base.Human;
import com.java.town.character.base.PaleFace;

public class Story {

    public static void main(String[] args) {
        Human Toto = new Human("Toto");
        Toto.introduce();
        Toto.drink();

        Lady d1 = new Lady("Myrthille");
        d1.introduce();

        Brigand b1 = new Brigand("Roger");
        b1.introduce();
        b1.kidnap(d1);

        Cowboy c1 = new Cowboy("Lucky");
        c1.introduce();
        c1.shoot(b1);
        c1.release(d1);

        Barman barman1 = new Barman("Boris");
        barman1.introduce();
        barman1.serve(c1);

        Cowboy clint = new Sherif("Clint");

        CrookedCop ripoux = new CrookedCop("Bob");
        ripoux.introduce();
        ripoux.kidnap(d1);
        ripoux.release(d1);
        ripoux.shoot(ripoux);

        Indian i = new Indian("Gege");
        PaleFace paleFace = b1;
        i.scalp(paleFace);

    }
}
