/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huynd.studentInfo;

import huynd.ValidationHandler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
import phuctt.Major;
import phuctt.Student;
import phuctt.StudentList;
import phuctt.Subject;

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
        String birthMonthStr = (birthDay < 10) ? "0" + String.valueOf(birthMonth) : String.valueOf(birthMonth); 
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
    
    

    public static void printStudentsList(StudentList studentList, String majorList) {
        TreeSet<Student> studentTreeSet = studentList.getMajorList(majorList);
        
        Student student;
        Iterator it = studentTreeSet.iterator();
        
        System.out.println("    ID              Full Name               Birthday    Gender     Major    English    Math     IT");
        System.out.println("------------------------------------------------------------------------------------------------------");
        while(it.hasNext()) {
            student = (Student)(it.next());
            
            System.out.print(student.getID());
            ValidationHandler.makeTextAlignment(12 - student.getID().length());
            
            System.out.print(student.getFullName());
            ValidationHandler.makeTextAlignment(32 - student.getFullName().length());
            
            System.out.print(student.getBirthdate());
            ValidationHandler.makeTextAlignment(12 - student.getBirthdate().length());
            
            System.out.print(student.getGender() ? "Male" : "Female");
            ValidationHandler.makeTextAlignment(12 - (student.getGender() ? "Male" : "Female").length());
            
            System.out.print(student.getMajor());
            ValidationHandler.makeTextAlignment(10 - student.getMajor().length());
            
            
            System.out.print(student.getSubjectList().get(0).getMark());
            ValidationHandler.makeTextAlignment(9 - String.valueOf(student.getSubjectList().get(0).getMark()).length());
            System.out.print(student.getSubjectList().get(1).getMark());
            ValidationHandler.makeTextAlignment(9 - String.valueOf(student.getSubjectList().get(1).getMark()).length());
            System.out.print(student.getSubjectList().get(2).getMark());
            
            System.out.println("");
            //System.out.println(student.toString());
        }
    }
    
    public static void printAllStudentsList(StudentList studentList) throws IOException {
        TreeMap<String, Major> studentTreeMap = studentList.getAllMajorList();
//        
//        for (int i = 0; i < 100; i++) {
//            System.out.println(studentTreeMap.);
//        }

                StudentList s = new StudentList();
//        try {
//            s.readFile();
//        } catch (IOException e) {
//            System.out.println("File not found");
//        }
//
//        ArrayList a = new ArrayList();
//        Subject sj = new Subject("math", 10);
//        a.add(sj);
//        sj = new Subject("IT", 4);
//        a.add(sj);
//        sj = new Subject("eng", 10);
//        a.add(sj);
//        Student st = new Student("2458", "Nguyễn Thị", "Doãn", 10, 10, 1990, false, "ITo", a);
//        
//        s.addStudent(st);
        TreeMap<String, Major> ts = s.getAllMajorList();
        Iterator it = ts.keySet().iterator();
        
        while (it.hasNext()) {
            System.out.println(ts.get(it.next()).toString());
        }
        
        //Scanner sc = new Scanner(System.in);
        //String ID = "102022288";
        //System.out.println("Major: ");
        //String major = sc.nextLine();
        //s.editMajor(major, ID);
        
        it = ts.keySet().iterator();
        
        while (it.hasNext()) {
            System.out.println(ts.get(it.next()).toString());
        }
    }
}
