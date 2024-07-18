package com.example.DuLieuQuanLyDaoTao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.DuLieuQuanLyDaoTao.entity.HocVien;
import com.example.DuLieuQuanLyDaoTao.service.HocVienService;

import org.springframework.http.ResponseEntity;

import java.util.List;



@RestController
@RequestMapping("/api/hocvien")
public class HocVienController {
    @Autowired
    private HocVienService HocVienService;

    @GetMapping
    public List<HocVien> getAllHocVien() {
        return HocVienService.getAllHocVien();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HocVien> getHocVienById(@PathVariable String id) {
        HocVien HocVien = HocVienService.getHocVienById(id);
        if (HocVien != null) {
            return ResponseEntity.ok(HocVien);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> createHocVien(@RequestBody HocVien HocVien) {
        try {
            HocVien createdHocVien = HocVienService.createHocVien(HocVien);
            return ResponseEntity.ok(createdHocVien);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<HocVien> updateHocVien(@PathVariable String id, @RequestBody HocVien HocVienDetails) {
        HocVien updatedHocVien = HocVienService.updateHocVien(id, HocVienDetails);
        if (updatedHocVien != null) {
            return ResponseEntity.ok(updatedHocVien);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHocVien(@PathVariable String id) {
        HocVienService.deleteHocVien(id);
        return ResponseEntity.ok().build();
    }
}