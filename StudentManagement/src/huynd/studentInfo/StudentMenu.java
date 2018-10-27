/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huynd.studentInfo;

import huynd.ValidationHandler;
import java.util.Iterator;
import java.util.TreeSet;
import phuctt.Student;
import phuctt.StudentList;

/**
 *
 * @author Lawliet
 */
public class StudentMenu {
    public static void printStudentInfoForm(String studentName, String ID, int birthDay, int birthMonth, int birthYear, boolean gender, String major) {
        String formTitle = " _____________________Student's Info Form_____________________";
        String fullNameTitle = " | \u2115 Full name : ";
        String IDTitle       = " | \u2605 ID        : ";
        String zodiacSymple = null;
        switch (birthMonth) {
            case 1: zodiacSymple = (birthDay >= 21) ? "\u2652" : "\u2651"; break;
            case 2: zodiacSymple = (birthDay >= 20) ? "\u2653" : "\u2652"; break;
            case 3: zodiacSymple = (birthDay >= 21) ? "\u2648" : "\u2649"; break;
            case 4: zodiacSymple = (birthDay >= 21) ? "\u2649" : "\u2648"; break;
            case 5: zodiacSymple = (birthDay >= 22) ? "\u264A" : "\u2649"; break;
            case 6: zodiacSymple = (birthDay >= 22) ? "\u264B" : "\u264A"; break;
            case 7: zodiacSymple = (birthDay >= 23) ? "\u264C" : "\u264B"; break;
            case 8: zodiacSymple = (birthDay >= 23) ? "\u264D" : "\u264C"; break;
            case 9: zodiacSymple = (birthDay >= 24) ? "\u264E" : "\u264D"; break;
            case 10: zodiacSymple = (birthDay >= 24) ? "\u264F" : "\u264E"; break;
            case 11: zodiacSymple = (birthDay >= 23) ? "\u2650" : "\u264F"; break;
            case 12: zodiacSymple = (birthDay >= 22) ? "\u2651" : "\u2650"; break;
        }
        
        String birthDayTitle = " | " + zodiacSymple + " Birthday  : ";
        String birthDayStr   = String.valueOf(birthDay); 
        String birthMonthStr = String.valueOf(birthMonth); 
        String birthYearStr  = String.valueOf(birthYear); 
        String genderTitle   = " | \u26A5 Gender    : ";
        String genderStr     = ((gender) ? "Male" : "Female");
        String majorTitle    = " | \u25A4 Major     : "; // 2cb6
        
       
        System.out.println(" " + formTitle);
        System.out.print(fullNameTitle + studentName);
        ValidationHandler.makeTextAlignment(formTitle.length() - fullNameTitle.length() - studentName.length());
        System.out.println(" |");
        
        System.out.print(IDTitle + ID);
        ValidationHandler.makeTextAlignment(formTitle.length() - IDTitle.length() - ID.length());
        System.out.println(" |");
        
        //System.out.println(" | Birthdate : " + birthDay+"/"+birthMonth+"/"+birthYear);
        System.out.print(birthDayTitle + birthDayStr + "/" + birthMonthStr + "/" + birthYearStr);
        ValidationHandler.makeTextAlignment(formTitle.length() - birthDayTitle.length() - birthDayStr.length()-birthMonthStr.length()-birthYearStr.length() - 2 );
        System.out.println(" |");
        
        //System.out.println(" | Gender    : " + ((gender) ? "Male" : "Female"));
        System.out.print(genderTitle + genderStr);
        ValidationHandler.makeTextAlignment(formTitle.length() - genderTitle.length() - genderStr.length());
        System.out.println(" |");
        
        //System.out.println(" | Major     : " + major);
        System.out.print(majorTitle + major);
        ValidationHandler.makeTextAlignment(formTitle.length() - majorTitle.length() - major.length());
        System.out.println(" |");
        
        System.out.println(" |_____________________________________________________________|");
    }
    
    
    private static void designsStudentsList(String ID, String fullName, String birthDate, boolean gender) { // mark
        
    }
    public static void printStudentsList(StudentList studentList) {
        TreeSet<Student> studentTreeSet = studentList.getMajorList("IT");
        Student student;
        Iterator it = studentTreeSet.iterator();
        while(it.hasNext()) {
            student = (Student)(it.next());
            System.out.println(student.toString());
        }
    }
}
