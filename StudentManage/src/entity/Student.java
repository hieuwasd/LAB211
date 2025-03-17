/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import bo.StudentBO;
import java.util.ArrayList;
import utils.Validation;

/**
 *
 * @author dell
 */
public class Student {

    private int id;
    private String name;
    private int semester;
    private String coursename;

    public Student() {

    }

    public Student(int id, String name, int semester, String coursename) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.coursename = coursename;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSemester() {
        return semester;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public void input(ArrayList<Student> list, String status) {
        Student findstudent = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                findstudent = list.get(i);
            }
        }
        while (true) {
            id = Validation.getInt(
                    "Enter id:", 1,
                    Integer.MAX_VALUE,
                    messages.Messages.OUT_OF_RANGE,
                    messages.Messages.INVALID
            );
            if (findstudent != null) {
                this.id = findstudent.getId();
                break;
            } else {
                break;
            }
        }
        this.name = Validation.getString(
                "Enter name:",
                constants.Constants.REGEX_NAME,
                messages.Messages.INVALID
        );

        this.coursename = Validation.getString(
                "Enter course name:",
                constants.Constants.REGEX_COURSE,
                messages.Messages.INVALID
        );
        while (true) {
            this.semester = Validation.getInt(
                    "Enter semester:", 1, 9,
                    messages.Messages.OUT_OF_RANGE,
                    messages.Messages.INVALID
            );
            if (findstudent != null) {
                if (this.id == findstudent.getId()
                        && this.name.equalsIgnoreCase(findstudent.getName())
                        && this.coursename.equalsIgnoreCase(findstudent.getCoursename())
                        && this.semester == findstudent.semester) {
                    System.out.println("Record existed");
                } else {
                    break;
                }
            }
        }
    }

    public void output() {
        System.out.printf("%-10d %-10s %-10s %-10d\n",
                this.id, this.name, this.getCoursename(), this.semester);
    }
}
