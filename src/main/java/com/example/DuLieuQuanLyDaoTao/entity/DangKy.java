package com.example.DuLieuQuanLyDaoTao.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
@Table(name = "DangKy")
public class DangKy {
    @Id
    @Column(name = "MaDK")
    //@JsonProperty("MaDK")
    private String MaDK;

    @Column(name = "MaHV")
    //@JsonProperty("MaHV")
    private String MaHV;

    @Column(name = "MaKH")
    //@JsonProperty("MaKH")
    private String MaKH;

    @Column(name = "TinhTrangDK")
    //@JsonProperty("TinhTrangDK")
    private String TinhTrangDK;

    @Column(name = "NgayDK")
    //@JsonProperty("NgayDK")
    private Date NgayDK;

    // Constructor mặc định
    public DangKy() {}

    // Constructor đầy đủ
    public DangKy(String MaDK, String MaHV, String MaKH, String TinhTrangDK, Date NgayDK) {
        this.MaDK = MaDK;
        this.MaHV = MaHV;
        this.MaKH = MaKH;
        this.TinhTrangDK = TinhTrangDK;
        this.NgayDK = NgayDK;
    }

    // Getters
    public String getMaDK() {
        return MaDK;
    }

    public String getMaHV() {
        return MaHV;
    }

    public String getMaKH() {
        return MaKH;
    }

    public String getTinhTrangDK() {
        return TinhTrangDK;
    }

    public Date getNgayDK() {
        return NgayDK;
    }

    // Setters
    public void setMaDK(String MaDK) {
        this.MaDK = MaDK;
    }

    public void setMaHV(String MaHV) {
        this.MaHV = MaHV;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public void setTinhTrangDK(String TinhTrangDK) {
        this.TinhTrangDK = TinhTrangDK;
    }

    public void setNgayDK(Date NgayDK) {
        this.NgayDK = NgayDK;
    }
}