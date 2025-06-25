package com.aiinsight.postservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aiinsight.postservice.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    
}
