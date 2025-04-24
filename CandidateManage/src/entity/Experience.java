/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.List;
import utils.Validation;
import messages.Messages;
import constants.Constants;

/**
 *
 * @author dell
 */
public class Experience extends Candidate {

    private int exp;
    private String skill;

    public Experience() {
    }

    public Experience(int exp, String skill) {
        this.exp = exp;
        this.skill = skill;
    }

    public Experience(int exp, String skill, int id, String name, String lastname, String birthdate, String address, String phone, String email, int type) {
        super(id, name, lastname, birthdate, address, phone, email, type);
        this.exp = exp;
        this.skill = skill;
    }

    public int getExp() {
        return exp;
    }

    public String getSkill() {
        return skill;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public void input(List<Candidate> list) {
        super.input(list);
        this.exp = Validation.getInt(
                "Enter experience year:", 0, 100,
                Messages.OUT_OF_RANGE,
                Messages.INVALID
        );
        this.skill = Validation.getString(
                "Enter skill:",
                Constants.REGEX_NAME,
                Messages.INVALID
        );
    }
}
