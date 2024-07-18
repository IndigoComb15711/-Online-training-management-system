package com.example.DuLieuQuanLyDaoTao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.example.DuLieuQuanLyDaoTao.Projection.TongSoHocVienDangKyProjection;
import com.example.DuLieuQuanLyDaoTao.entity.DangKy;

@Repository
public interface DangKyRepository extends JpaRepository<DangKy, String> {
    @Query(value = "{call TongSoHocVienDangKyTheoThang_TichLuy}", nativeQuery = true)
    List<TongSoHocVienDangKyProjection> getTongSoHocVienDangKyTheoThang();
}
