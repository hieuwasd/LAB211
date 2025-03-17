/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.Student;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dell
 */
public class StudentBO {

    private ArrayList<Student> studentlist = new ArrayList<>();

    public void addStudent() {
        Student student = new Student();
        student.input(studentlist, constants.Constants.STATUS_CREATE);
        studentlist.add(student);
    }

    public Student findStudent(int id) {
        for (int i = 0; i < studentlist.size(); i++) {
            if (studentlist.get(i).getId() == id) {
                return studentlist.get(i);
            }
        }
        return null;
    }

    public ArrayList<Student> findStudent(String name) {
        ArrayList<Student> studentfoundlist = new ArrayList<>();
        for (int i = 0; i < studentlist.size(); i++) {
            if (studentlist.get(i).getName().toLowerCase()
                    .contains(name.toLowerCase())) {
                studentfoundlist.add(studentlist.get(i));
            }
        }
        sortList(studentfoundlist);
        return studentfoundlist;
    }

    public void sortList(List<Student> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (list.get(i).getName().compareTo(list.get(j).getName()) > 0) {
                    Student temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
    }

    public void modifyStudent(Student student, String choice) {
        if (choice.equalsIgnoreCase(constants.Constants.STATUS_DELETE)) {
            studentlist.remove(student);
        } else {
            student.input(studentlist, constants.Constants.STATUS_UPDATE);
        }
    }

    public Map<String, Integer> report() {
        Map<String, Integer> retakeCount = new HashMap<>();
        for (int i = 0; i < studentlist.size(); i++) {
            String key = studentlist.get(i).getId()
                    + "|" + studentlist.get(i).getName()
                    + "|" + studentlist.get(i).getCoursename();
            retakeCount.put(key, retakeCount.getOrDefault(key, 0) + 1);
        }
        return retakeCount;
    }

    public void displaylist(List<Student> list) {
        System.out.printf("%-10s %-10s %-10s %-10s\n", 
                "ID", "Name", "Course name", "Semester");
        for (int i = 0; i < list.size(); i++) {
            list.get(i).output();
        }
    }
}
