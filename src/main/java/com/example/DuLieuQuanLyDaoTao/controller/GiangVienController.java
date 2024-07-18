package com.example.DuLieuQuanLyDaoTao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.DuLieuQuanLyDaoTao.dto.GiangVienHocVienNhieuNhatDTO;
import com.example.DuLieuQuanLyDaoTao.dto.ThongKeHocVienDTO;
import com.example.DuLieuQuanLyDaoTao.entity.GiangVien;
import com.example.DuLieuQuanLyDaoTao.service.GiangVienService;

import org.springframework.http.ResponseEntity;

import java.util.List;



@RestController
@RequestMapping("/api/giangvien")
public class GiangVienController {
    @Autowired
    private GiangVienService GiangVienService;

    @GetMapping("/thongkehocvien/{maGV}")
    public ResponseEntity<List<ThongKeHocVienDTO>> thongKeHocVienTheoGiangVien(@PathVariable String maGV) {
        List<ThongKeHocVienDTO> result = GiangVienService.thongKeHocVienTheoGiangVien(maGV);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/top3-nhieu-hocvien")
    public ResponseEntity<List<GiangVienHocVienNhieuNhatDTO>> getTop3GiangVienNhieuHocVienNhat() {
        List<GiangVienHocVienNhieuNhatDTO> result = GiangVienService.getTop3GiangVienNhieuHocVienNhat();
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public List<GiangVien> getAllGiangVien() {
        return GiangVienService.getAllGiangVien();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GiangVien> getGiangVienById(@PathVariable String id) {
        GiangVien GiangVien = GiangVienService.getGiangVienById(id);
        if (GiangVien != null) {
            return ResponseEntity.ok(GiangVien);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> createGiangVien(@RequestBody GiangVien GiangVien) {
        try {
            GiangVien createdGiangVien = GiangVienService.createGiangVien(GiangVien);
            return ResponseEntity.ok(createdGiangVien);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<GiangVien> updateGiangVien(@PathVariable String id, @RequestBody GiangVien GiangVienDetails) {
        GiangVien updatedGiangVien = GiangVienService.updateGiangVien(id, GiangVienDetails);
        if (updatedGiangVien != null) {
            return ResponseEntity.ok(updatedGiangVien);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGiangVien(@PathVariable String id) {
        GiangVienService.deleteGiangVien(id);
        return ResponseEntity.ok().build();
    }
}