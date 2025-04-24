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
public class Fresher extends Candidate{
    private String graddate;
    private String rank;
    private String university;
    public Fresher() {
    }

    public Fresher(String graddate, String rank, String university) {
        this.graddate = graddate;
        this.rank = rank;
        this.university = university;
    }

    public Fresher(String graddate, String rank, String university, int id, String name, String lastname, String birthdate, String address, String phone, String email, int type) {
        super(id, name, lastname, birthdate, address, phone, email, type);
        this.graddate = graddate;
        this.rank = rank;
        this.university = university;
    }

    public String getGraddate() {
        return graddate;
    }

    public String getRank() {
        return rank;
    }

    public String getUniversity() {
        return university;
    }

    public void setGraddate(String graddate) {
        this.graddate = graddate;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    @Override
    public void input(List<Candidate> list){
        super.input(list);
        this.graddate = Validation.getString(
                "Enter graduate date:", 
                Constants.REGEX_DATE, 
                Messages.INVALID
        );
        this.rank = Validation.getString(
                "Enter rank:", 
                Constants.REGEX_RANK, 
                Messages.INVALID
        );
        this.university = Validation.getString(
                "Enter graduate date:",
                Constants.REGEX_NAME,
                Messages.INVALID
        );
    }
}
