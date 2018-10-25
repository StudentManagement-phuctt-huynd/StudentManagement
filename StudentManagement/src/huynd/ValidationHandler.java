/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huynd;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author Lawliet
 */
public class ValidationHandler {
    
    public static String validateStudentName(String studentName) { 
        studentName = studentName.replaceAll("[^A-Za-z ]+", "");
        studentName = studentName.replaceAll(" +", " ");
        
        
        //studentName = studentName.replaceAll("^(?:[\\p{L}\\p{Mn}\\p{Pd}\\'\\x{2019}]+\\s[\\p{L}\\p{Mn}\\p{Pd}\\'\\x{2019}]+\\s?)+$", "");
        if(studentName.isEmpty()) { return ""; }
        
        if(studentName.charAt(0) == ' ') {
            studentName = studentName.substring(1);
        }
        if(studentName.charAt( studentName.length() - 1) == ' ' ) {
            studentName = studentName.substring(0, studentName.length() - 1);
        }
        
        studentName = studentName.toLowerCase();
        char[] arr = studentName.toCharArray();
        
         // upper case first character each word
         arr[0] = Character.toUpperCase(arr[0]);
         for (int i = 1; i < arr.length; i++) {
            if(arr[i-1] == ' ') {
                arr[i] = Character.toUpperCase(arr[i]);
            }
        }
         
         //studentName = Arrays.toString(arr);
         studentName = String.valueOf(arr);
         return studentName;
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
