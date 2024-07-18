package com.example.DuLieuQuanLyDaoTao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.example.DuLieuQuanLyDaoTao.Projection.GiangVienHocVienNhieuNhatProjection;
import com.example.DuLieuQuanLyDaoTao.Projection.ThongKeHocVienProjection;
import com.example.DuLieuQuanLyDaoTao.entity.GiangVien;

@Repository
public interface GiangVienRepository extends JpaRepository<GiangVien, String> {
    @Query(value = "{call sp_ThongKeHocVienTheoGiangVien(:MaGV)}", nativeQuery = true)
    List<ThongKeHocVienProjection> thongKeHocVienTheoGiangVien(@Param("MaGV") String maGV);

    @Query(value = "WITH GiangVienHocVien AS (" +
                   "    SELECT " +
                   "        gv.MaGV, " +
                   "        gv.TenGV, " +
                   "        COUNT(DISTINCT dk.MaHV) AS SoLuongHocVien " +
                   "    FROM " +
                   "        GiangVien gv " +
                   "    LEFT JOIN " +
                   "        KhoaHoc kh ON gv.MaGV = kh.MaGV " +
                   "    LEFT JOIN " +
                   "        DangKy dk ON kh.MaKH = dk.MaKH " +
                   "    GROUP BY " +
                   "        gv.MaGV, gv.TenGV " +
                   ") " +
                   "SELECT TOP 3 " +
                   "    MaGV, " +
                   "    TenGV, " +
                   "    SoLuongHocVien " +
                   "FROM " +
                   "    GiangVienHocVien " +
                   "ORDER BY " +
                   "    SoLuongHocVien DESC, TenGV",
            nativeQuery = true)
    List<GiangVienHocVienNhieuNhatProjection> findTop3GiangVienNhieuHocVienNhat();
}
