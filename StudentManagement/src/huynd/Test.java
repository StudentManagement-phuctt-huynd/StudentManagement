/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huynd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import java.io.Console;
import java.io.IOException;
import java.util.Calendar;
/**
 *
 * @author Lawliet
 */
public class Test {


    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException {
//        Scanner reader = new Scanner(System.in, "utf-8");  // Reading from System.in
//        System.out.println("Enter a number: ");
//        String n = reader.nextLine(); // Scans the next token of the input as an int.
//        
//        PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
//        writer.println(n);
//        writer.close();
//        
//        
//        System.out.println(ValidationHandler.validateStudentName(n));
//        //once finished
//        reader.close();
//        
//        //System.out.println(ValidationHandler.validateStudentName("Nguyễn   duc huy"));
//        System.out.println(ValidationHandler.isLeafYear(2021));
//        System.out.println(ValidationHandler.isValidateDay(29, 2, 2016));
//      
        
        int choice;1
        
        do {
            System.out.println("");
            Menu.printAdminMenu();
            choice = ValidationHandler.getChoice(5);
            switch(choice) {
                case 1:
                    StudentInfoAddition.addNewStudent();
                    break;
            }
        } while (choice != 5);
        System.out.println("end");
        
        
    }
}
