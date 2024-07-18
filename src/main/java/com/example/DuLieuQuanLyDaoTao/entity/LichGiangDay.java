package com.example.DuLieuQuanLyDaoTao.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
@Table(name = "LichGiangDay")
public class LichGiangDay {
    @Id
    @Column(name = "MaLich")
    //@JsonProperty("MaLich")
    private String MaLich;

    @Column(name = "MaGV")
    //@JsonProperty("MaGV")
    private String MaGV;

    @Column(name = "MaKH")
    //@JsonProperty("MaKH")
    private String MaKH;

    @Column(name = "NgayGiangDay")
    //@JsonProperty("NgayGiangDay")
    private String NgayGiangDay;

    @Column(name = "KhungGio")
    //@JsonProperty("KhungGio")
    private String KhungGio;

    // Constructor mặc định
    public LichGiangDay() {}

    // Constructor đầy đủ
    public LichGiangDay(String MaLich, String MaGV, String MaKH, String NgayGiangDay, String KhungGio) {
        this.MaLich = MaLich;
        this.MaGV = MaGV;
        this.MaKH = MaKH;
        this.NgayGiangDay = NgayGiangDay;
        this.KhungGio = KhungGio;
    }

    // Getters
    public String getMaLich() {
        return MaLich;
    }

    public String getMaGV() {
        return MaGV;
    }

    public String getMaKH() {
        return MaKH;
    }

    public String getNgayGiangDay() {
        return NgayGiangDay;
    }

    public String getKhungGio() {
        return KhungGio;
    }

    // Setters
    public void setMaLich(String MaLich) {
        this.MaLich = MaLich;
    }

    public void setMaGV(String MaGV) {
        this.MaGV = MaGV;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public void setNgayGiangDay(String NgayGiangDay) {
        this.NgayGiangDay = NgayGiangDay;
    }

    public void setKhungGio(String KhungGio) {
        this.KhungGio = KhungGio;
    }
}