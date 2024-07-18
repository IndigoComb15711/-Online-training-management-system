package com.example.DuLieuQuanLyDaoTao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DuLieuQuanLyDaoTao.dto.LichGiangDayDTO;
import com.example.DuLieuQuanLyDaoTao.entity.LichGiangDay;
import com.example.DuLieuQuanLyDaoTao.repository.LichGiangDayRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LichGiangDayService {
    @Autowired
    private LichGiangDayRepository LichGiangDayRepository;

    public List<LichGiangDayDTO> getAllLichGiangDay() {
        return LichGiangDayRepository.findAllLichGiangDay();
    }

    public List<LichGiangDayDTO> getLichGiangDayByMaGV(String maGV) {
        List<Object[]> results = LichGiangDayRepository.findLichGiangDayByMaGV(maGV);
        return results.stream().map(this::mapToLichGiangDayDTO).collect(Collectors.toList());
    }

    public List<LichGiangDayDTO> getLichGiangDayByNgay(String ngayGiangDay) {
        List<Object[]> results = LichGiangDayRepository.findLichGiangDayByNgay(ngayGiangDay);
        return results.stream().map(this::mapToLichGiangDayDTO).collect(Collectors.toList());
    }
    
    private LichGiangDayDTO mapToLichGiangDayDTO(Object[] row) {
        return new LichGiangDayDTO(
            (String) row[0],               // MaLich
            (String) row[1],               // MaGV
            (String) row[2],               // TenGV
            (String) row[3],               // MaKH
            (String) row[4],               // TenKH
            (String) row[5],               // NgayGiangDay
            (String) row[6]                // KhungGio
        );
    }

    public LichGiangDay getLichGiangDayById(String id) {
        return LichGiangDayRepository.findById(id).orElse(null);
    }

    public LichGiangDay createLichGiangDay(LichGiangDay LichGiangDay) {
        if (LichGiangDay.getMaLich() == null || LichGiangDay.getMaLich().trim().isEmpty()) {
            throw new IllegalArgumentException("MaLich không được để trống");
        }
        if (LichGiangDayRepository.existsById(LichGiangDay.getMaLich())) {
            throw new RuntimeException("MaLich đã tồn tại");
        }
        return LichGiangDayRepository.save(LichGiangDay);
    }

    public LichGiangDay updateLichGiangDay(String id, LichGiangDay LichGiangDayDetails) {
        LichGiangDay LichGiangDay = LichGiangDayRepository.findById(id).orElse(null);
        if (LichGiangDay != null) {
            LichGiangDay.setMaGV(LichGiangDayDetails.getMaGV());
            LichGiangDay.setMaKH(LichGiangDayDetails.getMaKH());
            LichGiangDay.setNgayGiangDay(LichGiangDayDetails.getNgayGiangDay());
            LichGiangDay.setKhungGio(LichGiangDayDetails.getKhungGio());
            return LichGiangDayRepository.save(LichGiangDay);
        }
        return null;
    }

    public void deleteLichGiangDay(String id) {
        LichGiangDayRepository.deleteById(id);
    }
}
