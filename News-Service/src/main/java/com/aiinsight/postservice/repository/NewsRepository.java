package com.aiinsight.postservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aiinsight.postservice.model.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

}
