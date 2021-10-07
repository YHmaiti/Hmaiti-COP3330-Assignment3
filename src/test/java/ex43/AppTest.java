/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Yohan Hmaiti
 */

package ex43;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    // The tests applied through these functions will implicitly test if a directory website was made as a folder
    // since the files generated by these functions need to be within it.

    // The multiple needed files are generated in the main folder designated!!
    @Test
    @DisplayName("Check if the html file was created and filled successfully")
    public void htmlGeneratorTest() throws IOException {

        // create strings to hold the needed directories
        String FolderLocation = "/src/main/java/ex43/website/awesomeco";
        String folderdir = System.getProperty("user.dir") + FolderLocation;
        String indexdir = System.getProperty("user.dir") + "/src/main/java/ex43/website/awesomeco/index.html";
        String directoryWork = (System.getProperty("user.dir") + "/src/main/java/ex43/");

        // create strings to hold the name of the website and its author
        String website = "awesomeco";
        String author = "Max Power";

        // create the website directory first and the html file
        App.handleFileGeneratorDecisions(website,author, false, false, directoryWork);

        // test if the html file was generated successfully
        Assertions.assertEquals(indexdir, App.htmlGenerator(website, author, folderdir));
    }

    @Test
    @DisplayName("Check if the CSS folder was created and filled successfully")
    public void cssGeneratorTest() {

        // create strings to store the directories that will have the folder where the css folder will be
        // and another to store where the css folder is
        String websiteDir = "/src/main/java/ex43/website/awesomeco";
        String cssFile = "/src/main/java/ex43/website/awesomeco/css/";
        String generalFolderDirectory = System.getProperty("user.dir") + websiteDir;
        String innerDirectory = System.getProperty("user.dir") + cssFile;

        // test if the css folder was successfully generated in the right directory
        Assertions.assertEquals(innerDirectory, App.cssGenerator(generalFolderDirectory));
    }

    @Test
    @DisplayName("Check if the JavaScript folder was created and filled successfully")
    public void jsGeneratorTest() {

        // create strings to store the directories that will have the folder where the js folder will be
        // and another to store where the js folder is
        String websiteDir = "/src/main/java/ex43/website/awesomeco";
        String jsFile = "/src/main/java/ex43/website/awesomeco/js/";
        String generalFolderDirectory = System.getProperty("user.dir") + websiteDir;
        String innerDirectory = System.getProperty("user.dir") + jsFile;

        // test if the js folder was successfully generated in the right directory
        Assertions.assertEquals(innerDirectory, App.jsGenerator(generalFolderDirectory));
    }
}