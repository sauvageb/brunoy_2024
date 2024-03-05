package fr.sauvageboris.training.exercice9.map.model;


public class User {
    private String firstName;
    private Region region;

    public User(String firstName, Region region) {
        this.firstName = firstName;
        this.region = region;
    }

    public String getFirstName() {
        return firstName;
    }

    public Region getRegion() {
        return region;
    }
}
