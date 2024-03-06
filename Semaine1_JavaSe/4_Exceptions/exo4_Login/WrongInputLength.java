package com.java.project.exceptions.exo3;

public class WrongInputLength extends Exception {

    public WrongInputLength() {
        super("Login or password must contain no more than 10 characters");
    }
}
