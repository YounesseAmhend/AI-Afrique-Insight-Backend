package com.aiinsight.postservice.repository;

import com.aiinsight.postservice.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<Post , UUID> {
  //here we can add all the filters that we want if we want any
}
