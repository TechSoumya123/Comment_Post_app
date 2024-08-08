package com.developer.soumya.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.developer.soumya.dto.PostRequestDto;
import com.developer.soumya.service.PostService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = { "/post" })
@RequiredArgsConstructor
public class PostController {

	private final PostService postService;

	@GetMapping("/getAll")
	public ResponseEntity<Object> findAll() {
		return new ResponseEntity<>(postService.getAll(), HttpStatus.OK);
	}

	@PostMapping(path = { "/create-new" })
	public ResponseEntity<?> create_new_Post(@RequestBody @Valid final PostRequestDto postRequestDto) {
		return new ResponseEntity<>(postService.savePost(postRequestDto), CREATED);
	}

	@GetMapping("/byId/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long postId) {
		return new ResponseEntity<>(postService.findById(postId), OK);
	}

	@PostMapping(path = { "/update/{id}" })
	public ResponseEntity<?> update_Post(@PathVariable("id") Long id, @RequestBody PostRequestDto postRequestDto) {
		return new ResponseEntity<>(postService.updatePost(id, postRequestDto), OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletePost(@PathVariable("id") Long id) {
		return new ResponseEntity<>(postService.deletePostById(id), HttpStatus.OK);
	}
}
