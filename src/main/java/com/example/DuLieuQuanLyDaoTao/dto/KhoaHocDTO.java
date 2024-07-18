package com.example.DuLieuQuanLyDaoTao.dto;

public class KhoaHocDTO {
    private String MaKH;
    private String TenKH;
    private String ThoiLuong;
    private String HocPhi;

    // Constructor mặc định
    public KhoaHocDTO() {}

    // Constructor đầy đủ
    public KhoaHocDTO(String MaKH, String TenKH, String ThoiLuong, String HocPhi) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
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

    public void setThoiLuong(String ThoiLuong) {
        this.ThoiLuong = ThoiLuong;
    }

    public void setHocPhi(String HocPhi) {
        this.HocPhi = HocPhi;
    }

}
