package com.example.DuLieuQuanLyDaoTao.dto;

import java.sql.Date;

public class DanhSachHocVienDTO {
    private String MaKH;
    private String TenKH;
    private String MaHV;
    private String TenHV;
    private Date NgayDK;
    private String TinhTrangDK;

    // Constructor mặc định
    public DanhSachHocVienDTO() {}

    // Constructor đầy đủ
    public DanhSachHocVienDTO(String MaKH, String TenKH, String MaHV, String TenHV, Date NgayDK, String TinhTrangDK) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.MaHV = MaHV;
        this.TenHV = TenHV;
        this.NgayDK = NgayDK;
        this.TinhTrangDK = TinhTrangDK;
    }

    // Getters
    public String getMaKH() {
        return MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public String getMaHV() {
        return MaHV;
    }

    public String getTenHV() {
        return TenHV;
    }

    public Date getNgayDK() {
        return NgayDK;
    }
    
    public String TinhTrangDK() {
        return TinhTrangDK;
    }

    // Setters
    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public void setMaHV(String MaHV) {
        this.MaHV = MaHV;
    }

    public void setTenHV(String TenHV) {
        this.TenHV = TenHV;
    }

    public void setNgayDK(Date NgayDK) {
        this.NgayDK = NgayDK;
    }

    public void setTinhTrangDK(String TinhTrangDK) {
        this.TinhTrangDK = TinhTrangDK;
    }
}
