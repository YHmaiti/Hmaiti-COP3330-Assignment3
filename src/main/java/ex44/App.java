/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Yohan Hmaiti
 */

// The program that takes a product name as input and retrieves
// the current price and quantity for that product.
// The product data is in a data file in the JSON format
// Print out the product name, price, and quantity if the product
// is found. If no product matches the search, state that no product was found and start over
package ex44;

import com.google.gson.*; // used to interact with JSON type file
import java.io.*;
import java.util.*;

public class App {

    public static void main(String[] args) throws FileNotFoundException {
        //declare a scanner tool called scanner
        Scanner scanner = new Scanner(System.in);
        // create a string to store the directory of the input file
        String directory = System.getProperty("user.dir") + "/src/main/java/ex44/exercise44_input.JSON";

        // create a string that will store the name of the product
        // that we will be looking for within the input JSON file
        String element;

        // prompt the user for the product name
        System.out.print("What is the product name? ");
        element = scanner.nextLine();

        // loop until there is a found product
        // this decision id made through calling the JSONCHECKER function
        while(JSONCHECKER(element,directory) == 0) {

            System.out.println("Sorry, that product was not found in our inventory.");
            System.out.print("What is the product name? ");
            element = scanner.nextLine();

        }

    }

    // create a function that checks if an element is within the JSON file
    public static int JSONCHECKER(String element, String newDir) throws FileNotFoundException {
        // create a variable to be used to make a return decision
        int checkNoProblem = 0;

        // counter
        int i = 0;

        // create a Gson tool to help interpret the JSON file
        Gson gson = new Gson();

        // create a Reader tool and implement a try catch error approach
        try(Reader readerTool = new FileReader(newDir)) {

            // Build a JSON element and a JSON object
            // using a class representing an element of JSOn
            JsonElement jE = gson.fromJson(readerTool, JsonElement.class);
            JsonObject Name = jE.getAsJsonObject();

            // build a json type array of the products available
            JsonArray arr = Name.get("products").getAsJsonArray();

            // iterate through the whole array and print accordingly and update
            // checkNoProblem accordingly
            while (i < arr.size()) {

                String names = arr.get(i).getAsJsonObject().get("name").getAsString();

                // check if the element given by the user is within the json file
                if (names.equals(element)) {

                    System.out.println("Name: " + arr.get(i).getAsJsonObject().get("name").getAsString());
                    System.out.println("Price: " + arr.get(i).getAsJsonObject().get("price").getAsString());
                    System.out.print("Quantity: " + arr.get(i).getAsJsonObject().get("quantity").getAsString());

                    // update the checkNoProblem to 1 if found
                    checkNoProblem = 1;

                }

                i++;

            }

        }catch (IOException exception){

            exception.printStackTrace();

        }

        // return 1 or 0 depending on the value of checkNoProblem
        // which signifies for 1 that everything was successful and some
        // element was found otherwise 0
        return checkNoProblem;

    }


}
