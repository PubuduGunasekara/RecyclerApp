package com.example.recyclerapp;

public class VaccineModel {

    private int vaccineImage;
    private String vaccineName;

    public VaccineModel(int vaccineImage, String vaccineName) {
        this.vaccineImage = vaccineImage;
        this.vaccineName = vaccineName;
    }

    public int getVaccineImage() {
        return vaccineImage;
    }

    public void setVaccineImage(int vaccineImage) {
        this.vaccineImage = vaccineImage;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }
}
