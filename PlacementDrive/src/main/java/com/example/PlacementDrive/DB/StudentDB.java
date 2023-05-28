package com.example.PlacementDrive.DB;

import com.example.PlacementDrive.Model.Student;

public interface StudentDB {
    int addStudentToDB(Student student);
    public void removeFromPlacementDrive(Student student);
    public void updateStudentDetail(Student student);
}
