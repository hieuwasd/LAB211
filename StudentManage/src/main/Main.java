/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import bo.StudentBO;
import entity.Student;
import java.util.Map;
import utils.Validation;

/**
 *
 * @author dell
 */
public class Main {

    public static void main(String[] args) {
        StudentBO studentbo = new StudentBO();
        while (true) {
            String menu = ("======== Worker Management ========= \n"
                    + "1. Create \n"
                    + "2. Find and sort \n"
                    + "3. Update/Delete \n"
                    + "4. Report \n"
                    + "5. Exit \n"
                    + "Enter your choice:");
            int choice = Validation.getInt(
                    menu, 1, 5,
                    messages.Messages.OUT_OF_RANGE,
                    messages.Messages.INVALID
            );
            switch (choice) {
                case 1:
                    studentbo.addStudent();
                    break;
                case 2:
                    String name = Validation.getString(
                            "Enter name:",
                            constants.Constants.REGEX_NAME,
                            messages.Messages.INVALID
                    );
                    studentbo.displaylist(studentbo.findStudent(name));
                    break;
                case 3:
                    int findid = Validation.getInt(
                            "Enter id", 1,
                            Integer.MAX_VALUE,
                            messages.Messages.OUT_OF_RANGE,
                            messages.Messages.INVALID
                    );
                    Student student = studentbo.findStudent(findid);
                    if (student == null) {
                        System.out.println("No student found.");
                    } else {
                        System.out.println("Student found:" + student);
                        String udchoice = Validation.getString(
                                "Do you want to update (U) or delete (D) student:",
                                constants.Constants.REGEX_UD, messages.Messages.INVALID
                        );
                        studentbo.modifyStudent(student, udchoice);
                    }
                    break;
                case 4:
                    Map<String, Integer> report = studentbo.report();
                    for (Map.Entry<String, Integer> entry : result.entrySet()) {
                        System.out.println(entry.getKey() + "|" + (entry.getValue() - 1));
                    }
                    break;
                case 5:
                    return;
            }
        }
    }
}
