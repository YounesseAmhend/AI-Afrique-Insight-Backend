package com.aiinsight.postservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aiinsight.postservice.model.Source;

@Repository
public interface SourceRepository extends JpaRepository<Source, Long> {

    Source findByUrl(String url);

    @Modifying
    @Query(value = "UPDATE sources SET url = :url, triggerAi = :triggerAi, triggerAfrica = :triggerAfrica WHERE id = :id", nativeQuery = true)
    int updateSource(@Param("id") Long id, @Param("url") String url, @Param("triggerAi") boolean triggerAi,
            @Param("triggerAfrica") boolean triggerAfrica);
}