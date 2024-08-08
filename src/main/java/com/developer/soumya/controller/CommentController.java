package com.developer.soumya.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.developer.soumya.dto.CommentRequestDto;
import com.developer.soumya.dto.CommentResponseDTO;
import com.developer.soumya.service.CommentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = { "/comment" })
@RequiredArgsConstructor
public class CommentController {

	private final CommentService commentService;

	@GetMapping("/getAll")
	public ResponseEntity<List<CommentResponseDTO>> getAll() {
		return new ResponseEntity<>(commentService.getAll(), HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<CommentResponseDTO> createComment(@RequestBody CommentRequestDto commentRequestDto) {
		return new ResponseEntity<>(commentService.saveComment(commentRequestDto), HttpStatus.CREATED);
	}

	@GetMapping(path = { "/get-By-Id/{id}" })
	public ResponseEntity<CommentResponseDTO> getCommentById(@PathVariable("id") Long commentId) {
		return new ResponseEntity<>(commentService.findById(commentId), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<CommentResponseDTO> update(@PathVariable("id") Long id,
			@RequestBody CommentRequestDto commentRequestDto) {
		return new ResponseEntity<>(commentService.updateComment(id, commentRequestDto), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> commentDelete(@PathVariable("id") Long id) {
		return new ResponseEntity<>(commentService.deleteCommentById(id), HttpStatus.OK);
	}

}
