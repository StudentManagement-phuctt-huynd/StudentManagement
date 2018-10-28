/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huynd.studentInfo;

import java.util.Scanner;
import phuctt.Student;
import phuctt.StudentList;

/**
 *
 * @author Lawliet
 */
public class StudentInfoSearching {
    private static String enterSearchedStudent() {
        Scanner input = new Scanner(System.in);
        String searchedStudentID = "";
        
        try {
            searchedStudentID = input.nextLine();
        } catch(Exception e) {
            
        }
        
        return searchedStudentID;
    }
    
    /**
     *
     * @return
     * @throws Exception
     */
    public static Student searchStudent() throws Exception {
        StudentList searchedStudentList = new StudentList();
        String searchedStudentID = StudentInfoSearching.enterSearchedStudent();
        Student searchedStudent;
        try {
            searchedStudent = searchedStudentList.findbyId(searchedStudentID);
        } catch(Exception e) {
            return null;
        }
        
        return searchedStudent;
    }

}
