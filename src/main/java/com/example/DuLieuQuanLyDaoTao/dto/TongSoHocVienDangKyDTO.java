package com.example.DuLieuQuanLyDaoTao.dto;

public class TongSoHocVienDangKyDTO {
    private String Thang;
    private String SoHocVienDangKyThang;
    private String TongSoHocVienDangKy_TichLuy;

    // Constructor mặc định
    public TongSoHocVienDangKyDTO() {}

    // Constructor đầy đủ
    public TongSoHocVienDangKyDTO(String Thang, String SoHocVienDangKyThang, String TongSoHocVienDangKy_TichLuy) {
        this.Thang = Thang;
        this.SoHocVienDangKyThang = SoHocVienDangKyThang;
        this.TongSoHocVienDangKy_TichLuy = TongSoHocVienDangKy_TichLuy;
    }

    // Getters
    public String getThang() {
        return Thang;
    }

    public String getSoHocVienDangKyThang() {
        return SoHocVienDangKyThang;
    }

    public String getTongSoHocVienDangKy_TichLuy() {
        return TongSoHocVienDangKy_TichLuy;
    }

    // Setters
    public void setThang(String Thang) {
        this.Thang = Thang;
    }

    public void setSoHocVienDangKyThang(String SoHocVienDangKyThang) {
        this.SoHocVienDangKyThang = SoHocVienDangKyThang;
    }

    public void setTongSoHocVienDangKy_TichLuy(String TongSoHocVienDangKy_TichLuy) {
        this.TongSoHocVienDangKy_TichLuy = TongSoHocVienDangKy_TichLuy;
    }
}