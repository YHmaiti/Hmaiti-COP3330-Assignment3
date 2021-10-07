/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Yohan Hmaiti
 */

// Given an input file named `exercise45_input.txt`,
// read the file and look for all occurrences of the word utilize.
// Replace each occurrence with use. Write the modified file to a new
// file.

package ex45;

import java.util.*;
import java.io.*;

public class App {

    public static void main(String[] args) throws IOException {

        // declare a scanner tool
        Scanner scanner = new Scanner(System.in);

        // set the directory to where we need to get the input file from
        String inputDir = System.getProperty("user.dir") + "/src/main/java/ex45/exercise45_input.txt";

        // prompt the user for the name they want to use for the output file
        System.out.print("What is the output file name that you want? ");
        String outputFile = scanner.nextLine();

        // update the output file directory
        outputFile = System.getProperty("user.dir") + "/src/main/java/ex45/" + outputFile;

        // create an Array List to store the returned list from the function
        // that reads from the input file
        ArrayList<String> InputList = new ArrayList<>();
        InputList = getInput(inputDir);

        // create an arraylist that will store the updated list after calling the UpdateOutput method
        ArrayList<String> finalList = new ArrayList<>();

        // call the function that will replace 'utilize' by 'use'
        finalList = UpdateOutput(InputList, outputFile);
    }

    // function that will replace 'utilize' by 'use' and output to the appropriate file and directory
    public static ArrayList<String> UpdateOutput(ArrayList<String> input, String output) throws IOException {
        // counter
        int i = 0;
        String current;

        // hold the updated list
        ArrayList<String> update = new ArrayList<>();

        // create a Buffered Writer tool to help use write in the output file
        BufferedWriter writerTool = new BufferedWriter(new FileWriter(output));

        // loop until all the "utilize" are changed to "use"
        // and continuously print to the screen
        while (i < input.size()) {

            current = input.get(i).replace("utilize", "use");
            System.out.println(current);
            update.add(current);
            i++;
        }

        i = 0; // set i back to 0 to reuse the counter

        // loop until all the "utilize" are changed to "use"
        // and continuously write in the output file
        while (i < input.size()) {

            writerTool.write(String.valueOf(input.get(i).replace("utilize", "use")));
            writerTool.newLine();

            i++;

        }

        // close the buffered writer tool
        writerTool.close();

        // return the final arraylist for testing purposes
        return update;

    }

    // function that will get the input from th input file specified
    public static ArrayList<String> getInput(String currFile) {

        // declare an array list to store the input gathered from the file
        ArrayList<String> InputList = new ArrayList<>();

        // check if the Input List was filled or no
        boolean checkStatus = true;

        // create a string variable that will store what's temporarily scanned from the input file
        String current;

        // use a try catch error approach to handle any input output exception that can occur
        // and then notify the user accordingly with a message and exit
        try {

            // create a buffered reader tool that will help scan and read input from the input file
            BufferedReader scanner = new BufferedReader(new FileReader(currFile));

            // while loop used to scan until the end of the content of the input file
            while ((current = scanner.readLine()) != null) {

                // add what is currently scanned to the list
                InputList.add(current);

            }

            // catch any exception and output an error message
        } catch (IOException e) {

            System.out.print("(Error) There was a problem reading the file, please try again!");

        }

        // check if the array list was filled successfully
        checkStatus = InputList.isEmpty();

        // notify the user if the array list of input was not filled
        if (checkStatus) {

            System.out.println("Nothing was scanned from the file successfully, try again!");
            System.exit(-1);

        }

        // return the filled array List
        return InputList;

    }
}
