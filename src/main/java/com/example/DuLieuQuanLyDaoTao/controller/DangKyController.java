package com.example.DuLieuQuanLyDaoTao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.DuLieuQuanLyDaoTao.dto.TongSoHocVienDangKyDTO;
import com.example.DuLieuQuanLyDaoTao.entity.DangKy;
import com.example.DuLieuQuanLyDaoTao.service.DangKyService;

import org.springframework.http.ResponseEntity;

import java.util.List;



@RestController
@RequestMapping("/api/dangky")
public class DangKyController {
    @Autowired
    private DangKyService DangKyService;

    @GetMapping("/thongke")
    public ResponseEntity<List<TongSoHocVienDangKyDTO>> getTongSoHocVienDangKyTheoThang() {
        List<TongSoHocVienDangKyDTO> result = DangKyService.getTongSoHocVienDangKyTheoThang();
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public List<DangKy> getAllDangKy() {
        return DangKyService.getAllDangKy();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DangKy> getDangKyById(@PathVariable String id) {
        DangKy DangKy = DangKyService.getDangKyById(id);
        if (DangKy != null) {
            return ResponseEntity.ok(DangKy);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> createDangKy(@RequestBody DangKy DangKy) {
        try {
            DangKy createdDangKy = DangKyService.createDangKy(DangKy);
            return ResponseEntity.ok(createdDangKy);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DangKy> updateDangKy(@PathVariable String id, @RequestBody DangKy DangKyDetails) {
        DangKy updatedDangKy = DangKyService.updateDangKy(id, DangKyDetails);
        if (updatedDangKy != null) {
            return ResponseEntity.ok(updatedDangKy);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDangKy(@PathVariable String id) {
        DangKyService.deleteDangKy(id);
        return ResponseEntity.ok().build();
    }
}