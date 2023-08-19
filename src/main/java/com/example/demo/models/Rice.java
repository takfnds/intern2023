package com.example.demo.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity

public class Rice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private int Ngay;
    private int Sotien;

    public Rice() {
    }

    public Rice(int ID, int ngay, int sotien) {
        this.ID = ID;
        this.Ngay = ngay;
        this.Sotien = sotien;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getNgay() {
        return Ngay;
    }

    public void setNgay(int ngay) {
        Ngay = ngay;
    }

    public int getSotien() {
        return Sotien;
    }

    public void setSotien(int sotien) {
        Sotien = sotien;
    }


}