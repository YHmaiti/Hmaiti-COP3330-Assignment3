/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Yohan Hmaiti
 */

// The program reads input from a file and prints a sorted list
// to a designated output file and to the screen

package ex41;

import java.util.*;
import java.io.*;

public class App {

    public static void main(String[] args) {

        // create strings to store the directory of the input file
        // and to store the directory where the output file should be
        String directoryInput = System.getProperty("user.dir") + "/src/main/java/ex41/exercise41_input.txt";
        String directoryOutput = System.getProperty("user.dir") + "/src/main/java/ex41/exercise41_output.txt";

        // create an array list that will store the returned array list from the
        // inputHandlerWithSort function that returns a sorted arraylist of
        // information read from the input file after outputting it.
        ArrayList<String> sortedListOfInput = new ArrayList<>();
        sortedListOfInput = InputHandlerWithSort(directoryInput, directoryOutput);

        // print to the screen according to a specified output format
        // the printed list is sorted
        int total = sortedListOfInput.size();

        System.out.println("Total of " + total + " names");
        System.out.print("------------------\n");

        for (int j = 0; j < sortedListOfInput.size(); j++) {

            printOutput(sortedListOfInput.get(j));

        }

    }

    // implement a function to build an array list gathering the elements
    // within the input file and then sorting it and returning the arraylist
    public static ArrayList<String> InputHandlerWithSort(String inputtedDir,String outputtedDir) {

        // declare an array list to store the gathered
        // input from the input file in the mentioned directory
        ArrayList<String> inputList = new ArrayList<>();

        // create a counter
        int i = 0;

        // use a try catch approach to handle any error
        // within the process of reading the file containing input
        try {

            // create a bufferedReader to help gather information from the input file
            BufferedReader scanner = new BufferedReader(new FileReader(inputtedDir));

            // create a string variable to hold the read element from the file
            String scanned;

            // read from the input file all elements until the end of the file
            // and then store them continuously within the array list
            while ((scanned = scanner.readLine()) != null) {

                inputList.add(scanned);

            }

            // close the buffered writer
            scanner.close();

          // output an error message to the screen whenever there is an error reading
          // the input file.
        } catch (IOException e) {

            printOutput("(Problem) Check the inputted file! Reading Input Failed!");

        }

        // get the total of names in the list
        int total = inputList.size();

        // check if the scanning and reading from the input file was valid
        // if not print an error message and exit!
        if (inputList.isEmpty()) {

            printOutput("(Problem) Check the inputted file! Reading Input Failed!");
            System.exit(-1);

            // administer and execute an else statement to sort the information
            // scanned from the input file and stored in the array list 'inputList'
            // and output to the output file desired
        } else {

            // sort the inputList
            Collections.sort(inputList);

            // use a try catch error approach to handle any exceptions
            // or errors while writing to the output file
            try{

                // create a BufferedWriter to help write to the output file
                BufferedWriter scanner = new BufferedWriter(new FileWriter(outputtedDir));

                // print to the output file the same list format expected
                scanner.write("Total of "+ total +" names");
                scanner.newLine();
                scanner.write("------------------");
                scanner.newLine();

                // loop until the end of the previously generated array list
                // and write to the output file accordingly
                while (i < inputList.size()) {

                    scanner.write(inputList.get(i));

                    // new line
                    scanner.newLine();

                    i++;

                }

                // close the buffered writer
                scanner.close();

                // catch any error that can come up while writing to the output file
            } catch (IOException e) {

                printOutput("(Problem) Check the outputted file! Outputting to file failed!");

            }

        }

        // return the sorted arrayList to caller
        return inputList;

    }

    // create a function that is used to output to the screen
    public static void printOutput(String output){

        System.out.println(output);

    }

}
