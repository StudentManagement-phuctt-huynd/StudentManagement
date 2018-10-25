/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuctt;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Thien Phuc
 */
public class Student {
    private String ID;
    private String lastName;
    private String firstName;
    private String fullName;
    private int birthDay;
    private int birthMonth;
    private int birthYear;
    private boolean gender;//true = male; false = female;
    private String major;
    private ArrayList<Subject> subjectList;

    public Student() {
        this.ID = null;
        this.lastName = null;
        this.firstName = null;
        this.birthDay = 1;
        this.birthMonth = 1;
        this.birthYear = 1990;
        this.gender = true;
        this.major = null;
        this.subjectList = null;
    }

    public Student(String ID, String lastName, String firstName, int birthDay, int birthMonth, int birthYear, boolean gender, String major, ArrayList<Subject> subjectList) {
        this.ID = ID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
        this.gender = gender;
        this.major = major;
        this.subjectList = subjectList;
    }
    
    
    public Student(String ID, String lastName, String firstName, int birthDay, int birthMonth, int birthYear, boolean gender, String major) {
        this.ID = ID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.fullName = lastName + " " + firstName;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
        this.gender = gender;
        this.major = major;
        subjectList = new ArrayList<>();
        this.subjectList.add(new Subject("English"));
        this.subjectList.add(new Subject("Math"));
        this.subjectList.add(new Subject("IT"));
    }

    @Override
    public String toString() {
        return "Student{" + "ID=" + ID + ", lastName=" + lastName + ", firstName=" + firstName + ", birthDay=" + birthDay + ", birthMonth=" + birthMonth + ", birthYear=" + birthYear + ", gender=" + gender + ", major=" + major + ", subjectList=" + subjectList + '}';
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public ArrayList<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(ArrayList<Subject> subjectList) {
        this.subjectList = subjectList;
    }
    
    public String getBirthdate() {
        return this.birthDay+ "/" +this.birthMonth+ "/" +this.birthYear;
    }
    
    public void setBirthdate(String birthdate) {
        String[] subStr = birthdate.split("/");
        this.birthDay = Integer.parseInt(subStr[0]);
        this.birthMonth = Integer.parseInt(subStr[1]);
        this.birthYear = Integer.parseInt(subStr[2]);
    }
}
