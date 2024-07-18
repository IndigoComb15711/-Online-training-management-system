package com.example.DuLieuQuanLyDaoTao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DuLieuQuanLyDaoTao.Projection.DanhSachHocVienProjection;
import com.example.DuLieuQuanLyDaoTao.Projection.KhoaHocProjection;
import com.example.DuLieuQuanLyDaoTao.dto.DangKyKhoaHocDTO;
import com.example.DuLieuQuanLyDaoTao.dto.DanhSachHocVienDTO;
import com.example.DuLieuQuanLyDaoTao.dto.KhoaHocDTO;
import com.example.DuLieuQuanLyDaoTao.dto.KhoaHocPhoBienDTO;
import com.example.DuLieuQuanLyDaoTao.entity.KhoaHoc;
import com.example.DuLieuQuanLyDaoTao.repository.KhoaHocRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class KhoaHocService {
    @Autowired
    private KhoaHocRepository KhoaHocRepository;

    public List<DangKyKhoaHocDTO> getAllDangKyKhoaHoc() {
        return KhoaHocRepository.findAllDangKyKhoaHoc();
    }

    public List<DanhSachHocVienDTO> getDanhSachHocVienTheoKhoaHoc(String maKH) {
        List<DanhSachHocVienProjection> projections = KhoaHocRepository.getDanhSachHocVienTheoKhoaHoc(maKH);
        return projections.stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }

    public List<KhoaHocDTO> timKiemKhoaHocTheoMaGV(String maGV, String hocPhiMin, String hocPhiMax) {
        List<KhoaHocProjection> projections = KhoaHocRepository.timKiemKhoaHocTheoMaGV(maGV, hocPhiMin, hocPhiMax);
        return projections.stream()
            .map(p -> new KhoaHocDTO(p.getMaKH(), p.getTenKH(), p.getThoiLuong(), p.getHocPhi()))
            .collect(Collectors.toList());
    }

    public List<KhoaHocDTO> timKiemKhoaHocTheoHocPhi(String maGV, String hocPhiMin, String hocPhiMax) {
        List<KhoaHocProjection> projections = KhoaHocRepository.timKiemKhoaHocTheoHocPhi(maGV, hocPhiMin, hocPhiMax);
        return projections.stream()
            .map(p -> new KhoaHocDTO(p.getMaKH(), p.getTenKH(), p.getThoiLuong(), p.getHocPhi()))
            .collect(Collectors.toList());
    }

    private DanhSachHocVienDTO convertToDTO(DanhSachHocVienProjection projection) {
        return new DanhSachHocVienDTO(
            projection.getMaKH(),
            projection.getTenKH(),
            projection.getMaHV(),
            projection.getTenHV(),
            projection.getNgayDK(),
            projection.getTinhTrangDK()
        );
    }

    public List<KhoaHocPhoBienDTO> getTopPopularCourses() {
        List<Object[]> results = KhoaHocRepository.findTopPopularCourses();
        return results.stream().map(this::mapToKhoaHocPhoBienDTO).collect(Collectors.toList());
    }
    
    private KhoaHocPhoBienDTO mapToKhoaHocPhoBienDTO(Object[] row) {
        return new KhoaHocPhoBienDTO(
            (String) row[0],                  // MaKH
            (String) row[1],                  // TenKH
            (String) row[2],                  // TenGiangVien
            (String) row[3],                  // ThoiLuong
            (String) row[4],                  // HocPhi
            (Integer) row[5]                   // SoLuongHocVien
        );
    }

    public List<KhoaHoc> getAllKhoaHoc() {
        return KhoaHocRepository.findAll();
    }

    public KhoaHoc getKhoaHocById(String id) {
        return KhoaHocRepository.findById(id).orElse(null);
    }

    public KhoaHoc createKhoaHoc(KhoaHoc KhoaHoc) {
        if (KhoaHoc.getMaKH() == null || KhoaHoc.getMaKH().trim().isEmpty()) {
            throw new IllegalArgumentException("MaKH không được để trống");
        }
        if (KhoaHocRepository.existsById(KhoaHoc.getMaKH())) {
            throw new RuntimeException("MaKH đã tồn tại");
        }
        return KhoaHocRepository.save(KhoaHoc);
    }

    public KhoaHoc updateKhoaHoc(String id, KhoaHoc KhoaHocDetails) {
        KhoaHoc KhoaHoc = KhoaHocRepository.findById(id).orElse(null);
        if (KhoaHoc != null) {
            KhoaHoc.setTenKH(KhoaHocDetails.getTenKH());
            KhoaHoc.setMaGV(KhoaHocDetails.getMaGV());
            KhoaHoc.setThoiLuong(KhoaHocDetails.getThoiLuong());
            KhoaHoc.setHocPhi(KhoaHocDetails.getHocPhi());
            return KhoaHocRepository.save(KhoaHoc);
        }
        return null;
    }

    public void deleteKhoaHoc(String id) {
        KhoaHocRepository.deleteById(id);
    }
}
