package com.training.exercice.comparator;

import com.training.exercice.model.Country;

import java.util.Comparator;

public class CountryComparator implements Comparator<Country> {

    @Override
    public int compare(Country c1, Country c2) {
        return c1.getName().compareTo(c2.getName());
    }

    @Override
    public Comparator<Country> reversed() {
        return (c1, c2) -> c2.getName().compareTo(c1.getName());
    }
}
