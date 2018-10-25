/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huynd.studentInfo;

import huynd.ConsoleColors;
import huynd.Menu;
import huynd.ValidationHandler;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import phuctt.Student;

/**
 *
 * @author Lawliet
 */
public class StudentInfoAddition {
    private static String addStudentName()  {
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
    public static String getFirstName(String fullName) {
        String firstName = "";
        
        for (int i = (int)(fullName.length()) - 1; i >= 0; i--) {
            if(fullName.charAt(i) == ' ') {
                firstName = fullName.substring(i + 1);
                break;
            }
        }
        
        return firstName;
    }
    public static String getLastName(String fullName) {
        String lastName = "";
        
        for (int i = (int)(fullName.length()) - 1; i >= 0; i--) {
            if(fullName.charAt(i) == ' ') {
                lastName = fullName.substring(0, i);
                break;
            }
        }
        
        return lastName;
    }
    
    
    private static int addStudentBirthYear() {
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
    private static int addStudentBirthMonth() {
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
    private static int addStudentBirthDay(int birthMonth, int birthYear) {
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
    private static int addStudentGender() {
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
    private static String addStudentMajor() {
        Scanner input = new Scanner(System.in);
        int selection = -1;
        
        do {
            System.out.print("    " + ConsoleColors.DARK_BLUE + "\u2022 " + ConsoleColors.RESET + "Major       : ");
            try {
                selection = input.nextInt();
            } catch(Exception e) {
                input.nextLine();
            }
            if(selection != 1 && selection != 2 && selection != 3) {
                Menu.printInvalidStament("    " + "Invalid Major!");
            }
        } while(selection != 1 && selection != 2 && selection != 3);
        
        return (selection == 1) ? "Tourist" : ((selection == 2) ? "IT" : (selection == 3) ? "English" : "IT");
    }
    
//    public static void printStudentInfoForm(String studentName, int birthDay, int birthMonth, int birthYear, boolean gender, String major) {
//        String formTitle = " _____________________Student's Info Form_____________________";
//        String fullNameTitle = " | Full name : ";
//        String birthDayTitle = " | Birthdate : ";
//        String birthDayStr   = String.valueOf(birthDay); 
//        String birthMonthStr = String.valueOf(birthMonth); 
//        String birthYearStr  = String.valueOf(birthYear); 
//        String genderTitle   = " | Gender    : ";
//        String genderStr     = ((gender) ? "Male" : "Female");
//        String majorTitle    = " | Major     : ";
//        
//       
//        System.out.println(" " + formTitle);
//        System.out.print(fullNameTitle + studentName);
//        ValidationHandler.makeTextAlignment(formTitle.length() - fullNameTitle.length() - studentName.length());
//        System.out.println(" |");
//        
//        //System.out.println(" | Birthdate : " + birthDay+"/"+birthMonth+"/"+birthYear);
//        System.out.print(birthDayTitle + birthDayStr + "/" + birthMonthStr + "/" + birthYearStr);
//        ValidationHandler.makeTextAlignment(formTitle.length() - birthDayTitle.length() - birthDayStr.length()-birthMonthStr.length()-birthYearStr.length() - 2 );
//        System.out.println(" |");
//        
//        //System.out.println(" | Gender    : " + ((gender) ? "Male" : "Female"));
//        System.out.print(genderTitle + genderStr);
//        ValidationHandler.makeTextAlignment(formTitle.length() - genderTitle.length() - genderStr.length());
//        System.out.println(" |");
//        
//        //System.out.println(" | Major     : " + major);
//        System.out.print(majorTitle + major);
//        ValidationHandler.makeTextAlignment(formTitle.length() - majorTitle.length() - major.length());
//        System.out.println(" |");
//        
//        System.out.println(" |_____________________________________________________________|");
//    }
    
    
    /**
     *
     * @return
     * @throws java.io.FileNotFoundException
     * @throws java.io.UnsupportedEncodingException
     */
    public static Student addNewStudent() throws FileNotFoundException, UnsupportedEncodingException, IOException {
        int choice;
        String fullName = "";
        int birthDay, birthMonth, birthYear;
        boolean gender;
        String major = "";
        
        ValidationHandler.clearConsole();
        System.out.println("\n            - Enter Student's Info -");
        fullName = StudentInfoAddition.addStudentName();
        birthYear   = StudentInfoAddition.addStudentBirthYear();
        birthMonth  = StudentInfoAddition.addStudentBirthMonth();
        birthDay    = StudentInfoAddition.addStudentBirthDay(birthMonth, birthYear);
        Menu.printGenderMenu();
        gender      = (StudentInfoAddition.addStudentGender() == 1); // true is male, false is female
        Menu.printMajorMenu();
        major       = StudentInfoAddition.addStudentMajor();
        //System.out.println(major);
                    
        System.out.println("");
        StudentMenu.printStudentInfoForm(fullName, birthDay, birthMonth, birthYear, gender, major);
        System.out.println("");
                    
        Menu.printContinueOption("Do you want to add this student? ");
        Menu.printUserChoice();
                    
        choice = ValidationHandler.getChoice(2);
        if(choice == 1) {
            Menu.printSuccessNotification("ADD NEW STUDENT SUCCESSFUL!");
        } else {
            Menu.printFailedNotification("ADD NEW STUDENT FAILED!");
            return null;
        }
        
        String firstName = StudentInfoAddition.getFirstName(fullName);
        String lastName = StudentInfoAddition.getLastName(fullName);
        
        
        BufferedReader br = null;
        String ID = "";
        try {
            br = new BufferedReader(new FileReader("TestID.txt"));
            
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                try {
                    ID = Integer.toString(Integer.parseInt(sCurrentLine) + 1);
                } catch (Exception e) {
                    
                }
		//System.out.println("cur " + sCurrentLine);
            }
        } catch(FileNotFoundException e) {
            if(br != null) { br.close(); }
        }
        
        System.out.println("id: " + ID);
        
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("TestID.txt", "UTF-8");
            writer.print(ID);
            writer.close();
        } catch(FileNotFoundException | UnsupportedEncodingException e) {
            
        } finally {
            try {
                if(writer != null) { writer.close(); }
            } catch(Exception e) {
                
            }
        }
        
        Student newStudent = new Student(ID, lastName, firstName, birthDay, birthMonth, birthYear, gender, major);
        return newStudent;
    }
}
