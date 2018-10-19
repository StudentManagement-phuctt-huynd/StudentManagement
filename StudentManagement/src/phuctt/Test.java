/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuctt;

import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author Thien Phuc
 */
public class Test {
    public static void main(String[] args) throws IOException {
        StudentList s = new StudentList();
        try {
            s.readFile();
        } catch (IOException e) {
            System.out.println("File not found");
        }
        
        ArrayList a = new ArrayList();
        Subject sj = new Subject("math", 10);
        a.add(sj);
        sj = new Subject("IT", 4);
        a.add(sj);
        sj = new Subject("eng", 10);
        a.add(sj);
        Student st = new Student("2458", "Nguyễn Thị", "Doãn", 10, 10, 1990, false, "ITo", a);
        
        s.addStudent(st);
        
        s.sortList();
        
    }
}
