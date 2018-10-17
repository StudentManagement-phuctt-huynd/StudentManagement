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
public class Subject {
    private String subject;
    private double mark;    

    public Subject() {
        this.subject = null;
        this.mark = 0;
    }

    public Subject(String subject, double mark) {
        this.subject = subject;
        this.mark = mark >= 0 ? mark : 0;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark>0 ? mark : 0;
    }
    
    
}
