package com.example.DuLieuQuanLyDaoTao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DuLieuQuanLyDaoTao.entity.HocVien;

@Repository
public interface HocVienRepository extends JpaRepository<HocVien, String> {

}