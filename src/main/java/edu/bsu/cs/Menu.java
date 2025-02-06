package edu.bsu.cs;

import java.util.Scanner;

public class Menu {


    public void dispalyMenu() {
        Scanner scanner = new Scanner(System.in);

        for(int round = 0; round < 5; round++){
            System.out.println("*".repeat(15) + " Welcome to Wikisearch " + "*".repeat(15));
            System.out.println("\nPut in the article's name: ");
            String articleName = scanner.nextLine();
        }

    }
}
