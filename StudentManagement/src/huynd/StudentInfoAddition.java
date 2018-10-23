/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huynd;

import java.util.Scanner;
import phuctt.Student;

/**
 *
 * @author Lawliet
 */
public class StudentInfoAddition {
    public static String addStudentName()  {
        Scanner input = new Scanner(System.in, "utf-8");
        String fullName = "";
        
        do {
            System.out.print("    " + ConsoleColors.DARK_BLUE + "\u2022 " + ConsoleColors.RESET + "Full name   : ");
            try {
                fullName = input.nextLine();  
            } catch(Exception e) {
            
            }
            fullName = ValidationHandler.validateStudentName(fullName);
            if(fullName.isEmpty()) {
                Menu.printInvalidStament("    Invalid student name!");
            }
        } while(fullName.isEmpty());
        
        return fullName;
    }
    public static int addStudentBirthYear() {
        Scanner input = new Scanner(System.in);
        int birthYear = -1;
        
        do {
            System.out.print("    " + ConsoleColors.DARK_BLUE + "\u2022 " + ConsoleColors.RESET + "Birth year  : ");
            try {
                birthYear = input.nextInt();
            } catch (Exception e) {
                input.nextLine();
            }
            birthYear = (ValidationHandler.isCorrectBirthYear(birthYear)) ? birthYear : -1;
            if(birthYear == -1) {
                Menu.printInvalidStament("    Invalid birth year!");
            }
        } while(birthYear == -1);
        
        return birthYear;
    }
    public static int addStudentBirthMonth() {
        Scanner input = new Scanner(System.in);
        int birthMonth = -1;
        
        do {
            System.out.print("    " + ConsoleColors.DARK_BLUE + "\u2022 " + ConsoleColors.RESET + "Birth month : ");
            try {
                birthMonth = input.nextInt();
            } catch (Exception e) {
                input.nextLine();
            }
            birthMonth = (ValidationHandler.isCorrectMonth(birthMonth)) ? birthMonth : -1;
            if(birthMonth == -1) {
                Menu.printInvalidStament("    Invalid birth month!");
            }
        } while (birthMonth == -1);
        
        
        return birthMonth;
    }
    public static int addStudentBirthDay(int birthMonth, int birthYear) {
        Scanner input = new Scanner(System.in);
        int birthDay = -1;
        
        do {
            System.out.print("    " + ConsoleColors.DARK_BLUE + "\u2022 " + ConsoleColors.RESET + "Birth day   : ");
            try {
                birthDay = input.nextInt();
            } catch (Exception e) {
                input.nextLine();
            }
            birthDay = (ValidationHandler.isCorrectDay(birthDay, birthMonth, birthYear)) ? birthDay : -1;
            if(birthDay == -1) {
                Menu.printInvalidStament("    Invalid birth day!");
            }
        } while(birthDay == -1);
        
        return birthDay;
    }
    public static int addStudentGender() {
        Scanner input = new Scanner(System.in);
        int gender = -1;
        
        do {
            System.out.print("    " + ConsoleColors.DARK_BLUE + "\u2022 " + ConsoleColors.RESET + "Gender      : ");
            try {
                gender = input.nextInt();
            } catch(Exception e) {
                input.nextLine();
            }
            if(gender != 1 && gender != 2) {
                Menu.printInvalidStament("    Invalid!");
            }
        } while(gender != 1 && gender != 2);
        
        return gender; // male is true(data type)
    }
    public static String addStudentMajor() {
        Scanner input = new Scanner(System.in);
        int selection = -1;
        
        try {
            selection = input.nextInt();
        } catch(Exception e) {
            return "";
        }
        return (selection == 1) ? "Math" : ((selection == 2) ? "IT" : (selection == 3) ? "English" : "IT");
    }
    
    public static void printStudentInfoForm(String studentName, int birthDay, int birthMonth, int birthYear, boolean gender) {
        System.out.println(" __________________Student's Info Form__________________");
        System.out.println(" | Full name : " + studentName);
        System.out.println(" | Birthdate : " + birthDay+"/"+birthMonth+"/"+birthYear);
        System.out.println(" | Gender    : " + ((gender) ? "Male" : "Female"));
        System.out.println(" _______________________________________________________");
    }
    
    
    /**
     *
     * @return
     */
    public static Student addNewStudent() {
        int choice;
        String studentName = "";
        int birthDay, birthMonth, birthYear;
        boolean gender;
        String major = "";
        
        ValidationHandler.clearConsole();
        System.out.println("\n            - Enter Student's Info -");
        studentName = StudentInfoAddition.addStudentName();
        birthYear   = StudentInfoAddition.addStudentBirthYear();
        birthMonth  = StudentInfoAddition.addStudentBirthMonth();
        birthDay    = StudentInfoAddition.addStudentBirthDay(birthMonth, birthYear);
        Menu.printGenderMenu();
        gender      = (StudentInfoAddition.addStudentGender() == 1); // true is male, false is female
                    
        System.out.println("");
        StudentInfoAddition.printStudentInfoForm(studentName, birthDay, birthMonth, birthYear, gender);
        System.out.println("");
                    
        Menu.printContinueOption("Do you want to add this student? ");
        Menu.printUserChoice();
                    
        choice = ValidationHandler.getChoice(2);
        if(choice == 1) {
            Menu.printSuccessNotification("ADD NEW STUDENT SUCCESSFUL!");
        } else {
            Menu.printFailedNotification("ADD NEW STUDENT FAILED!");
        }
        Student o = new Student();
        return o;
    }
}
