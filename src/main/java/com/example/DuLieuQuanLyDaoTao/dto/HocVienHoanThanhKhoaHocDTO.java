package com.example.DuLieuQuanLyDaoTao.dto;

public class HocVienHoanThanhKhoaHocDTO {
    private String MaHV;
    private String TenHV;
    private String MaKH;
    private String TenKH;

    // Constructor mặc định
    public HocVienHoanThanhKhoaHocDTO() {}

    // Constructor đầy đủ
    public HocVienHoanThanhKhoaHocDTO(String MaHV, String TenHV, String MaKH, String TenKH) {
        this.MaHV = MaHV;
        this.TenHV = TenHV;
        this.MaKH = MaKH;
        this.TenKH = TenKH;
    }

    // Getters
    public String getMaHV() {
        return MaHV;
    }

    public String getTenHV() {
        return TenHV;
    }

    public String getMaKH() {
        return MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    // Setters
    public void setMaHV(String MaHV) {
        this.MaHV = MaHV;
    }

    public void setTenHV(String TenHV) {
        this.TenHV = TenHV;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

}
