package com.example.PlacementDrive.DB;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.PlacementDrive.Model.Student;

@Component
public class StudentDBImpl implements StudentDB {
    private static List<Student> students = new ArrayList<>();

    @Override
    public int addStudentToDB(Student student) {
        System.out.println("Inside DB Layer of addStudet");
        students.add(student);
        return 1;
    }

    @Override
    public void removeFromPlacementDrive(Student student) {
        System.out.println("Inside DB Layer of remove");
        for (Student studentList : students) {
            if( studentList.equals(student)) {
                students.remove(student);
                break;
            }
        }
    }

    @Override
    public void updateStudentDetail(Student student) {
        System.out.println("Inside DB Layer of updte");
        for (Student studentList : students) {
            if( studentList.getRollNo() == student.getRollNo() ) {
                students.remove(studentList);
                students.add(student);
                break;
            }
        }
        
    }

    public List<Student> returnStudnetList() {
        return students;
    }

    
    
}