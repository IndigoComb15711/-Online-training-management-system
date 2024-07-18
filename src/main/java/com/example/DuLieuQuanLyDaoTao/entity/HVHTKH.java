package com.example.DuLieuQuanLyDaoTao.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
@Table(name = "HVHTKH")
public class HVHTKH {
    @Id
    @Column(name = "MaHV")
    //@JsonProperty("MaHV")
    private String MaHV;

    @Column(name = "MaKH")
    //@JsonProperty("MaKH")
    private String MaKH;

    // Constructor mặc định
    public HVHTKH() {}

    // Constructor đầy đủ
    public HVHTKH(String MaHV, String MaKH) {
        this.MaHV = MaHV;
        this.MaKH = MaKH;
    }

    // Getters
    public String getMaHV() {
        return MaHV;
    }

    public String getMaKH() {
        return MaKH;
    }

    // Setters
    public void setMaHV(String MaHV) {
        this.MaHV = MaHV;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    
}