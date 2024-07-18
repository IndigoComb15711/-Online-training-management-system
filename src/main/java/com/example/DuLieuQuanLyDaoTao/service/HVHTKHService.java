package com.example.DuLieuQuanLyDaoTao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DuLieuQuanLyDaoTao.Projection.HocVienHoanThanhKhoaHocProjection;
import com.example.DuLieuQuanLyDaoTao.dto.HocVienHoanThanhKhoaHocDTO;
import com.example.DuLieuQuanLyDaoTao.entity.HVHTKH;
import com.example.DuLieuQuanLyDaoTao.repository.HVHTKHRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HVHTKHService {
    @Autowired
    private HVHTKHRepository HVHTKHRepository;

    public List<HocVienHoanThanhKhoaHocDTO> getAllHocVienHoanThanhKhoaHoc() {
        List<HocVienHoanThanhKhoaHocProjection> projections = HVHTKHRepository.findAllHocVienHoanThanhKhoaHoc();
        return projections.stream()
            .map(p -> new HocVienHoanThanhKhoaHocDTO(p.getMaHV(), p.getTenHV(), p.getMaKH(), p.getTenKH()))
            .collect(Collectors.toList());
    }

    public List<HocVienHoanThanhKhoaHocDTO> timHocVienHoanThanhKhoaHoc(String maKhoaHoc) {
        List<HocVienHoanThanhKhoaHocProjection> projections = HVHTKHRepository.timHocVienHoanThanhKhoaHoc(maKhoaHoc);
        return projections.stream()
            .map(p -> new HocVienHoanThanhKhoaHocDTO(p.getMaHV(), p.getTenHV(), p.getMaKH(), p.getTenKH()))
            .collect(Collectors.toList());
    }

    public List<HVHTKH> getAllHVHTKH() {
        return HVHTKHRepository.findAll();
    }

    public HVHTKH getHVHTKHById(String id) {
        return HVHTKHRepository.findById(id).orElse(null);
    }

    public HVHTKH createHVHTKH(HVHTKH HVHTKH) {
        if (HVHTKH.getMaHV() == null || HVHTKH.getMaHV().trim().isEmpty()) {
            throw new IllegalArgumentException("MaHV không được để trống");
        }
        if (HVHTKHRepository.existsById(HVHTKH.getMaHV())) {
            throw new RuntimeException("MaHV đã tồn tại");
        }
        return HVHTKHRepository.save(HVHTKH);
    }

    public HVHTKH updateHVHTKH(String id, HVHTKH HVHTKHDetails) {
        HVHTKH HVHTKH = HVHTKHRepository.findById(id).orElse(null);
        if (HVHTKH != null) {
            HVHTKH.setMaKH(HVHTKHDetails.getMaKH());
            return HVHTKHRepository.save(HVHTKH);
        }
        return null;
    }

    public void deleteHVHTKH(String id) {
        HVHTKHRepository.deleteById(id);
    }
}
