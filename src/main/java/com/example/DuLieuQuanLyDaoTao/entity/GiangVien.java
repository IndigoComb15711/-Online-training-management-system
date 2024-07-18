package com.example.DuLieuQuanLyDaoTao.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
@Table(name = "GiangVien")
public class GiangVien {
    @Id
    @Column(name = "MaGV")
    //@JsonProperty("MaGV")
    private String MaGV;

    @Column(name = "TenGV", nullable = false)
    //@JsonProperty("TenGV")
    private String TenGV;

    @Column(name = "ChuyenMon")
    //@JsonProperty("ChuyenMon")
    private String ChuyenMon;

    @Column(name = "KinhNghiem")
    //@JsonProperty("KinhNghiem")
    private String KinhNghiem;

    // Constructor mặc định
    public GiangVien() {}

    // Constructor đầy đủ
    public GiangVien(String MaGV, String TenGV, String ChuyenMon, String KinhNghiem, String hocPhi) {
        this.MaGV = MaGV;
        this.TenGV = TenGV;
        this.ChuyenMon = ChuyenMon;
        this.KinhNghiem = KinhNghiem;
    }

    // Getters
    public String getMaGV() {
        return MaGV;
    }

    public String getTenGV() {
        return TenGV;
    }

    public String getChuyenMon() {
        return ChuyenMon;
    }

    public String getKinhNghiem() {
        return KinhNghiem;
    }

    

    // Setters
    public void setMaGV(String MaGV) {
        this.MaGV = MaGV;
    }

    public void setTenGV(String TenGV) {
        this.TenGV = TenGV;
    }

    public void setChuyenMon(String ChuyenMon) {
        this.ChuyenMon = ChuyenMon;
    }

    public void setKinhNghiem(String KinhNghiem) {
        this.KinhNghiem = KinhNghiem;
    }

    
}