/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huynd.studentInfo;

import huynd.ValidationHandler;

/**
 *
 * @author Lawliet
 */
public class StudentMenu {
        public static void printStudentInfoForm(String studentName, String ID, int birthDay, int birthMonth, int birthYear, boolean gender, String major) {
        String formTitle = " _____________________Student's Info Form_____________________";
        String fullNameTitle = " | Full name : ";
        String IDTitle       = " | ID        : ";
        String birthDayTitle = " | Birthdate : ";
        String birthDayStr   = String.valueOf(birthDay); 
        String birthMonthStr = String.valueOf(birthMonth); 
        String birthYearStr  = String.valueOf(birthYear); 
        String genderTitle   = " | Gender    : ";
        String genderStr     = ((gender) ? "Male" : "Female");
        String majorTitle    = " | Major     : ";
        
       
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
}
