/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuctt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

/**
 *
 * @author Thien Phuc
 */
public class StudentList extends HashMap<String, Student> {
    private TreeMap<String, Major> majorList = new TreeMap<>();
    
    public void readFile() throws IOException {
        File f = null;
        BufferedReader br = null;

        try {
            f = new File("Data.csv");
            br = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF-16"));

            String line;
            int flag = 0;
            String subject[] = new String[3];
            
            while ((line = br.readLine()) != null) {
                String subStr[] = line.split("[\t]");

                if (flag == 0) {
                    subject[0] = subStr[7];
                    subject[1] = subStr[8];
                    subject[2] = subStr[9];
                    flag = 1;
                } else {
                    String ID = subStr[1];
                    String lastName = subStr[2];
                    String firstName = subStr[3];

                    //split birthdate
                    String subDate[] = subStr[4].split("[/]");
                    int birthDay = Integer.parseInt(subDate[0]);
                    int birthMonth = Integer.parseInt(subDate[1]);
                    int birthYear = Integer.parseInt(subDate[2]);

                    boolean gender = subStr[5].equalsIgnoreCase("nam") ? true : false;
                    String major = subStr[6];
                    
                    if (majorList.containsKey(major)) {
                        majorList.get(major).incrCount();
                    } else {
                        int count = 0;
                        Major m = new Major(major);
                        majorList.put(major, m);
                    }

                    ArrayList<Subject> subjectList = new ArrayList<>();
                    //generate mark
                    for (int i = 0; i < 3; i++) {
                        double mark = Double.parseDouble(subStr[i+7]);
                        Subject sb = new Subject(subject[i], mark);
                        subjectList.add(sb);
                    }
                    
                    //create object
                    Student st = new Student(ID, lastName, firstName, birthDay, birthMonth, birthYear, gender, major, subjectList);
                    
                    super.put(ID, st);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }

    public void outMajor() {
        Iterator it = majorList.keySet().iterator();
        while (it.hasNext()) {
            System.out.println(majorList.get(it.next()).toString());
        }
    }
}
