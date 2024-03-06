package com.java.project.exceptions.exo3;

import java.util.Scanner;

public class Login {
    private static final String USERNAME = "scott";
    private static final String PASSWORD = "tiger";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean ok = false;
        do {
            try {
                System.out.println("Entrez le nom de l'utilisateur : ");
                String login = scanner.next();
                if (!login.equals(USERNAME))
                    throw new WrongLoginException();

                System.out.println("Entrez le mot de passe : ");
                String password = scanner.next();
                if (!password.equals(PASSWORD))
                    throw new WrongPwdException();

                if ((login.length() > 10) || (password.length() > 10))
                    throw new WrongInputLength();

                ok = true;
            } catch (WrongLoginException | WrongPwdException | WrongInputLength e) {
                System.out.println(e.getMessage());
            }
        } while (!ok);
        System.out.println("Welcome Scott");
        System.out.println("> ");
    }
}
