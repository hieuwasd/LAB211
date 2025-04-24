/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import constants.Constants;
import java.util.List;
import messages.Messages;
import utils.Validation;

/**
 *
 * @author dell
 */
public class Intern extends Candidate {

    private String major;
    private int semester;
    private String university;

    public Intern() {
    }

    public Intern(String major, int semester, String university) {
        this.major = major;
        this.semester = semester;
        this.university = university;
    }

    public Intern(String major, int semester, String university, int id, String name, String lastname, String birthdate, String address, String phone, String email, int type) {
        super(id, name, lastname, birthdate, address, phone, email, type);
        this.major = major;
        this.semester = semester;
        this.university = university;
    }

    public String getMajor() {
        return major;
    }

    public int getSemester() {
        return semester;
    }

    public String getUniversity() {
        return university;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    @Override
    public void input(List<Candidate> list) {
        super.input(list);
        this.major = Validation.getString(
                "Enter major:",
                Constants.REGEX_NAME,
                Messages.INVALID
        );
        this.semester = Validation.getInt(
                "Enter experience year:", 1, 9,
                Messages.OUT_OF_RANGE,
                Messages.INVALID
        );
        this.university = Validation.getString(
                "Enter graduate date:",
                Constants.REGEX_NAME,
                Messages.INVALID
        );
    }
}
