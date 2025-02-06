package edu.bsu.cs;

import java.util.Scanner;

public class Menu {


    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("*".repeat(15) + " Welcome to Wikisearch " + "*".repeat(15));
        System.out.println("\nPut in the article's name: ");
        String articleName = scanner.nextLine();


    }
}
