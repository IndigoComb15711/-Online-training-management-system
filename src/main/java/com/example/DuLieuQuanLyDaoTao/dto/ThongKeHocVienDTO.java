package com.example.DuLieuQuanLyDaoTao.dto;

public class ThongKeHocVienDTO {
    private String MaHV;
    private String TenHV;

    // Constructor mặc định
    public ThongKeHocVienDTO() {}

    // Constructor đầy đủ
    public ThongKeHocVienDTO(String MaHV, String TenHV) {
        this.MaHV = MaHV;
        this.TenHV = TenHV;
    }

    // Getters
    public String getMaHV() {
        return MaHV;
    }

    public String getTenHV() {
        return TenHV;
    }

    // Setters
    public void setMaHV(String MaHV) {
        this.MaHV = MaHV;
    }

    public void setTenHV(String TenHV) {
        this.TenHV = TenHV;
    }

}




