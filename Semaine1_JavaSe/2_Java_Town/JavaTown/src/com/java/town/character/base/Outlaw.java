package com.java.town.character.base;

import com.java.town.character.Cowboy;
import com.java.town.character.Lady;

public interface Outlaw {

    void beCaptured(Cowboy cowboy);

    void kidnap(Lady lady);

    double getRewards();

    String getName();

}
