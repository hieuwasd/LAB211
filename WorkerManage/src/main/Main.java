/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import bo.WorkerBO;
import entity.Worker;
import utils.Validate;

/**
 *
 * @author dell
 */
public class Main {

    public static void main(String[] args) {
        WorkerBO workerbo = new WorkerBO();
        while (true) {
            String menu = ("======== Worker Management ========= \n"
                    + "1. Add Worker \n"
                    + "2. Up salary \n"
                    + "3. Down salary \n"
                    + "4. Display Information salary \n"
                    + "5. Exit \n"
                    + "Enter your choice:");
            int choice = Validate.getInt(menu, 1, 5, "Choice must be from 1-5", "Input invalid");
            switch (choice) {
                case 1:
                    Worker newworker = Worker.input(workerbo);
                    workerbo.addWorker(newworker);
                    break;
                case 2:
                case 3:
                    String status;
                    int findId = Validate.getInt(
                            "Enter id:", 1,
                            Integer.MAX_VALUE,
                            "Id out of range",
                            "Input invalid"
                    );
                    Worker worker = workerbo.findWorker(findId);
                    if (worker != null) {
                        int max, min;
                        if (choice == 2) {
                            min = worker.getSalary() + 1;
                            max = Integer.MAX_VALUE;
                            status = constant.Constants.UP;
                        } else {
                            max = worker.getSalary() - 1;
                            min = 1;
                            status = constant.Constants.DOWN;
                        }
                        int newsalary = Validate.getInt(
                                "Enter new salary", min, max,
                                messages.Messages.OUTOFRANGE,
                                messages.Messages.INVALID
                        );
                        workerbo.updateSalary(worker, status, newsalary);
                    }
                    System.out.println("No worker found");
                    break;
                case 4:
                    workerbo.displayList();
                    break;
                case 5:
                    return;
            }
        }
    }
}
