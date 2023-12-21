package com.newsify.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.newsify.entity.NewsPost;

@Repository
public interface NewsRepository extends JpaRepository<NewsPost, Integer> {

	@Query(nativeQuery = true, value = "SELECT * FROM posts p WHERE p.category IN(?1) AND p.city_id IN(?2)")
	Page<NewsPost> findByCategoryAndCityId(List<Integer> category, List<Integer> cityId, Pageable pageable);

}
