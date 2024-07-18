package com.example.DuLieuQuanLyDaoTao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.DuLieuQuanLyDaoTao.dto.DangKyKhoaHocDTO;
import com.example.DuLieuQuanLyDaoTao.dto.DanhSachHocVienDTO;
import com.example.DuLieuQuanLyDaoTao.dto.KhoaHocDTO;
import com.example.DuLieuQuanLyDaoTao.dto.KhoaHocPhoBienDTO;
import com.example.DuLieuQuanLyDaoTao.entity.KhoaHoc;
import com.example.DuLieuQuanLyDaoTao.service.KhoaHocService;

import org.springframework.http.ResponseEntity;

import java.util.List;



@RestController
@RequestMapping("/api/khoahoc")
public class KhoaHocController {
    @Autowired
    private KhoaHocService KhoaHocService;

    @GetMapping("/dangkykhoahoc")
    public ResponseEntity<List<DangKyKhoaHocDTO>> getAllDangKyKhoaHoc() {
        List<DangKyKhoaHocDTO> dangKyList = KhoaHocService.getAllDangKyKhoaHoc();
        if (dangKyList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(dangKyList);
    }

    @GetMapping("/danhsachhocvien/{maKH}")
    public ResponseEntity<List<DanhSachHocVienDTO>> getDanhSachHocVienTheoKhoaHoc(@PathVariable String maKH) {
        List<DanhSachHocVienDTO> danhSach = KhoaHocService.getDanhSachHocVienTheoKhoaHoc(maKH);
        return ResponseEntity.ok(danhSach);
    }

    @GetMapping("/timkiem")
    public ResponseEntity<List<KhoaHocDTO>> timKiemKhoaHocTheoMaGV(
        @RequestParam(required = false) String maGV,
        @RequestParam(required = false) String hocPhiMin,
        @RequestParam(required = false) String hocPhiMax
    ) {
        List<KhoaHocDTO> result = KhoaHocService.timKiemKhoaHocTheoMaGV(maGV, hocPhiMin, hocPhiMax);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/timkiem-hocphi")
    public ResponseEntity<List<KhoaHocDTO>> timKiemKhoaHocTheoHocPhi(
        @RequestParam(required = false) String maGV,
        @RequestParam(required = false) String hocPhiMin,
        @RequestParam(required = false) String hocPhiMax
    ) {
        List<KhoaHocDTO> result = KhoaHocService.timKiemKhoaHocTheoHocPhi(maGV, hocPhiMin, hocPhiMax);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/pho-bien")
    public ResponseEntity<List<KhoaHocPhoBienDTO>> getTopPopularCourses() {
        List<KhoaHocPhoBienDTO> popularCourses = KhoaHocService.getTopPopularCourses();
        return ResponseEntity.ok(popularCourses);
    }
    
    @GetMapping
    public List<KhoaHoc> getAllKhoaHoc() {
        return KhoaHocService.getAllKhoaHoc();
    }

    @GetMapping("/{id}")
    public ResponseEntity<KhoaHoc> getKhoaHocById(@PathVariable String id) {
        KhoaHoc KhoaHoc = KhoaHocService.getKhoaHocById(id);
        if (KhoaHoc != null) {
            return ResponseEntity.ok(KhoaHoc);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> createKhoaHoc(@RequestBody KhoaHoc KhoaHoc) {
        try {
            KhoaHoc createdKhoaHoc = KhoaHocService.createKhoaHoc(KhoaHoc);
            return ResponseEntity.ok(createdKhoaHoc);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<KhoaHoc> updateKhoaHoc(@PathVariable String id, @RequestBody KhoaHoc KhoaHocDetails) {
        KhoaHoc updatedKhoaHoc = KhoaHocService.updateKhoaHoc(id, KhoaHocDetails);
        if (updatedKhoaHoc != null) {
            return ResponseEntity.ok(updatedKhoaHoc);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKhoaHoc(@PathVariable String id) {
        KhoaHocService.deleteKhoaHoc(id);
        return ResponseEntity.ok().build();
    }
}