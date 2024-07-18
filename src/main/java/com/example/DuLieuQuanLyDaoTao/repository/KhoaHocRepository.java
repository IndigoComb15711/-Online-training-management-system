package com.example.DuLieuQuanLyDaoTao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.example.DuLieuQuanLyDaoTao.Projection.DanhSachHocVienProjection;
import com.example.DuLieuQuanLyDaoTao.Projection.KhoaHocProjection;
import com.example.DuLieuQuanLyDaoTao.dto.DangKyKhoaHocDTO;
import com.example.DuLieuQuanLyDaoTao.entity.KhoaHoc;

@Repository
public interface KhoaHocRepository extends JpaRepository<KhoaHoc, String> {
    @Modifying
    @Query("SELECT new com.example.DuLieuQuanLyDaoTao.dto.DangKyKhoaHocDTO(kh.MaKH, kh.TenKH, hv.MaHV, hv.TenHV, dk.NgayDK, dk.TinhTrangDK) " +
           "FROM KhoaHoc kh " +
           "JOIN DangKy dk ON kh.MaKH = dk.MaKH " +
           "JOIN HocVien hv ON dk.MaHV = hv.MaHV " +
           "ORDER BY kh.MaKH, hv.MaHV")
    List<DangKyKhoaHocDTO> findAllDangKyKhoaHoc();

    @Query(value = "{call sp_DanhSachHocVienTheoKhoaHoc(:MaKH)}", nativeQuery = true)
    List<DanhSachHocVienProjection> getDanhSachHocVienTheoKhoaHoc(@Param("MaKH") String maKH);

    @Query(value = "{call TimKiemKhoaHocTheoMaGV(:MaGV, :HocPhiMin, :HocPhiMax)}", nativeQuery = true)
    List<KhoaHocProjection> timKiemKhoaHocTheoMaGV(
        @Param("MaGV") String maGV,
        @Param("HocPhiMin") String hocPhiMin,
        @Param("HocPhiMax") String hocPhiMax
    );

    @Query(value = "{call TimKiemKhoaHocTheoHocPhi(:MaGV, :HocPhiMin, :HocPhiMax)}", nativeQuery = true)
    List<KhoaHocProjection> timKiemKhoaHocTheoHocPhi(
        @Param("MaGV") String maGV,
        @Param("HocPhiMin") String hocPhiMin,
        @Param("HocPhiMax") String hocPhiMax
    );

    @Query(value = "SELECT TOP 3 " +
           "kh.MaKH as MaKH, " +
           "kh.TenKH as TenKH, " +
           "gv.TenGV as TenGiangVien, " +
           "kh.ThoiLuong as ThoiLuong, " +
           "kh.HocPhi as HocPhi, " +
           "COUNT(dk.MaHV) as SoLuongHocVien " +
           "FROM KhoaHoc kh " +
           "LEFT JOIN DangKy dk ON kh.MaKH = dk.MaKH " +
           "LEFT JOIN GiangVien gv ON kh.MaGV = gv.MaGV " +
           "GROUP BY kh.MaKH, kh.TenKH, gv.TenGV, kh.ThoiLuong, kh.HocPhi " +
           "ORDER BY soLuongHocVien DESC, kh.TenKH", 
           nativeQuery = true)
    List<Object[]> findTopPopularCourses();
}