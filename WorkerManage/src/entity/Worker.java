/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import bo.WorkerBO;
import static constant.Constants.NAMEREGEX;
import utils.Validate;

/**
 *
 * @author dell
 */
public class Worker {

    protected int id;
    private String name;
    private int salary;
    private int age;

    public Worker() {
    }

    public Worker(int id, String name, int salary, int age) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static Worker input(WorkerBO workerbo) {
        int id;
        while (true) {
            id = Validate.getInt(
                    "Enter id:", 1, 
                    Integer.MAX_VALUE, 
                    messages.Messages.OUTOFRANGE, 
                    messages.Messages.INVALID
            );
            if (workerbo.findWorker(id) != null) {
                break;
            } else {
                System.out.println("Id existed");
            }
        }

        String name = Validate.getString(
                "Enter name:", 
                NAMEREGEX, 
                messages.Messages.INVALID);
        int age = Validate.getInt(
                "Enter age:", 18, 50, 
                messages.Messages.OUTOFRANGE, 
                messages.Messages.INVALID
        );
        int salary = Validate.getInt(
                "Enter salary:", 1, 
                Integer.MAX_VALUE, 
                "Salary must be more than 1", 
                messages.Messages.INVALID
        );

        Worker worker = new Worker(id, name, salary, age);
        return worker;
    }

    public void output() {
        System.out.printf("%-10d %-10s %-10d %-10d", this.id, this.name, this.age, this.salary);
    }
}
