/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Yohan Hmaiti
 */

package ex45;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    @DisplayName("Check if the generated arraylist has all 'utilize' words replaced with 'use' ")
    public void updateOutput() throws IOException {

        // set the directory to where we need to get the input file from
        String inputDir = System.getProperty("user.dir") + "/src/main/java/ex45/exercise45_input.txt";

        // create the first list to hold input that will be updated and then compared to the list created by updateOutput method
        ArrayList<String> testList1 = new ArrayList<>();
        // create a temporary list
        ArrayList<String> tmp = new ArrayList<>();

        testList1 = App.getInput(inputDir);

        int i = 0;

        // build a list as expected from the asignment and store it in tmp list
        while (i < testList1.size()) {

            String current = testList1.get(i).replace("utilize", "use");
            tmp.add(current);
            i++;
        }

        // create a second list to test after it stores the list returned by updateOutput method
        ArrayList<String> testList2 = new ArrayList<>();

        testList2 = App.UpdateOutput(App.getInput(inputDir),System.getProperty("user.dir") + "/src/main/java/ex45/" + "testfile2" );

        Assertions.assertEquals(testList2, tmp);
    }

    @Test
    @DisplayName("Check if the returned arrayList has all the input from the file well gathered")
    public void getInput() throws IOException {

        // set the directory to where we need to get the input file from
        String inputDir = System.getProperty("user.dir") + "/src/main/java/ex45/exercise45_input.txt";

        // create an arraylist that has the input information in to use to test if the getInput function works
        ArrayList<String> testList = new ArrayList<>();

        String current;

        // create a buffered reader tool that will help scan and read input from the input file
        BufferedReader scanner = new BufferedReader(new FileReader(inputDir));

        // while loop used to scan until the end of the content of the input file
        while ((current = scanner.readLine()) != null) {

            // add what is currently scanned to the list
           testList.add(current);

        }

        Assertions.assertEquals(testList, App.getInput(inputDir));

    }
}