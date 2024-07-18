package com.example.DuLieuQuanLyDaoTao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DuLieuQuanLyDaoTao.entity.HocVien;
import com.example.DuLieuQuanLyDaoTao.repository.HocVienRepository;

import java.util.List;

@Service
public class HocVienService {
    @Autowired
    private HocVienRepository HocVienRepository;

    public List<HocVien> getAllHocVien() {
        return HocVienRepository.findAll();
    }

    public HocVien getHocVienById(String id) {
        return HocVienRepository.findById(id).orElse(null);
    }

    public HocVien createHocVien(HocVien HocVien) {
        if (HocVien.getMaHV() == null || HocVien.getMaHV().trim().isEmpty()) {
            throw new IllegalArgumentException("MaHV không được để trống");
        }
        if (HocVienRepository.existsById(HocVien.getMaHV())) {
            throw new RuntimeException("MaHV đã tồn tại");
        }
        return HocVienRepository.save(HocVien);
    }

    public HocVien updateHocVien(String id, HocVien HocVienDetails) {
        HocVien HocVien = HocVienRepository.findById(id).orElse(null);
        if (HocVien != null) {
            HocVien.setTenHV(HocVienDetails.getTenHV());
            HocVien.setDiaChi(HocVienDetails.getDiaChi());
            HocVien.setSDT(HocVienDetails.getSDT());
            HocVien.setEmail(HocVienDetails.getEmail());
            return HocVienRepository.save(HocVien);
        }
        return null;
    }

    public void deleteHocVien(String id) {
        HocVienRepository.deleteById(id);
    }
}
