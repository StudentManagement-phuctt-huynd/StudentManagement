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
public class StudentInfoRemoving {
    private static String enterRemovedIDStudent() {
        Scanner input = new Scanner(System.in);
        String removedStudentID = "";
        
        try {
            removedStudentID = input.nextLine();
        } catch(Exception e) {
            
        }
        
        return removedStudentID;
    }
    
    /**
     *
     * @return
     * @throws Exception
     */
    public static boolean removeStudent(String removedStudentID) throws Exception {
        StudentList studentList = new StudentList();
        //String removedStudentID = StudentInfoRemoving.enterRemovedIDStudent();
        
        return studentList.removeStudent(removedStudentID);
    }

}
