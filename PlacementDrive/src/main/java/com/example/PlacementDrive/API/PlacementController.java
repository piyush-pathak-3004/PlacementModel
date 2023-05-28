package com.example.PlacementDrive.API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PlacementDrive.Model.Company;
import com.example.PlacementDrive.Model.Student;
import com.example.PlacementDrive.Service.PlacementDrive;

@RequestMapping("api/v1/placement")
@RestController
public class PlacementController {

    @Autowired
    private final PlacementDrive placmentDrive;

     
    public PlacementController(PlacementDrive placementDrive) {
        this.placmentDrive = placementDrive; 
    }

    @PostMapping
    public int addStudent(@RequestBody Student student) {
        System.out.println("Inside API of addStudet...");
        return placmentDrive.addStudentService(student);
    }

    @GetMapping
    public List<Student> getStudentList() {
        return placmentDrive.returnStudnetList();
    }

    public boolean isEligibleForCompany(Student student , Company company) {
        System.out.println("inside API of eligible");
        boolean ans = placmentDrive.isEligibleForCompany(company, student);
        return ans;
    }

    public void removeFromPlacementDrive(Student student) {
        System.out.println("inside API of remove");
        placmentDrive.removeFromPlacementDrive(student);
    }

    public void updateStudentDetail(Student student) {
        System.out.println("inside API of update");
        placmentDrive.updateStudentDetail(student);
    }

}
