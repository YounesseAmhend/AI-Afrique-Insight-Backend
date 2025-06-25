package com.aiinsight.postservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aiinsight.postservice.model.Cateogory;

public interface CateogoryRepository extends JpaRepository<Cateogory, Long> {
}