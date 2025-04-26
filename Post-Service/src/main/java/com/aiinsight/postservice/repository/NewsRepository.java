package com.aiinsight.postservice.repository;

import com.aiinsight.postservice.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
  //here we can add all the filters that we want if we want any

}
