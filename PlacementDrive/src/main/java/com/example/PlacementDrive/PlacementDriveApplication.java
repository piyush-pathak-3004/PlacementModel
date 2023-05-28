package com.example.PlacementDrive;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.PlacementDrive.API.PlacementController;
import com.example.PlacementDrive.DB.StudentDBImpl;
import com.example.PlacementDrive.Model.Company;
import com.example.PlacementDrive.Model.Student;
import com.example.PlacementDrive.Service.PlacementDrive;

@SpringBootApplication
public class PlacementDriveApplication {

	public static void main(String[] args) {
		System.out.println("Started...");
		SpringApplication.run(PlacementDriveApplication.class, args);

		StudentDBImpl studentDBImpl = new StudentDBImpl();
		PlacementDrive placementDrive = new PlacementDrive(studentDBImpl);
		final PlacementController placementController = new PlacementController(placementDrive);
		Student student = Student.builder()
							.setRollNo(0)
							.setStudentName("Piyush")
							.build();
		placementController.addStudent(student);
		Student student1 = Student.builder()
							.setRollNo(1)
							.setStudentName("Hemant")
							.build();
		placementController.addStudent(student1);

		System.out.println("Ended...");
		List<Student> ss = placementController.getStudentList();
		
		for( Student s:ss){
			System.out.println(s.getStudentName());
		}

		Company c = Company.builder()
					.setCompanyCtc(1800000)
					.setCompanyName("amazon")
					.build();

		boolean isPiyushEligible = placementController.isEligibleForCompany(student, c);

		System.out.println("isPiyushEligible for Amazon"+isPiyushEligible);
		Student student2 = Student.builder()
							.setRollNo(2)
							.setStudentName("Shivrajan")
							.build();
		Student student3 = Student.builder()
							.setRollNo(3)
							.setStudentName("Shubham")
							.build();
		Student student4 = Student.builder()
							.setRollNo(4)
							.setStudentName("Devansh")
							.build();

		placementController.addStudent(student2);
		placementController.addStudent(student3);
		placementController.addStudent(student4);

		ss = placementController.getStudentList();

		for( Student s:ss){
			System.out.println(s.getStudentName());
		}

		placementController.removeFromPlacementDrive(student4);

		ss = placementController.getStudentList();

		for( Student s:ss){
			System.out.println(s.getStudentName());
		}
		
		Student student5 = Student.builder()
							.setRollNo(1)
							.setStudentName("Hemantii")
							.build();
		

		placementController.updateStudentDetail(student5);

		ss = placementController.getStudentList();

		for( Student s:ss){
			System.out.println(s.getStudentName());
		}
	}

}
