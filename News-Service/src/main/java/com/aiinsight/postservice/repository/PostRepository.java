package com.aiinsight.postservice.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aiinsight.postservice.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post , UUID> {
  // here we can add all the filters that we want if we want any

}
