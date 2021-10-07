/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Yohan Hmaiti
 */

package ex42;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    @DisplayName("Check if the generated array list was successfully filled with the input from the file")
    // Test the method used to build an array list gathering the elements
    // within the input file through passing the input file directory to it
    // then comparing the returned array list with a pre-made one that matches what's expected.
    public void inputHandlerTest() {

        // create an array list of type Strings to store the expected arraylist from the assignment
        // that we will use to compare the one returned from the InputHandler method
        ArrayList<String> testList = new ArrayList<String>();

        // Build the array list
        testList.add("Ling,Mai,55900");
        testList.add("Johnson,Jim,56500");
        testList.add("Jones,Aaron,46000");
        testList.add("Jones,Chris,34500");
        testList.add("Swift,Geoffrey,14200");
        testList.add("Xiong,Fong,65000");
        testList.add("Zarnecki,Sabrina,51500");

        // create Strings to hold the directory
        String inputdir = "/src/main/java/ex42/exercise42_input.txt";
        String generaldir = System.getProperty("user.dir") + inputdir;

        // test the method InputHandler and compare what it returns to the correct expected array list and see if they match
        Assertions.assertEquals(testList, App.InputHandler(generaldir));

    }

}