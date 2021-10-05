/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Yohan Hmaiti
 */

// A program that reads in a file named `exercise46_input.txt`
// and counts the frequency of words in the file. Then constructs a
// histogram displaying the words and the frequency,
// and displays the histogram to the screen from the highest frequency word
// to the lowest frequency one

package ex46;

import java.io.*;
import java.util.*;

public class App {

    public static void main(String[] args) {

        // create a string to store the input file directory
        String Inputdirectory = System.getProperty("user.dir") + "/src/main/java/ex46/exercise46_input.txt";

        // declare a string that will store the current scanned input
        String current;

        // create an array list to store the input
        ArrayList<String> inputList = new ArrayList<>();

        // use a try catch error handling approach for IOException
        try {

            // create a file reader tool and a buffered reader tool
            FileReader file = new FileReader(Inputdirectory);
            BufferedReader scanner = new BufferedReader(file);

            // read from the file until the end
            while ((current = scanner.readLine()) != null){

                inputList.add(current);

            }

            // catch any Input Output exception
        } catch (IOException e) {

            e.printStackTrace();

        }

        // check if the filled array list is not empty
        if (inputList.isEmpty()) {

            System.out.println("The elements were not scanned properly from the input file! Try Again...");
            System.exit(-1);

        }

        // create a Map type data structure that will receive and store the filled map of the words and their count
        // the map will be filled through calling InputHandler Function
        Map<String, Integer> InputMap = new HashMap<String, Integer>();
        InputMap = InputHandler(inputList);

        // create lists that will be used to store the word and another for storing the frequency
        List<String> word = new ArrayList<>(InputMap.keySet());
        List<Integer> freq = new ArrayList<>(InputMap.values());

        // use the sort function to sort the elements of each list
        Collections.sort(word);
        Collections.sort(freq);

        // get the size
        int len = word.size()-1;

        // print the word and its frequency as expected in order from high to low in frequency
        // start from the end of the list to get the highest frequency word first
        for (int i = len; i >= 0 ; i--) {

            System.out.print(word.get(len-i)+":");

            for(int j = 0; j <freq.get(i); j++)

                System.out.print("*");

            // go to a new line
            System.out.print("\n");
        }

    }

    // function that creates a map with the key as the word itself and the value is the frequency of that word
    public static Map<String, Integer> InputHandler(ArrayList<String> inputList) {

        // counter
        int i = 0;

        // create a map that will be returned at the end containing the word as a key and the value will be
        // the word's frequency
        Map<String, Integer> inputMap = new HashMap<String, Integer>();

        // create a set in order to store the word temporarily to be used later to fill the map
        // after we use the set to get the count
        Set<String> tempSet = new HashSet<String>();

        while (i < inputList.size()) {

            // create an array to store the words while removing the space separating them and then storing
            // each word accordingly
            String[] helper = (inputList.get(i)).split(" ");

            // add the element to the temporary set
            for(int j = 0; j<helper.length; j++) {

                tempSet.add(helper[j]);

            }

            i++;
        }

        // use a for each loop to iterate through the set and then fill the input Map
        for (String counter: tempSet) {

            inputMap.put(counter,0);

        }

        i = 0;

        // while loop used to iterate to update the frequency of each word
        // and fill the bult map accordingly
        while (i < inputList.size()) {

            // temporary helper array
            String[] temp = (inputList.get(i)).split(" ");

            for(int j = 0; j < temp.length; j++)

                if (!tempSet.add(temp[j])) {

                    // for each loop used to iterate through the map and get entries
                    for (Map.Entry<String, Integer> current : inputMap.entrySet()) {

                        // comparison check
                        if (current.getKey().equals(temp[j])) {

                            current.setValue(current.getValue() + 1);

                        }

                    }

                }

            i++;
        }

        // return the created map after it was finalized
        return inputMap;

    }


}
