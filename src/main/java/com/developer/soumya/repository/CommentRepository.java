package com.developer.soumya.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.developer.soumya.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
