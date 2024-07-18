package com.example.DuLieuQuanLyDaoTao.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
@Table(name = "KhoaHoc")
public class KhoaHoc {
    @Id
    @Column(name = "MaKH")
    //@JsonProperty("MaKH")
    private String MaKH;

    @Column(name = "TenKH", nullable = false)
    //@JsonProperty("TenKH")
    private String TenKH;

    @Column(name = "MaGV")
    //@JsonProperty("MaGV")
    private String MaGV;

    @Column(name = "ThoiLuong")
    //@JsonProperty("ThoiLuong")
    private String ThoiLuong;

    @Column(name = "HocPhi")
    //@JsonProperty("HocPhi")
    private String HocPhi;

    // Constructor mặc định
    public KhoaHoc() {}

    // Constructor đầy đủ
    public KhoaHoc(String MaKH, String TenKH, String MaGV, String ThoiLuong, String HocPhi) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.MaGV = MaGV;
        this.ThoiLuong = ThoiLuong;
        this.HocPhi = HocPhi;
    }

    // Getters
    public String getMaKH() {
        return MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public String getMaGV() {
        return MaGV;
    }

    public String getThoiLuong() {
        return ThoiLuong;
    }

    public String getHocPhi() {
        return HocPhi;
    }

    // Setters
    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public void setMaGV(String MaGV) {
        this.MaGV = MaGV;
    }

    public void setThoiLuong(String ThoiLuong) {
        this.ThoiLuong = ThoiLuong;
    }

    public void setHocPhi(String HocPhi) {
        this.HocPhi = HocPhi;
    }
}