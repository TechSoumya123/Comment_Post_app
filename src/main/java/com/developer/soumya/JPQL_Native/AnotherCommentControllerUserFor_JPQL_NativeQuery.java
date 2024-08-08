package com.developer.soumya.JPQL_Native;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.developer.soumya.entity.Comment;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/ok")
@RequiredArgsConstructor
public class AnotherCommentControllerUserFor_JPQL_NativeQuery {

	private final AnotherCommentRepository anotherCommentRepository;

	@GetMapping("/getAll")
	public List<Comment> getAllComments() {
		return anotherCommentRepository.findAll();
	}

	@GetMapping("/findAll")
	public List<Comment> findAllComments() {
		return anotherCommentRepository.findAllComments();
	}

	@GetMapping("/ok/{id}")
	public Comment customFindById(@PathVariable("id") Long id) {
		return anotherCommentRepository.customFindById(id);
	}

	@GetMapping("/ok")
	public List<Comment> findWithLike(@RequestParam("LikeName") String name) {
		return anotherCommentRepository.findWithLike(name);
	}

	@GetMapping("/ok/findWithLikeJpql")
	public List<Comment> findWithLikeJpql(@RequestParam("LikeName") String name) {
		return anotherCommentRepository.findWithLikeJpql(name);
	}

	@GetMapping("/ok/findAllWithNativeQuery")
	public List<Comment> findAllWithNativeQuery() {
		return anotherCommentRepository.findAllWithNativeQuery();
	}

	@GetMapping("/ok/findByIdWithNativeQuery/{id}")
	public Comment findByIdWithNativeQuery(@PathVariable("id") Long id) {
		return anotherCommentRepository.findByIdWithNativeQuery(id);
	}

	@GetMapping("/ok/findByIdWithJpQlNativeQuery/{id}")
	public Comment findByIdWithJpQlNativeQuery(@PathVariable("id") Long id) {
		return anotherCommentRepository.findByIdWithJpQlNativeQuery(id);
	}

	@GetMapping("/ok/findAllWithProjecttions")
	public List<CommentProjection> findAllWithProjecttions() {
		return anotherCommentRepository.findAllWithProjections();
	}
}
