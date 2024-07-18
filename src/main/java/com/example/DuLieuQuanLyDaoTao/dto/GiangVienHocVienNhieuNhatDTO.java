package com.example.DuLieuQuanLyDaoTao.dto;

public class GiangVienHocVienNhieuNhatDTO {
    private String MaGV;
    private String TenGV;
    private String SoLuongHocVien;

    // Constructor mặc định
    public GiangVienHocVienNhieuNhatDTO() {}

    // Constructor đầy đủ
    public GiangVienHocVienNhieuNhatDTO(String MaGV, String TenGV, String SoLuongHocVien) {
        this.MaGV = MaGV;
        this.TenGV = TenGV;
        this.SoLuongHocVien = SoLuongHocVien;
    }

    // Getters
    public String getMaGV() {
        return MaGV;
    }

    public String getTenGV() {
        return TenGV;
    }

    public String getSoLuongHocVien() {
        return SoLuongHocVien;
    }

    // Setters
    public void setMaGV(String MaGV) {
        this.MaGV = MaGV;
    }

    public void setTenGV(String TenGV) {
        this.TenGV = TenGV;
    }

    public void setSoLuongHocVien(String SoLuongHocVien) {
        this.SoLuongHocVien = SoLuongHocVien;
    }

}
