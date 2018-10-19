/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuctt;


/**
 *
 * @author Thien Phuc
 */
public class Test {
    public static void main(String[] args) {
        StudentList s = new StudentList();
        try {
            s.readFile();
        } catch (Exception e) {
            System.out.println("File not found");
        }
        
        s.outMajor();
        
    }
}
