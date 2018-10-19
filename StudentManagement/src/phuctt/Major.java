/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuctt;

import java.util.LinkedList;

/**
 *
 * @author Thien Phuc
 */
public class Major {
    private String major;
    private LinkedList<String> studentIdList;

    public Major() {
        this.major = null;
        this.studentIdList = new LinkedList<>();
    }

    public Major(String major, String studentId) {
        this.major = major;
        this.studentIdList = new LinkedList<>();
        studentIdList.add(studentId);
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    
    public LinkedList getStudentIdList() {
        return studentIdList;
    }
    
    public void addStudentId(String id) {
        this.studentIdList.add(id);
    }
    
    public int getSize() {
        return this.studentIdList.size();
    }

    @Override
    public String toString() {
        return "Major{" + "major=" + major + ", count=" + getSize() + '}';
    }
      
}
