/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huynd;

import huynd.studentInfo.StudentInfoAddition;
import huynd.studentInfo.StudentInfoRemoving;
import huynd.studentInfo.StudentInfoSearching;
import huynd.studentInfo.StudentMenu;
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
import phuctt.Student;
import phuctt.StudentList;
/**
 *
 * @author Lawliet
 */
public class Test {


    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException, InterruptedException, Exception {
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
        
        int choice;
        StudentList studentList = new StudentList();
        do {          
            System.out.println("");
            Menu.printAdminMenu();
            choice = ValidationHandler.getChoice(5);
            switch(choice) {
                case 1:
                    Student newStudent = StudentInfoAddition.addNewStudent();                   
                    if(newStudent != null) { studentList.addStudent(newStudent); }
                    Thread.sleep(1500);
                    break;
                case 3:
                    System.out.println("\n            - Enter Student's ID -");
                    System.out.print("    Remove: ");
                    if(StudentInfoRemoving.removeStudent()) {
                        Menu.printSuccessNotification("    " + "REMOVED SUCCESSFUL");
                    } else {
                        Menu.printFailedNotification("    " + "INVALID ID!");
                    }
                    
                    break;
                case 4:
                    System.out.println("\n            - Enter Student's ID -");
                    System.out.print("    " + "Search: ");// 2315
                    Student searchedStudent = StudentInfoSearching.searchStudent();
                    if(searchedStudent != null) {
                        StudentMenu.printStudentInfoForm(searchedStudent.getFullName(),
                                                        searchedStudent.getBirthDay(),
                                                        searchedStudent.getBirthMonth(),
                                                        searchedStudent.getBirthYear(),
                                                        searchedStudent.getGender(),
                                                        searchedStudent.getMajor());
                    } else {
                        Menu.printInvalidStament("    NOT FOUND!");
                    }
                    Thread.sleep(1500);
                    break;
            }
        } while (choice != 5);
        System.out.println("end");
        
        
    }
}
