/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.Worker;
import entity.WorkerHistory;
import java.util.List;

/**
 *
 * @author dell
 */
public class WorkerBO {

    private List<Worker> workerlist;
    private List<WorkerHistory> workerhistorylist;
    
    public void addWorker(Worker worker) {
        workerlist.add(worker);
    }

    public Worker findWorker(int id) {
        for (int i = 0; i < workerlist.size(); i++) {
            if (workerlist.get(i).getId() == id) {
                return workerlist.get(i);
            }
        }
        return null;
    }

    public void updateSalary(Worker worker, String status, int newsalary) {
        worker.setSalary(newsalary);
        WorkerHistory workerhistory = new WorkerHistory(utils.DateUtil.getDate(), 
                status, worker.getId(), worker.getName(), 
                worker.getSalary(), worker.getAge());
        workerhistorylist.add(workerhistory);
    }

    public void displayList() {
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s\n", "Code", "Name", "Age", "Salary", "Status", "Date");
        for (int i = 0; i < workerhistorylist.size(); i++) {
            workerhistorylist.get(i).output();
        }
    }
}
