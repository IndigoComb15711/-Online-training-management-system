package com.example.DuLieuQuanLyDaoTao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DuLieuQuanLyDaoTao.Projection.TongSoHocVienDangKyProjection;
import com.example.DuLieuQuanLyDaoTao.dto.TongSoHocVienDangKyDTO;
import com.example.DuLieuQuanLyDaoTao.entity.DangKy;
import com.example.DuLieuQuanLyDaoTao.repository.DangKyRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DangKyService {
    @Autowired
    private DangKyRepository DangKyRepository;

    public List<TongSoHocVienDangKyDTO> getTongSoHocVienDangKyTheoThang() {
        List<TongSoHocVienDangKyProjection> projections = DangKyRepository.getTongSoHocVienDangKyTheoThang();
        return projections.stream()
            .map(p -> new TongSoHocVienDangKyDTO(
                p.getThang(), 
                p.getSoHocVienDangKyThang(), 
                p.getTongSoHocVienDangKy_TichLuy()))
            .collect(Collectors.toList());
    }

    public List<DangKy> getAllDangKy() {
        return DangKyRepository.findAll();
    }

    public DangKy getDangKyById(String id) {
        return DangKyRepository.findById(id).orElse(null);
    }

    public DangKy createDangKy(DangKy DangKy) {
        if (DangKy.getMaDK() == null || DangKy.getMaDK().trim().isEmpty()) {
            throw new IllegalArgumentException("MaDK không được để trống");
        }
        if (DangKyRepository.existsById(DangKy.getMaDK())) {
            throw new RuntimeException("MaDK đã tồn tại");
        }
        return DangKyRepository.save(DangKy);
    }

    public DangKy updateDangKy(String id, DangKy DangKyDetails) {
        DangKy DangKy = DangKyRepository.findById(id).orElse(null);
        if (DangKy != null) {
            DangKy.setMaHV(DangKyDetails.getMaHV());
            DangKy.setMaKH(DangKyDetails.getMaKH());
            DangKy.setTinhTrangDK(DangKyDetails.getTinhTrangDK());
            DangKy.setNgayDK(DangKyDetails.getNgayDK());
            return DangKyRepository.save(DangKy);
        }
        return null;
    }

    public void deleteDangKy(String id) {
        DangKyRepository.deleteById(id);
    }
}
