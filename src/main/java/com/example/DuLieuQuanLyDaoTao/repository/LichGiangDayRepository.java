package com.example.DuLieuQuanLyDaoTao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.example.DuLieuQuanLyDaoTao.dto.LichGiangDayDTO;
import com.example.DuLieuQuanLyDaoTao.entity.LichGiangDay;

@Repository
public interface LichGiangDayRepository extends JpaRepository<LichGiangDay, String> {
    @Query("SELECT new com.example.DuLieuQuanLyDaoTao.dto.LichGiangDayDTO(l.MaLich, g.MaGV, g.TenGV, k.MaKH, k.TenKH, l.NgayGiangDay, l.KhungGio) " +
           "FROM LichGiangDay l " +
           "JOIN GiangVien g ON l.MaGV = g.MaGV " +
           "JOIN KhoaHoc k ON l.MaKH = k.MaKH " +
           "ORDER BY l.NgayGiangDay, l.KhungGio")
    List<LichGiangDayDTO> findAllLichGiangDay();

    @Query(value = "EXEC SP_XemLichGiangDayTheoMaGV :maGV", nativeQuery = true)
    List<Object[]> findLichGiangDayByMaGV(@Param("maGV") String maGV);

    @Query(value = "EXEC SP_XemLichGiangDayTheoNgay :ngayGiangDay", nativeQuery = true)
    List<Object[]> findLichGiangDayByNgay(@Param("ngayGiangDay") String ngayGiangDay);
}
