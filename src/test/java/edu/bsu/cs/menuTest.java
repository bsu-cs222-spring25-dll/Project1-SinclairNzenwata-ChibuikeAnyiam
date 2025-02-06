package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class menuTest {

    @Test
    public void testUserInput() {
        Menu menu = new Menu();
        String input = menu.displayMenu();
        Assertions.assertTrue("Eba");

    }
}
