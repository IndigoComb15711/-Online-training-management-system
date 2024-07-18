package com.example.DuLieuQuanLyDaoTao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.DuLieuQuanLyDaoTao.dto.HocVienHoanThanhKhoaHocDTO;
import com.example.DuLieuQuanLyDaoTao.entity.HVHTKH;
import com.example.DuLieuQuanLyDaoTao.service.HVHTKHService;

import org.springframework.http.ResponseEntity;

import java.util.List;



@RestController
@RequestMapping("/api/hvhtkh")
public class HVHTKHController {
    @Autowired
    private HVHTKHService HVHTKHService;

    @GetMapping("/hoanthanh")
    public ResponseEntity<List<HocVienHoanThanhKhoaHocDTO>> getAllHocVienHoanThanhKhoaHoc() {
        List<HocVienHoanThanhKhoaHocDTO> result = HVHTKHService.getAllHocVienHoanThanhKhoaHoc();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/hoanthanh/{maKhoaHoc}")
    public ResponseEntity<List<HocVienHoanThanhKhoaHocDTO>> timHocVienHoanThanhKhoaHoc(@PathVariable String maKhoaHoc) {
        List<HocVienHoanThanhKhoaHocDTO> result = HVHTKHService.timHocVienHoanThanhKhoaHoc(maKhoaHoc);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public List<HVHTKH> getAllHVHTKH() {
        return HVHTKHService.getAllHVHTKH();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HVHTKH> getHVHTKHById(@PathVariable String id) {
        HVHTKH HVHTKH = HVHTKHService.getHVHTKHById(id);
        if (HVHTKH != null) {
            return ResponseEntity.ok(HVHTKH);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> createHVHTKH(@RequestBody HVHTKH HVHTKH) {
        try {
            HVHTKH createdHVHTKH = HVHTKHService.createHVHTKH(HVHTKH);
            return ResponseEntity.ok(createdHVHTKH);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<HVHTKH> updateHVHTKH(@PathVariable String id, @RequestBody HVHTKH HVHTKHDetails) {
        HVHTKH updatedHVHTKH = HVHTKHService.updateHVHTKH(id, HVHTKHDetails);
        if (updatedHVHTKH != null) {
            return ResponseEntity.ok(updatedHVHTKH);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHVHTKH(@PathVariable String id) {
        HVHTKHService.deleteHVHTKH(id);
        return ResponseEntity.ok().build();
    }
}