package com.developer.soumya.JPQL_Native;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.developer.soumya.entity.Comment;

public interface AnotherCommentRepository {
	
	List<Comment> findAll();

	List<Comment> findAllComments();

	Comment customFindById(Long id);

	List<Comment> findWithLike(String name);

	@Query("select c from Comment c where c.name like %?1%")
	List<Comment> findWithLikeJpql(String name);

	List<Comment> findAllWithNativeQuery();

	Comment findByIdWithNativeQuery(Long id);

	@Query(value = "select c.* from comment_table c where c.id=?1", nativeQuery = true)
	Comment findByIdWithJpQlNativeQuery(Long id);

	@Query(value = "select c.id  as commentId, c.name as commentName, c.email as commentEmail, c.body as commentBody "
			+ "from comment_table c", nativeQuery = true)
	List<CommentProjection> findAllWithProjections();

}
