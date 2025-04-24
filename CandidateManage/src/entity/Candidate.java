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
public class Candidate {

    private int id;
    private String name;
    private String lastname;
    private String birthdate;
    private String address;
    private String phone;
    private String email;
    private int type;

    public Candidate() {
    }

    public Candidate(int id, String name, String lastname, String birthdate, String address, String phone, String email, int type) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public int getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void input(List<Candidate> list) {
        while (true) {
            this.id = Validation.getInt(
                    "Enter id:", 1, Integer.MAX_VALUE,
                    Messages.OUT_OF_RANGE,
                    Messages.INVALID
            );
            if (findCandidate(list, id) == null) {
                break;
            }
        }
        this.name = Validation.getString(
                "Enter name:",
                Constants.REGEX_NAME,
                Messages.INVALID
        );
        this.lastname = Validation.getString(
                "Enter last name:",
                Constants.REGEX_NAME,
                Messages.INVALID
        );
        this.birthdate = Validation.getString(
                "Enter birthdate:",
                Constants.REGEX_DATE,
                Messages.INVALID
        );
        this.birthdate = Validation.getString(
                "Enter address:",
                Constants.REGEX_NAME,
                Messages.INVALID
        );
        this.phone = Validation.getString(
                "Enter phone:",
                Constants.REGEX_PHONE,
                Messages.INVALID
        );
        this.email = Validation.getString(
                "Enter email:",
                Constants.REGEX_EMAIL,
                Messages.INVALID
        );
    }

    public Candidate findCandidate(List<Candidate> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (id == list.get(i).getId()) {
                return list.get(i);
            }
        }
        return null;
    }

    public void output() {
        System.out.print(this.lastname
                + "|" + this.name
                + "|" + this.address
                + "|" + this.phone
                + "|" + this.email
                + "|" + this.type
        );
    }
}
