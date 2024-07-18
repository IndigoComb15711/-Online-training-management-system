package com.example.DuLieuQuanLyDaoTao.dto;


public class KhoaHocPhoBienDTO {
    private String MaKH;
    private String TenKH;
    private String TenGiangVien;
    private String ThoiLuong;
    private String HocPhi;
    private Integer SoLuongHocVien;

    // Constructor mặc định
    public KhoaHocPhoBienDTO() {}

    // Constructor đầy đủ
    public KhoaHocPhoBienDTO(String MaKH, String TenKH, String TenGiangVien, String ThoiLuong, String HocPhi, Integer SoLuongHocVien) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.TenGiangVien = TenGiangVien;
        this.ThoiLuong = ThoiLuong;
        this.HocPhi = HocPhi;
        this.SoLuongHocVien = SoLuongHocVien;
    }

    // Getters
    public String getMaKH() {
        return MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public String getTenGiangVien() {
        return TenGiangVien;
    }

    public String getThoiLuong() {
        return ThoiLuong;
    }

    public String getHocPhi() {
        return HocPhi;
    }
    
    public Integer SoLuongHocVien() {
        return SoLuongHocVien;
    }

    // Setters
    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public void setTenGiangVien(String TenGiangVien) {
        this.TenGiangVien = TenGiangVien;
    }

    public void setThoiLuong(String ThoiLuong) {
        this.ThoiLuong = ThoiLuong;
    }

    public void setHocPhi(String HocPhi) {
        this.HocPhi = HocPhi;
    }

    public void setSoLuongHocVien(Integer SoLuongHocVien) {
        this.SoLuongHocVien = SoLuongHocVien;
    }
}
