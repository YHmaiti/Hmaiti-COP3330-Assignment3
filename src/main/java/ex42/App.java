/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Yohan Hmaiti
 */


//  The Program process the records from an input file and displays
//  the results formatted as a table, evenly spaced.

package ex42;

import java.util.*;
import java.io.*;

public class App {

    public static void main(String[] args) {

        // create strings to store the directory of the input file
        String directoryInput = System.getProperty("user.dir") + "/src/main/java/ex42/exercise42_input.txt";

        // create an array list to store the returned arrayList from the
        // InputHandler function
        ArrayList<String> InputList = new ArrayList<>();
        InputList = InputHandler(directoryInput);

        // create a format to output the components of the arrayList with
        String ExpectedFormat = "%1$-10s%2$-10s%3$-10s";

        // output to the screen as expected with a tabular format
        System.out.println(String.format(ExpectedFormat, "Last", "First", "Salary"));

        System.out.println("--------------------------");

        for (int i = 0; i < InputList.size(); i++) {

            // create an array that will store each line that has input
            // where the input is separated using split to remove the comma
            String[] SeparatedListComponents = (InputList.get(i)).split(",");

           // output with respect to the expected format
            System.out.println(String.format(ExpectedFormat, SeparatedListComponents[0], SeparatedListComponents[1], SeparatedListComponents[2]));

        }

    }

    // implement a method to build an array list gathering the elements
    // within the input file
    public static ArrayList<String> InputHandler(String inputtedFile) {

        // create an array list to store the input from the file
        ArrayList<String> inputArrayList = new ArrayList<>();

        // use try catch error approach to check if the reading and scanning
        // from the file input was successful
        try {

            // create a BufferedReader that will help scan and read input from the file
            BufferedReader scanner = new BufferedReader(new FileReader(inputtedFile));

            // create a string to help store the scanned element temporarily
            // then help add it to the array list
            String scannedInput;

            // loop to gather all input from the input file
            while ((scannedInput = scanner.readLine()) != null) {

                inputArrayList.add(scannedInput);

            }

            // catch any exception or error while scanning input from the file
        } catch (IOException e) {

            System.out.print("(Problem) There is a problem reading from the input file! Try Again!\n");

        }

        // check if the arrayList was filled successfully
        // if not print an error message and exit
        if (inputArrayList.isEmpty()) {

            System.out.print("(Problem) The list of inputs from the input file was not generated successfully! Try Again!\n");

            System.exit(-1);

        }

        // return the built arrayList to the caller after filling it with
        // the read input from the input file
        return inputArrayList;

    }


}
