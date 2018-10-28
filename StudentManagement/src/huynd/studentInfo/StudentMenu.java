/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huynd.studentInfo;

import huynd.ValidationHandler;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;
import phuctt.Major;
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
            case 3: zodiacSymple = (birthDay >= 21) ? "\u2648" : "\u2653"; break;
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
        String birthDayStr   = (birthDay < 10) ? "0" + String.valueOf(birthDay) : String.valueOf(birthDay); 
        String birthMonthStr = (birthMonth < 10) ? "0" + String.valueOf(birthMonth) : String.valueOf(birthMonth); 
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
        
        System.out.print(birthDayTitle + birthDayStr + "/" + birthMonthStr + "/" + birthYearStr);
        ValidationHandler.makeTextAlignment(formTitle.length() - birthDayTitle.length() - birthDayStr.length()-birthMonthStr.length()-birthYearStr.length() - 2 );
        System.out.println(" |");
        
        System.out.print(genderTitle + genderStr);
        ValidationHandler.makeTextAlignment(formTitle.length() - genderTitle.length() - genderStr.length());
        System.out.println(" |");
        
        System.out.print(majorTitle + major);
        ValidationHandler.makeTextAlignment(formTitle.length() - majorTitle.length() - major.length());
        System.out.println(" |");
        
        System.out.println(" |_____________________________________________________________|");
    }
    
    
    private static void printStudentsListWithLayout(String ID, String fullName, String birthDay, boolean gender, String major, double english, double math, double IT) {
        
        
        System.out.print(ID);
            ValidationHandler.makeTextAlignment(12 - ID.length());
            
            System.out.print(fullName);
            ValidationHandler.makeTextAlignment(32 - fullName.length());
            
            System.out.print(birthDay);
            ValidationHandler.makeTextAlignment(12 - birthDay.length());
            
            System.out.print(gender ? "Male" : "Female");
            ValidationHandler.makeTextAlignment(12 - (gender ? "Male" : "Female").length());
            
            System.out.print(major);
            ValidationHandler.makeTextAlignment(10 - major.length());
            
            
            System.out.print(english);
            ValidationHandler.makeTextAlignment(9 - String.valueOf(english).length());
            System.out.print(math);
            ValidationHandler.makeTextAlignment(9 - String.valueOf(math).length());
            System.out.print(IT);
    }
    public static void printStudentsListByMajor(StudentList studentList, String majorList) {
        TreeSet<Student> studentTreeSet = studentList.getMajorList(majorList);
        
        Student student;
        Iterator it = studentTreeSet.iterator();
        
        while(it.hasNext()) {
            student = (Student)(it.next());
            printStudentsListWithLayout(student.getID(),
                                        student.getFullName(),
                                        student.getBirthdate(),
                                        student.getGender(),
                                        student.getMajor(),
                                        student.getSubjectList().get(0).getMark(),
                                        student.getSubjectList().get(1).getMark(),
                                        student.getSubjectList().get(2).getMark());
            System.out.println("");
        }
    }
    
    public static void printAllStudentsList(StudentList studentList) throws IOException {
//        TreeMap<String, Major> studentTreeMap = studentList.getAllMajorList();
//        for (Entry<String, Major> entry : studentTreeMap.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
        //Set<Entry<String, Student>> entryStudent = studentList.entrySet();
        for (Entry<String, Student> entryStudent : studentList.entrySet()) {
            
            StudentMenu.printStudentsListWithLayout(entryStudent.getKey(),
                                                    entryStudent.getValue().getFullName(),
                                                    entryStudent.getValue().getBirthdate(),
                                                    entryStudent.getValue().getGender(),
                                                    entryStudent.getValue().getMajor(),
                                                    entryStudent.getValue().getSubjectList().get(0).getMark(),
                                                    entryStudent.getValue().getSubjectList().get(1).getMark(),
                                                    entryStudent.getValue().getSubjectList().get(2).getMark());
            System.out.println("");
        }
    }
}
