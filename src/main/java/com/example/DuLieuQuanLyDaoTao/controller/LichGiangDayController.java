package com.example.DuLieuQuanLyDaoTao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.DuLieuQuanLyDaoTao.dto.LichGiangDayDTO;
import com.example.DuLieuQuanLyDaoTao.entity.LichGiangDay;
import com.example.DuLieuQuanLyDaoTao.service.LichGiangDayService;

import org.springframework.http.ResponseEntity;

import java.util.List;



@RestController
@RequestMapping("/api/lichgiangday")
public class LichGiangDayController {
    @Autowired
    private LichGiangDayService LichGiangDayService;

    @GetMapping
    public ResponseEntity<List<LichGiangDayDTO>> getAllLichGiangDay() {
        List<LichGiangDayDTO> lichGiangDayList = LichGiangDayService.getAllLichGiangDay();
        return ResponseEntity.ok(lichGiangDayList);
    }

    @GetMapping("/giang-vien/{maGV}")
    public ResponseEntity<List<LichGiangDayDTO>> getLichGiangDayByMaGV(@PathVariable String maGV) {
        List<LichGiangDayDTO> lichGiangDayList = LichGiangDayService.getLichGiangDayByMaGV(maGV);
        return ResponseEntity.ok(lichGiangDayList);
    }

    @GetMapping("/ngay/{ngayGiangDay}")
    public ResponseEntity<List<LichGiangDayDTO>> getLichGiangDayByNgay(@PathVariable String ngayGiangDay) {
        List<LichGiangDayDTO> lichGiangDayList = LichGiangDayService.getLichGiangDayByNgay(ngayGiangDay);
        return ResponseEntity.ok(lichGiangDayList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LichGiangDay> getLichGiangDayById(@PathVariable String id) {
        LichGiangDay LichGiangDay = LichGiangDayService.getLichGiangDayById(id);
        if (LichGiangDay != null) {
            return ResponseEntity.ok(LichGiangDay);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> createLichGiangDay(@RequestBody LichGiangDay LichGiangDay) {
        try {
            LichGiangDay createdLichGiangDay = LichGiangDayService.createLichGiangDay(LichGiangDay);
            return ResponseEntity.ok(createdLichGiangDay);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<LichGiangDay> updateLichGiangDay(@PathVariable String id, @RequestBody LichGiangDay LichGiangDayDetails) {
        LichGiangDay updatedLichGiangDay = LichGiangDayService.updateLichGiangDay(id, LichGiangDayDetails);
        if (updatedLichGiangDay != null) {
            return ResponseEntity.ok(updatedLichGiangDay);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLichGiangDay(@PathVariable String id) {
        LichGiangDayService.deleteLichGiangDay(id);
        return ResponseEntity.ok().build();
    }
}