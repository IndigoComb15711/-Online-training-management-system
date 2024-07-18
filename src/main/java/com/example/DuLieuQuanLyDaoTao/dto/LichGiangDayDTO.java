package com.example.DuLieuQuanLyDaoTao.dto;

public class LichGiangDayDTO {
    private String MaLich;
    private String MaGV;
    private String TenGV;
    private String MaKH;
    private String TenKH;
    private String NgayGiangDay;
    private String KhungGio;
    
    // Constructor mặc định
    public LichGiangDayDTO() {}

    // Constructor đầy đủ
    public LichGiangDayDTO(String MaLich, String MaGV, String TenGV, String MaKH, String TenKH, String NgayGiangDay, String KhungGio) {
        this.MaLich = MaLich;
        this.MaGV = MaGV;
        this.TenGV = TenGV;
        this.MaKH = MaKH;
        this.TenKH = TenKH;
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

    public String getTenGV() {
        return TenGV;
    }

    public String getMaKH() {
        return MaKH;
    }

    public String getTenKH() {
        return TenKH;
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

    public void setTenGV(String TenGV) {
        this.TenGV = TenGV;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public void setNgayGiangDay(String NgayGiangDay) {
        this.NgayGiangDay = NgayGiangDay;
    }

    public void setKhungGio(String KhungGio) {
        this.KhungGio = KhungGio;
    }

    

}
