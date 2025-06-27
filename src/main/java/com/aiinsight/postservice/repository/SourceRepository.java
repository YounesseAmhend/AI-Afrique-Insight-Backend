package com.aiinsight.postservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aiinsight.postservice.model.Source;

@Repository
public interface SourceRepository extends JpaRepository<Source, Long> {

    Source findByUrl(String url);
}
