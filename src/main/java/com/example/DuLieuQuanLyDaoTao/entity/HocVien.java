package com.example.DuLieuQuanLyDaoTao.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
@Table(name = "HocVien")
public class HocVien {
    @Id
    @Column(name = "MaHV")
    //@JsonProperty("MaHV")
    private String MaHV;

    @Column(name = "TenHV", nullable = false)
    //@JsonProperty("TenHV")
    private String TenHV;

    @Column(name = "DiaChi")
    //@JsonProperty("DiaChi")
    private String DiaChi;

    @Column(name = "SDT")
    //@JsonProperty("SDT")
    private String SDT;

    @Column(name = "Email")
    //@JsonProperty("Email")
    private String Email;

    // Constructor mặc định
    public HocVien() {}

    // Constructor đầy đủ
    public HocVien(String MaHV, String TenHV, String DiaChi, String SDT, String Email) {
        this.MaHV = MaHV;
        this.TenHV = TenHV;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.Email = Email;
    }

    // Getters
    public String getMaHV() {
        return MaHV;
    }

    public String getTenHV() {
        return TenHV;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public String getEmail() {
        return Email;
    }

    // Setters
    public void setMaHV(String MaHV) {
        this.MaHV = MaHV;
    }

    public void setTenHV(String TenHV) {
        this.TenHV = TenHV;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
}