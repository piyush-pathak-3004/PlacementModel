package com.example.PlacementDrive.Model;

public class Company {
    double ctc;
    String companyName;


    private Company(CompanyBuilder builder) {
        this.companyName = builder.name;
        this.ctc = builder.ctc;
    }
    public String getName() {
        return companyName;
    }

    public double getCtc() {
        return ctc;
    }

    public static CompanyBuilder builder() {
        return new CompanyBuilder();
    }

    public static class CompanyBuilder {
        private String name;
        private double ctc;

        private CompanyBuilder() {
        }

        public CompanyBuilder setCompanyName(String name) {
            this.name = name;
            return this;
        }

        public CompanyBuilder setCompanyCtc(double ctc) {
            this.ctc = ctc;
            return this;
        }

        public Company build() {
            return new Company(this);
        }
    }

}
