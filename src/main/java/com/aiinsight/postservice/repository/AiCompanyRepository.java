package com.aiinsight.postservice.repository;

import com.aiinsight.postservice.model.AiCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AiCompanyRepository extends JpaRepository<AiCompany, Long>
{
  @Query("SELECT a FROM AiCompany a ORDER BY a.createdAt DESC")
  List<AiCompany> findAllOrderByCreatedAtDesc();

  List<AiCompany> findByRegion(String region);

  List<AiCompany> findByCategory(String category);

}
