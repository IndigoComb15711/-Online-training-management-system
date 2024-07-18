package com.example.DuLieuQuanLyDaoTao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DuLieuQuanLyDaoTao.Projection.GiangVienHocVienNhieuNhatProjection;
import com.example.DuLieuQuanLyDaoTao.Projection.ThongKeHocVienProjection;
import com.example.DuLieuQuanLyDaoTao.dto.GiangVienHocVienNhieuNhatDTO;
import com.example.DuLieuQuanLyDaoTao.dto.ThongKeHocVienDTO;
import com.example.DuLieuQuanLyDaoTao.entity.GiangVien;
import com.example.DuLieuQuanLyDaoTao.repository.GiangVienRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GiangVienService {
    @Autowired
    private GiangVienRepository GiangVienRepository;

    public List<GiangVienHocVienNhieuNhatDTO> getTop3GiangVienNhieuHocVienNhat() {
        List<GiangVienHocVienNhieuNhatProjection> projections = GiangVienRepository.findTop3GiangVienNhieuHocVienNhat();
        return projections.stream()
            .map(p -> new GiangVienHocVienNhieuNhatDTO(p.getMaGV(), p.getTenGV(), p.getSoLuongHocVien()))
            .collect(Collectors.toList());
    }

    public List<ThongKeHocVienDTO> thongKeHocVienTheoGiangVien(String maGV) {
        List<ThongKeHocVienProjection> projections = GiangVienRepository.thongKeHocVienTheoGiangVien(maGV);
        return projections.stream()
            .map(p -> new ThongKeHocVienDTO(p.getMaHV(), p.getTenHV()))
            .collect(Collectors.toList());
    }

    public List<GiangVien> getAllGiangVien() {
        return GiangVienRepository.findAll();
    }

    public GiangVien getGiangVienById(String id) {
        return GiangVienRepository.findById(id).orElse(null);
    }

    public GiangVien createGiangVien(GiangVien GiangVien) {
        if (GiangVien.getMaGV() == null || GiangVien.getMaGV().trim().isEmpty()) {
            throw new IllegalArgumentException("MaGV không được để trống");
        }
        if (GiangVienRepository.existsById(GiangVien.getMaGV())) {
            throw new RuntimeException("MaGV đã tồn tại");
        }
        return GiangVienRepository.save(GiangVien);
    }

    public GiangVien updateGiangVien(String id, GiangVien GiangVienDetails) {
        GiangVien GiangVien = GiangVienRepository.findById(id).orElse(null);
        if (GiangVien != null) {
            GiangVien.setTenGV(GiangVienDetails.getTenGV());
            GiangVien.setChuyenMon(GiangVienDetails.getChuyenMon());
            GiangVien.setKinhNghiem(GiangVienDetails.getKinhNghiem());
            return GiangVienRepository.save(GiangVien);
        }
        return null;
    }

    public void deleteGiangVien(String id) {
        GiangVienRepository.deleteById(id);
    }
}
