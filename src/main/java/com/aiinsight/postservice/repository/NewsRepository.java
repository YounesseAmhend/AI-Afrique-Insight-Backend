package com.aiinsight.postservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aiinsight.postservice.model.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    List<News> findAllByAuthorId(Long authorId);

    List<News> findAllByCateogoryId(Long id);

    @Modifying
    @Query("UPDATE News n SET n.viewsCount = n.viewsCount + 1 WHERE n.id = :id")
    void incrementViewsCount(@Param("id") Long id);

    @Query(value = "SELECT * FROM news WHERE createdAt >= NOW() - INTERVAL '1 week' ORDER BY viewsCount DESC LIMIT 3", nativeQuery = true)
    List<News> findTrendingNewsThisWeek();

    @Query(value = "SELECT * FROM news WHERE createdAt >= NOW() - INTERVAL '1 month' ORDER BY viewsCount DESC LIMIT 3", nativeQuery = true)
    List<News> findTrendingNewsThisMonth();

    @Query(value = "SELECT * FROM news WHERE createdAt >= NOW() - INTERVAL '1 year' ORDER BY viewsCount DESC LIMIT 3", nativeQuery = true)
    List<News> findTrendingNewsThisYear();
}
