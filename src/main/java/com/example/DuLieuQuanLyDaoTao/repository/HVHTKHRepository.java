package com.example.DuLieuQuanLyDaoTao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.example.DuLieuQuanLyDaoTao.Projection.HocVienHoanThanhKhoaHocProjection;
import com.example.DuLieuQuanLyDaoTao.entity.HVHTKH;

@Repository
public interface HVHTKHRepository extends JpaRepository<HVHTKH, String> {
    @Modifying
    @Query(value = "SELECT " +
           "hvhtkh.MaHV as maHV, hv.TenHV as tenHV, hvhtkh.MaKH as maKH, kh.TenKH as tenKH " +
           "FROM HVHTKH hvhtkh " +
           "JOIN HocVien hv ON hvhtkh.MaHV = hv.MaHV " +
           "JOIN KhoaHoc kh ON hvhtkh.MaKH = kh.MaKH " +
           "ORDER BY hvhtkh.MaKH, hvhtkh.MaHV", nativeQuery = true)
    List<HocVienHoanThanhKhoaHocProjection> findAllHocVienHoanThanhKhoaHoc();

    @Query(value = "{call sp_TimHocVienHoanThanhKhoaHoc(:MaKhoaHoc)}", nativeQuery = true)
    List<HocVienHoanThanhKhoaHocProjection> timHocVienHoanThanhKhoaHoc(@Param("MaKhoaHoc") String maKhoaHoc);
}
