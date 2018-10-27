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
import java.util.Iterator;
import java.util.TreeSet;
import phuctt.Student;
import phuctt.StudentList;
/**
 *
 * @author Lawliet
 */
public class Test {


    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException, InterruptedException, Exception {
        int choice;
        StudentList studentList = new StudentList();
        do {          
            System.out.println("");
            Menu.printAdminMenu();
            choice = ValidationHandler.getChoice(4);
            switch(choice) {
                case 1:
                    Student newStudent = StudentInfoAddition.addNewStudent();                   
                    if(newStudent != null) { studentList.addStudent(newStudent); }
                    Thread.sleep(1000);
                    break;
                case 2:
                    System.out.println("\n            - Enter Student's ID -");
                    System.out.print("    " + "\u2315 Search: ");// 2315
                    Student searchedStudent = StudentInfoSearching.searchStudent();
                    if(searchedStudent != null) {
                        StudentMenu.printStudentInfoForm(searchedStudent.getFullName(),
                                                        searchedStudent.getID(),
                                                        searchedStudent.getBirthDay(),
                                                        searchedStudent.getBirthMonth(),
                                                        searchedStudent.getBirthYear(),
                                                        searchedStudent.getGender(),
                                                        searchedStudent.getMajor());
                        System.out.println("    " + ConsoleColors.YELLOW + "\u2022 " + ConsoleColors.RESET + "Chooose option: 1. \u270E Edit  2. \u2212 Remove  3. \u21E4 Back");
                        Menu.printUserChoice();
                        choice = ValidationHandler.getChoice(3);
                        switch (choice) {
                            case 1:
                                System.out.println("    " + "\u270E Edit: " + "1. Name");
                                System.out.println("    " + "        " + "2. BirthDate");
                                System.out.println("    " + "        " + "3. Gender");
                                System.out.println("    " + "        " + "4. Major");
                                System.out.println("    " + "        " + "5. Mark");
                                Menu.printUserChoice();
                                choice = ValidationHandler.getChoice(5);
                                switch (choice) {
                                    case 1:
                                        //System.out.println("    " + "New student name: ");
                                        System.out.println("\n            - Enter new Student's name -");
                                        String newStudentFullName = StudentInfoAddition.addStudentName();
                                        
                                        if (studentList.editFirstName(StudentInfoAddition.getFirstName(newStudentFullName), searchedStudent.getID()) 
                                        &&  studentList.editLastName(StudentInfoAddition.getLastName(newStudentFullName), searchedStudent.getID())) {
                                            Menu.printSuccessNotification("Edit Successful!");
                                        }
                                        //studentList.editFirstName(newStudentFullName, searchedStudent.getID());
                                        //studentList.editLastName(newStudentFullName, searchedStudent.getID());
                                        break;
                                    case 2:
                                        System.out.println("\n            - Enter new Student's birthdate -");
                                        int newBirthYear  = StudentInfoAddition.addStudentBirthYear();
                                        int newBirthMonth = StudentInfoAddition.addStudentBirthMonth();
                                        int newBirthDay   = StudentInfoAddition.addStudentBirthDay(newBirthMonth, newBirthYear);
                                        if(studentList.editBirthdate(String.valueOf(newBirthDay)+"/"+String.valueOf(newBirthMonth)+"/"+String.valueOf(newBirthYear), searchedStudent.getID())) {
                                            Menu.printSuccessNotification("Edit Successful!");
                                        }
                                        break;
                                    case 3:
                                        System.out.println("\n            - Enter new Student's gender -");
                                        Menu.printGenderMenu();
                                        int newGender = StudentInfoAddition.addStudentGender();
                                        if(studentList.editGender((newGender == 1) ? "Nam" : "Nữ", searchedStudent.getID())) {
                                            Menu.printSuccessNotification("Edit Successful!");
                                        }
                                        break;
                                    case 4:
                                        System.out.println("\n            - Enter new Student's major -");
                                        Menu.printMajorMenu();
                                        String newMajor = StudentInfoAddition.addStudentMajor();
                                        if(studentList.editMajor(newMajor, searchedStudent.getID())) {
                                             Menu.printSuccessNotification("Edit Successful!");
                                        }
                                        break;
                                    case 5:
                                        System.out.println("\n            - Enter new Student's mark -");
                                        break;
                                    default:
                                        throw new AssertionError();
                                }
                                break;
                            case 2:
                                //System.out.println("\n            - Enter Student's ID -");
                                //System.out.print("    Remove: ");
                                if(StudentInfoRemoving.removeStudent(searchedStudent.getID())) {
                                    Menu.printSuccessNotification("REMOVED SUCCESSFUL");
                                } else {
                                    Menu.printFailedNotification("INVALID ID!");
                                }
                                    break;
                            case 3: 
                                break;
                        }
                    } else {
                        Menu.printFailedNotification("NOT FOUND!");
                    }
                    Thread.sleep(1000);
                    break;
                case 3:
                    StudentMenu.printStudentsList(studentList);
                    break;
            }
        } while (choice != 4);
        System.out.println("    " + "\u270B Good Bye. See You Again!!! \u270B"); // 263a
        Thread.sleep(1000);
    }
}
