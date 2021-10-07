/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Yohan Hmaiti
 */

package ex46;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    @DisplayName("Check if the generated map is correct with the right words as keys and their right frequency as value")
    public void inputHandler() throws IOException {

        // create a map that will contain the right words as a key and the value will be
        // the expected word's frequency
        Map<String, Integer> testMap = new HashMap<String, Integer>();

        // add to testMap the correct expected keys and their respective values
        testMap.put("snake", 1);
        testMap.put("mushroom", 2);
        testMap.put("badger", 7);

        // create a map that will be store what's returned from the method we are testing
        Map<String, Integer> mytMap = new HashMap<String, Integer>();

        // create an array list to store the input
        ArrayList<String> inputList = new ArrayList<>();

        // create a string to store the input file directory
        String Inputdirectory = System.getProperty("user.dir") + "/src/main/java/ex46/exercise46_input.txt";

        // declare a string that will store the current scanned input
        String current;

        // create a file reader tool and a buffered reader tool
        FileReader file = new FileReader(Inputdirectory);
        BufferedReader scanner = new BufferedReader(file);

        // read from the file until the end
        while ((current = scanner.readLine()) != null){

            inputList.add(current);

        }

        mytMap = App.InputHandler(inputList);

        Assertions.assertEquals(testMap, mytMap);

    }


    @Test
    @DisplayName("Check if the generated map doesnt have any wrong values for the wrong keys")
    public void inputHandler2() throws IOException {

        // create a map that will contain the right words as a key and the value will be
        // the expected word's frequency
        Map<String, Integer> testMap = new HashMap<String, Integer>();

        // add to testMap the correct expected keys and their respective values
        testMap.put("snake", 2);
        testMap.put("badger", 2);
        testMap.put("snake", 7);

        // create a map that will be store what's returned from the method we are testing
        Map<String, Integer> mytMap = new HashMap<String, Integer>();

        // create an array list to store the input
        ArrayList<String> inputList = new ArrayList<>();

        // create a string to store the input file directory
        String Inputdirectory = System.getProperty("user.dir") + "/src/main/java/ex46/exercise46_input.txt";

        // declare a string that will store the current scanned input
        String current;

        // create a file reader tool and a buffered reader tool
        FileReader file = new FileReader(Inputdirectory);
        BufferedReader scanner = new BufferedReader(file);

        // read from the file until the end
        while ((current = scanner.readLine()) != null){

            inputList.add(current);

        }

        mytMap = App.InputHandler(inputList);

        Assertions.assertNotEquals(testMap, mytMap);

    }


    @Test
    @DisplayName("Check if the generated map doesnt have any wrong values for the wrong keys")
    public void inputHandler3() throws IOException {

        // create a map that will contain the right words as a key and the value will be
        // the expected word's frequency
        Map<String, Integer> testMap = new HashMap<String, Integer>();

        // add to testMap the correct expected keys and their respective values
        testMap.put("snake", 7);
        testMap.put("mushroom", 1);
        testMap.put("badger", 2);

        // create a map that will be store what's returned from the method we are testing
        Map<String, Integer> mytMap = new HashMap<String, Integer>();

        // create an array list to store the input
        ArrayList<String> inputList = new ArrayList<>();

        // create a string to store the input file directory
        String Inputdirectory = System.getProperty("user.dir") + "/src/main/java/ex46/exercise46_input.txt";

        // declare a string that will store the current scanned input
        String current;

        // create a file reader tool and a buffered reader tool
        FileReader file = new FileReader(Inputdirectory);
        BufferedReader scanner = new BufferedReader(file);

        // read from the file until the end
        while ((current = scanner.readLine()) != null){

            inputList.add(current);

        }

        mytMap = App.InputHandler(inputList);

        Assertions.assertNotEquals(testMap, mytMap);

    }

}