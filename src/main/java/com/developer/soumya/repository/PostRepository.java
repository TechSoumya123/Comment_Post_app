package com.developer.soumya.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.developer.soumya.entity.Post;
import com.developer.soumya.pagination_Sorting_searching.PostRepositoryCustom;

public interface PostRepository extends JpaRepository<Post, Long>, PostRepositoryCustom<Object> {

	Page<Post> findAll(Pageable pageable);

	@Query("select p from Post p where p.title like ?1")
	Page<Post> findByTitle(String title, Pageable pageable);
}
