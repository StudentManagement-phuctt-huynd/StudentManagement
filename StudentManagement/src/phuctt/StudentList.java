/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuctt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author Thien Phuc
 */
public class StudentList extends HashMap<String, Student> {

    private TreeMap<String, Major> majorList = new TreeMap<>();

    //read data from file
    public void readFile() throws IOException {
        File f = null;
        BufferedReader br = null;

        try {
            f = new File("Data.csv");
            br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));

            String line;
            int flag = 0;
            String subject[] = new String[3];

            while ((line = br.readLine()) != null) {
                String subStr[] = line.split("[\t]");

                if (flag == 0) {
//                    for (int i = 0; i < subStr.length; i++) {
//                        System.out.println("index: " + i + subStr[i]);
//                    }
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
                        majorList.get(major).addStudentId(ID);
                    } else {
                        Major m = new Major(major, ID);
                        majorList.put(major, m);
                    }

                    ArrayList<Subject> subjectList = new ArrayList<>();
                    //generate mark
                    for (int i = 0; i < 3; i++) {
                        double mark = Double.parseDouble(subStr[i + 7]);
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

    public boolean addStudent(Student s) throws IOException {
        if (majorList.containsKey(s.getMajor())) {
            majorList.get(s.getMajor()).addStudentId(s.getID());
        } else {
            Major m = new Major(s.getMajor(), s.getID());
            majorList.put(s.getMajor(), m);
        }
        boolean flag = true;
        super.put(s.getID(), s);

        flag = writeFile();
        return flag;
    }

    public boolean writeFile() throws IOException {
        File f;
        FileWriter fw = null;
        PrintWriter pw = null;
        boolean flag = false;

        try {
            f = new File("Data.csv");
            fw = new FileWriter(f, false);
            pw = new PrintWriter(fw);

            TreeSet<Student> ts = sortList();
            String header = "No\t" + "ID\t" + "LastName\t" + "FirstName\t"
                    + "DateOfBirth\t" + "Gender\t" + "Major\t" + "English\t" + "Math\t" + "IT";
            pw.println(header);
            int count = 1;
            Iterator it = ts.iterator();
            while (it.hasNext()) {
                Student s = (Student) it.next();
                pw.println(formatStrFile(s, count));
                count++;
            }

            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pw != null) {
                pw.close();
            }
            if (fw != null) {
                fw.close();
            }
        }
        return flag;
    }

    public TreeSet<Student> sortList() {
        TreeSet<Student> ts = new TreeSet(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                Collator myCo = Collator.getInstance(new Locale("vi"));
                if (myCo.compare(o1.getFirstName(), o2.getFirstName()) > 0) {
                    return 1;
                } else if (myCo.compare(o1.getFirstName(), o2.getFirstName()) < 0) {
                    return -1;
                } else {
                    if (myCo.compare(o1.getLastName(), o2.getLastName()) > 0) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
//                return 0;
            }
        });

        Iterator it = super.keySet().iterator();
        while (it.hasNext()) {
            Student s = super.get((String) it.next());
            ts.add(s);
        }

        return ts;
    }

    public String formatStrFile(Student s, int number) {
        String str;
        str = number + "\t";
        str += s.getID() + "\t";
        str += s.getLastName() + "\t";
        str += s.getFirstName() + "\t";
        str += s.getBirthdate() + "\t";
        str += (s.getGender() ? "Nam" : "Nữ") + "\t";
        str += s.getMajor() + "\t";

        for (int i = 0; i < s.getSubjectList().size(); i++) {
            str += s.getSubjectList().get(i).getMark();
            if (i != s.getSubjectList().size() - 1) {
                str += "\t";
            }
        }

        return str;
    }

    public boolean editFirstName(String fName, String id) throws IOException {
        Student s = super.get(id);
        if (s != null) {
            s.setFirstName(fName);
            super.replace(id, s);
            writeFile();
            return true;
        } else {
            return false;
        }
    }

    public boolean editLastName(String lName, String id) throws IOException {
        Student s = super.get(id);
        if (s != null) {
            s.setLastName(lName);
            super.replace(id, s);
            writeFile();
            return true;
        } else {
            return false;
        }
    }

    public boolean editBirthdate(String birthdate, String id) throws IOException {
        Student s = super.get(id);
        if (s != null) {
            s.setBirthdate(birthdate);
            super.replace(id, s);
            writeFile();
            return true;
        } else {
            return false;
        }
    }

    public boolean editGender(String gender, String id) throws IOException {
        Student s = super.get(id);
        if (s != null) {
            s.setGender(gender.equalsIgnoreCase("nam") ? true : false);
            super.replace(id, s);
            writeFile();
            return true;
        } else {
            return false;
        }
    }

    public boolean editMajor(String major, String id) throws IOException {
        Student s = super.get(id);
        if (s != null) {
            Major m = majorList.get(s.getMajor());
            m.removedStudentId(id);

            s.setMajor(major);
            m = majorList.get(major);
            m.addStudentId(id);

            super.replace(id, s);
            writeFile();
            return true;
        } else {
            return false;
        }
    }

    public int editMark(String subject, String id, double mark) throws IOException {
        Student s = super.get(id);
        //error code
        //0: success
        //1: not found id
        //2: not found subject
        if (s != null) {
            ArrayList<Subject> ar = s.getSubjectList();

            for (int i = 0; i < ar.size(); i++) {
                if (ar.get(i).getSubject().equalsIgnoreCase(subject)) {
                    ar.get(i).setMark(mark);

                    super.replace(id, s);
                    writeFile();

                    return 0;
                }
            }
            return 2;
        } else {
            return 1;
        }
    }

    public Student findbyId(String id) {
        return super.get(id);
    }

    public TreeMap<String, Major> getAllMajorList() {
        return majorList;
    }
    
    public Major getMajor(String major) {
        return majorList.get(major);
    }

    public TreeSet<Student> getMajorList(String major) {
        TreeSet<Student> ts = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                Collator myCo = Collator.getInstance(new Locale("vi"));              
                if (myCo.compare(o1.getFirstName(), o2.getFirstName()) > 0) {
                    return 1;
                } else if (myCo.compare(o1.getFirstName(), o2.getFirstName()) < 0) {
                    return -1;
                } else {
                    if (myCo.compare(o1.getLastName(), o2.getLastName()) > 0) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        });
        
        LinkedList<String> studentIdList;
        
        studentIdList = majorList.get(major).getStudentIdList();
        
        Iterator it = studentIdList.iterator();
        
        while (it.hasNext()) {
            Student s = get((String) it.next());
            ts.add(s);
        }
        
        return ts;
    }
}
