/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Yohan Hmaiti
 */

/*

    Create a program that generates a website skeleton with the following
    specifications:

    Prompt for the name of the site.
    Prompt for the author of the site.
    Ask if the user wants a folder for JavaScript files.
    Ask if the user wants a folder for CSS files.
    Generate an index.html file that contains the name of the site inside
    the <title> tag and the author in a <meta> tag.

 */

package ex43;

import java.util.*;
import java.io.*;

public class App {

    public static void main(String[] args) throws IOException {

        // create a scanner tool called scanner
        Scanner scanner = new Scanner(System.in);

        // create a string variable to store the work directory
        String directoryWork = (System.getProperty("user.dir") + "/src/main/java/ex43/");

        // variables declaration
        // name will store the name of the site inputted by the user
        // author will store the name of the author of the site
        // JavaScript will store the choice to either have a yes to build a Js file or no
        // CSS will store the choice to either have a css file or no
        String name;
        String author;
        String JavaScript;
        String CSS;

        // hold choices for either to build the files or no
        boolean JSCHOICE = false;
        boolean CSSCHOICE = false;

        // prompt the user for the website name:
        System.out.print("Site name: ");
        name = scanner.nextLine();

        // prompt the user for the website's author
        System.out.print("Author: ");
        author = scanner.nextLine();

        // prompt the user for their choice to either have a JS file or not
        System.out.print("Do you want a folder for JavaScript y or n? ");
        JavaScript = scanner.nextLine();

        // Set the JSCHOICE to 1 is the user wants a JS file to be created
        if (JavaScript.equals("y"))
            JSCHOICE = true;

        // prompt the user for their choice to either have a CSS file or not
        System.out.print("Do you want a folder for CSS y or n? ");
        CSS = scanner.nextLine();

        // Set the CSSCHOICE to 1 is the user wants a CSS file to be created
        if (CSS.equals("y"))
            CSSCHOICE = true;

        handleFileGeneratorDecisions(name, author, JSCHOICE, CSSCHOICE, directoryWork);

    }

    // create a function that will handle the file making decisions
    // and call the functions needed for each type of file that needs to be generated!
    public static void handleFileGeneratorDecisions(String name, String author, boolean choiceJS, boolean choiceCSS, String newDir) throws IOException {

        // update the directory
        newDir = newDir + "website/";

        // create a new file in the working directory that will be named after
        // the website name inputted by the user
        File file = new File(newDir + name);

        // check if the directory was created successfully otherwise print an error
        // to the screen for the user
        if (file.mkdirs()) {

            System.out.print("Created " + newDir + name);

        } else {

            System.out.print("(Error) There was a problem creating the new directory! Try Again!");

        }

        // update the directory to be within the newly created directory in the workspace for the website
        newDir = newDir + name;

        // call the html file generator and pass the appropriate parameters needed
        htmlGenerator(name, author, newDir);

        // check if the user wants a JS file
        // if true then call the JS generator function accordingly
        if(choiceJS == true) {

            jsGenerator(newDir);

        }

        // check if the user wants a CSS file
        // if true then call the CSS generator function accordingly
        if(choiceCSS == true) {

            cssGenerator(newDir);

        }

    }

    // function that generates an html file with the appropriate content within it
    public static String htmlGenerator(String name, String author, String newDirectory) throws IOException {

        // update the directory
        newDirectory = newDirectory + "/index.html";

        // create a new html file in the specified directory
        File newHTML = new File(newDirectory);

        // declare a buffered writer tool that will help write in the html file
        BufferedWriter scanner = new BufferedWriter(new FileWriter(newHTML));

        // set the format of the information that will be written within the html file
        String formatToPrintInHtml = String.format("<meta name=\"author\" content=\"%s\" />", author);

        // write the elements needed in the html file as specified using the format set
        scanner.write("<html>\n\t<head>\n\t\t<title>\n\t\t\t" + name + "\n\t\t</title>\n\t\t" + formatToPrintInHtml + "\n\t</head>");

        // close the buffered writer tool
        scanner.close();

        // confirm the creation of the html file to the screen along with
        // printing its directory
        System.out.print("\nCreated " + newDirectory);

        // return the directory for testing purposes mainly
        // to confirm that everything went successful
        return newDirectory;

    }

    // function that generates a CSS folder with the appropriate directions
    public static String cssGenerator(String newDirectory) {

        // update the directory
        newDirectory = newDirectory + "/css/";

        // used for the CSS folder creation
        File newCSS = new File(newDirectory);

        // check if the creation of the folder was successful
        // print the output accordingly
        if (newCSS.mkdirs()) {

            System.out.print("\nCreated " + newDirectory);

        } else {

            System.out.print("\n(Error) The directory for the CSS file was not generated successfully! Try Again!");

        }

        // return the directory for testing purposes mainly
        // to confirm that everything went successful
        return newDirectory;

    }

    // function that generates a JS folder with the appropriate directions
    public static String jsGenerator(String newDirectoryJS) {

        // update the directory
        newDirectoryJS = newDirectoryJS + "/js/";

        // used for the JS folder creation
        File newjs = new File(newDirectoryJS);

        // check if the creation of the folder was successful
        // print the output accordingly
        if (!newjs.mkdirs()) {

            System.out.print("\n(Error) The directory for the JS file was not created successfully! Try Again!");

        }else {

            System.out.print("\nCreated " + newDirectoryJS);

        }

        // return the directory for testing purposes mainly
        // to confirm that everything went successful
        return newDirectoryJS;

    }

}
