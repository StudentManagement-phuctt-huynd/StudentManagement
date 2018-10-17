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
public class Major {
    private String major;
    private int count;

    public Major() {
        this.major = null;
        this.count = 0;
    }

    public Major(String major) {
        this.major = major;
        this.count = 1;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getCount() {
        return count;
    }
    
    public void incrCount() {
        this.count++;
    }

    @Override
    public String toString() {
        return "Major{" + "major=" + major + ", count=" + count + '}';
    }
      
}
