/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huynd;

import huynd.studentInfo.StudentInfoAddition;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author Lawliet
 */
public class ValidationHandler {
    
    public static String validateStudentName(String studentName) { 
        studentName = studentName.replaceAll("[^A-Za-zá-ỹÁ-Ỹ ]+", "");
        studentName = studentName.replaceAll(" +", " ");
        
        int spaces = StringHandler.countSpaces(studentName);
        if(studentName.isEmpty() || spaces < 1) { return ""; }
        if(StudentInfoAddition.getFirstName(studentName).length() < 1 || StudentInfoAddition.getLastName(studentName).length() < 2) {
            return "";
        }
        
        
        if(studentName.charAt(0) == ' ') {
            studentName = studentName.substring(1);
        }
        if(studentName.charAt( studentName.length() - 1) == ' ' ) {
            studentName = studentName.substring(0, studentName.length() - 1);
        }
        
        String[] subString = studentName.split(" ");
        for (int i = 0; i <= spaces; i++) {
            if ( (StringHandler.countVowel(subString[i]) < 1 || StringHandler.countConsonant(subString[i]) < 2) && subString[i].length() >= 5) { return ""; }
            else if ( (StringHandler.countVowel(subString[i]) < 1 || StringHandler.countConsonant(subString[i]) < 1) && subString[i].length() >= 3) { return ""; }
            else if ( (StringHandler.countVowel(subString[i]) < 1 || StringHandler.countConsonant(subString[i]) < 1) && subString[i].length() >= 2) { return ""; }
            else if (StringHandler.countVowel(subString[i]) < 1 && subString[i].length() == 1) { return ""; }
        }
        
        
        studentName = studentName.toLowerCase();
        
        
         // upper case the first character each words
        studentName = studentName.substring(0, 1).toUpperCase() + studentName.substring(1);
         for (int i = 1; i < studentName.length(); i++) {
            if(studentName.charAt(i) == ' ') {
                studentName = studentName.substring(0, i+1) + studentName.substring(i+1, i+2).toUpperCase() + studentName.substring(i+2);
            }
        }
        
         return studentName;
    }
    
    public static void makeTextAlignment(int spaces) {
        for (int i = 0; i < spaces; i++) {
            System.out.print(" ");
        }
    }
    
    public static int getChoice(int maxChoice) {
        Scanner input = new Scanner(System.in);
        int choice = -1;
        do {
            try {
                choice = input.nextInt();
            } catch(Exception e) {
                input.nextLine();
            }
            if(choice == -1 || choice > maxChoice || choice < 1) {
                System.out.println(ConsoleColors.RED + "    Invalid input!" + ConsoleColors.RESET);
                Menu.printUserChoice();
            }
        } while(choice == -1 || choice > maxChoice || choice < 1);
        return choice;
    } 
    
    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            }
            else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (Exception e) {
                //  Handle any exceptions.
            }
    }

    
    public static boolean isCorrectDay(int day, int month, int year) {
        if(day == -1) { return true; } // too check validate
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return day >= 1 && day <= 31;
            case 2:
                if(ValidationHandler.isLeafYear(year)) {
                    return day >= 1 && day <= 29;
                } else {
                    return day >= 1 && day <= 28;
                }
            default:
                return day >= 1 && day <= 30;
        }
    }
    public static boolean isCorrectMonth(int month) {
        return (month >= 1 && month <= 12) || month == -1; // -1 for check validation
    }
    
    public static boolean isCorrectBirthYear(int birthYear) {
        int age = (int)(Calendar.getInstance().get(Calendar.YEAR)) - birthYear;
        return age >= 18 && age <= 80;
    }
    
    public static boolean isLeafYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
}
