package ui;

import myLib.UserMethods;

import java.nio.file.Path;
import java.util.Scanner;


public class MainMenu {

    private Scanner scanner = new Scanner(System.in);
    private boolean exitMenu = false;

    public void showMenu(){
        UserMethods userMethods = new UserMethods();
        do{
            userMethods.myPrinter("Choose an option: ");
            userMethods.myPrinter("1. Read XML file using DOM");
            userMethods.myPrinter("2. Read XML file using SAX");
            userMethods.myPrinter("3. Read XML file using JAXB");
            userMethods.myPrinter("4. Write XML file using JAXB");
            userMethods.myPrinter("0. Salir");
            processOption(requestOption());
        }while(!exitMenu);
    }
    private String requestOption(){
        return this.scanner.nextLine();
    }

    private void processOption(String option){
        UserMethods userMethods = new UserMethods();
        switch(option){
            case "0" -> exitMenu = true;
            case "1" -> {
                Path p = userMethods.fileToRead("Introduce the path to the file to be read with DOM: ");

            }
            case "2" -> {
                Path p = userMethods.fileToRead("Introduce the path to the file to be read with SAX: ");

            }
            case "3" -> {
                Path p = userMethods.fileToRead("Introduce the path to the file to be read with JAXB: ");
            }
            case "4" -> {
                Path p = userMethods.fileToWrite("Introduce the path for writing the file: ");

            }
            default -> userMethods.myPrinter("Wrong option.");
        }
    }
}
