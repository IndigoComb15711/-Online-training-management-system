package com.example.DuLieuQuanLyDaoTao.Projection;

import java.sql.Date;

public interface DanhSachHocVienProjection {
    String getMaKH();
    String getTenKH();
    String getMaHV();
    String getTenHV();
    Date getNgayDK();
    String getTinhTrangDK();
}