/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.Candidate;
import entity.Experience;
import entity.Fresher;
import entity.Intern;
import java.util.ArrayList;
import constants.Constants;

/**
 *
 * @author dell
 */
public class CandidateBo {

    public ArrayList<Candidate> candidatelist = new ArrayList<>();
    public ArrayList<Experience> experiencelist = new ArrayList<>();
    public ArrayList<Fresher> fresherlist = new ArrayList<>();
    public ArrayList<Intern> internlist = new ArrayList<>();

    public void addCandidate(int choice) {
        Candidate candidate;
        switch (choice) {
            case 1:
                Experience experience = new Experience();
                experience.input(candidatelist);
                experiencelist.add(experience);
                candidate = new Candidate(
                        experience.getId(),
                        experience.getName(),
                        experience.getLastname(),
                        experience.getBirthdate(),
                        experience.getAddress(),
                        experience.getPhone(),
                        experience.getEmail(),
                        Constants.TYPE_EXP
                );
                candidatelist.add(candidate);
                break;
            case 2:
                Fresher fresher = new Fresher();
                fresher.input(candidatelist);
                fresherlist.add(fresher);
                candidate = new Candidate(
                        fresher.getId(),
                        fresher.getName(),
                        fresher.getLastname(),
                        fresher.getBirthdate(),
                        fresher.getAddress(),
                        fresher.getPhone(),
                        fresher.getEmail(),
                        Constants.TYPE_EXP
                );
                candidatelist.add(candidate);
                break;
            case 3:
                Intern intern = new Intern();
                intern.input(candidatelist);
                internlist.add(intern);
                candidate = new Candidate(
                        intern.getId(),
                        intern.getName(),
                        intern.getLastname(),
                        intern.getBirthdate(),
                        intern.getAddress(),
                        intern.getPhone(),
                        intern.getEmail(),
                        Constants.TYPE_EXP
                );
                candidatelist.add(candidate);
                break;
        }
    }

    public void findCandidate(String name) {
        for (int i = 0; i < candidatelist.size(); i++) {
            String fullname = candidatelist.get(i).getName()
                    + candidatelist.get(i).getLastname();
            if (fullname.toLowerCase().contains(name.toLowerCase())) {
                candidatelist.get(i).output();
            }
        }
    }

    public void display() {
        System.out.println("===========EXPERIENCE CANDIDATE============");
        for (int i = 0; i < experiencelist.size(); i++) {
            System.out.println(experiencelist.get(i).getName());
        }
        System.out.println("===========FRESHER CANDIDATE============");
        for (int i = 0; i < fresherlist.size(); i++) {
            System.out.println(fresherlist.get(i).getName());
        }
        System.out.println("===========INTERN CANDIDATE============");
        for (int i = 0; i < internlist.size(); i++) {
            System.out.println(internlist.get(i).getName());
        }
    }
}
