/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Yohan Hmaiti
 */

package ex44;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    // check if the function called returns 0 whenever the product is not inside the JSON input file
    @Test
    @DisplayName("Check if the function JSONCHECKER returns 0 when the product is not in the file")
    public void JSONCHECKERTEST1() throws FileNotFoundException {

        // Build a string to store the input file JSON directory
        String inputDir= System.getProperty("user.dir") + "/src/main/java/ex44/exercise44_input.json";

        Assertions.assertEquals(0, App.JSONCHECKER("Watch", inputDir));

    }

    // check if the function called returns 1 whenever the product is inside the JSON input file
    @Test
    @DisplayName("Check if the function JSONCHECKER returns 1 when the product is in the file")
    public void JSONCHECKERTEST2() throws FileNotFoundException {

        // Build a string to store the input file JSON directory
        String inputDir= System.getProperty("user.dir") + "/src/main/java/ex44/exercise44_input.json";

        Assertions.assertEquals(1, App.JSONCHECKER("Doodad", inputDir));

    }

    // check if the function called returns 0 whenever the product is not inside the JSON input file
    @Test
    @DisplayName("Check if the function JSONCHECKER returns 0 when the product is not in the file")
    public void JSONCHECKERTEST3() throws FileNotFoundException {

        // Build a string to store the input file JSON directory
        String inputDir= System.getProperty("user.dir") + "/src/main/java/ex44/exercise44_input.json";

        Assertions.assertEquals(0, App.JSONCHECKER("Dog", inputDir));

    }

    // check if the function called returns 1 whenever the product is inside the JSON input file
    @Test
    @DisplayName("Check if the function JSONCHECKER returns 1 when the product is in the file")
    public void JSONCHECKERTEST4() throws FileNotFoundException {

        // Build a string to store the input file JSON directory
        String inputDir= System.getProperty("user.dir") + "/src/main/java/ex44/exercise44_input.json";

        Assertions.assertEquals(1, App.JSONCHECKER("Thing", inputDir));

    }

}