package com.example.PlacementDrive.Model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

public class Student {
    @JsonProperty("rollNo")
    private final int rollNo;
    @JsonProperty("studentName")
    private final String studentName;
    // @JsonProperty("gender")
    private final Gender gender;
    @JsonProperty("email")
    private final String email;
    // @JsonProperty("companyCracked")
    private final List<Company> companiesCracked;
    @JsonProperty("bestOffer")
    private final double bestOffer;

    private Student(StudentBuilder builder) {
        this.rollNo = builder.rollNo;
        this.studentName = builder.studentName;
        this.gender = builder.gender;
        this.email = builder.email;
        this.companiesCracked = (builder.companiesCracked == null?(new ArrayList<>()):builder.companiesCracked);
        this.bestOffer = builder.bestOffer;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public Gender getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public List<Company> getCompaniesCracked() {
        return companiesCracked;
    }

    public double getBestOffer() {
        return bestOffer;
    }

    public static StudentBuilder builder() {
        return new StudentBuilder();
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static class StudentBuilder {
        @JsonProperty("rollNo")
        private int rollNo;
        @JsonProperty("studentName")
        private String studentName;
        private Gender gender;
        @JsonProperty("email")
        private String email;
        private List<Company> companiesCracked;
        @JsonProperty("bestOffer")
        private double bestOffer;

        public StudentBuilder setRollNo(int rollNo) {
            this.rollNo = rollNo;
            return this;
        }

        public StudentBuilder setStudentName(String studentName) {
            this.studentName = studentName;
            return this;
        }

        public StudentBuilder setGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public StudentBuilder setEmail(String email) {
            this.email = email;
            return this;
        }
        
        public StudentBuilder setCompaniesCracked(List<Company>companies) {
            this.companiesCracked = companies;
            this.bestOffer = calculateBestOffer(this.companiesCracked);
            return this;
        }

        public Student build() {
            return new Student(this);
        }

        double calculateBestOffer(List<Company> companiesCracked) {
            double bestOffer = 0;
            for( Company company : companiesCracked) {
                bestOffer = Math.max(bestOffer, company.ctc);
            }
            return bestOffer;
        }
    }
}
