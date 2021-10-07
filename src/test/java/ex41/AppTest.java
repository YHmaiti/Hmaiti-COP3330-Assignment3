/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Yohan Hmaiti
 */

package ex41;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    @DisplayName("check if the input handler function builds the array list correctly and sorts it well before returning")
    // implement a test method to test the inputHandlerWithSort function that returns an array list gathering the elements
    // within the input file and then sorting it and returning the arraylist at the end
    // the expected output file will also be generated for testing purposes
    public void inputHandlerWithSortTest() {

        // create an array list that we will build then use to compare to the one of the InputHandlerWithSort function
        ArrayList<String> testList = new ArrayList<String>();

        // Build the list in a sorted way that is expected in the assignment and from the method InputHandlerWithSort
        testList.add("Johnson, Jim");
        testList.add("Jones, Aaron");
        testList.add("Jones, Chris");
        testList.add("Ling, Mai");
        testList.add("Swift, Geoffrey");
        testList.add("Xiong, Fong");
        testList.add("Zarnecki, Sabrina");

        // create  Strings to store the input and output directories
        // then to be passed to the InputHandlerWithSort function to generate
        // the array lit
        String input = "/src/main/java/ex41/exercise41_input.txt";
        String output  = "/src/test/java/ex41/exercise41test_out.txt";
        String inputdirectory = System.getProperty("user.dir") + input;
        String outputdirectory = System.getProperty("user.dir") + output;

        // test the returned sorted list from InputHandlerWithSort if it matches the expected list "testList"
        Assertions.assertEquals(testList, App.InputHandlerWithSort(inputdirectory, outputdirectory));
    }

}