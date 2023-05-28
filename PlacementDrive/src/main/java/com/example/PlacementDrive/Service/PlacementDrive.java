package com.example.PlacementDrive.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.PlacementDrive.DB.StudentDBImpl;
import com.example.PlacementDrive.Model.Company;
import com.example.PlacementDrive.Model.Student;

@Component
public class PlacementDrive {
    
    @Autowired
    private final StudentDBImpl studentDBImpl;

    
    public PlacementDrive (StudentDBImpl studentDBImpl) {
        this.studentDBImpl = studentDBImpl;
    }


    public int addStudentService(Student student) {
        // call DB layer to add student
        System.out.println("Inside Service Layer of addStudet");
        return studentDBImpl.addStudentToDB(student);
        
    }

    public boolean isEligibleForCompany(Company company , Student student) {
        System.out.println("Inside Service Layer of eligible");
        double companyOffering = company.getCtc();
        double studentBestOfferTillNow = student.getBestOffer();
        
        if(((studentBestOfferTillNow * (2)) <= companyOffering) && student.getCompaniesCracked().size()<=2 ) {
            return true;
        }
        return false;
    }

    public void removeFromPlacementDrive(Student student) {
        System.out.println("Inside Service Layer of remove");
        if(student.getCompaniesCracked().size()>3){
            studentDBImpl.removeFromPlacementDrive(student);
        }
    }

    public void updateStudentDetail(Student student) {
        System.out.println("Inside Service Layer of update");
        // update student details
        studentDBImpl.updateStudentDetail(student);
    }

    public List<Student> returnStudnetList() {
        return studentDBImpl.returnStudnetList();
    }

}
