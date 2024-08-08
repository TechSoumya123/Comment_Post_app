package com.developer.soumya.service;

import java.util.List;

import com.developer.soumya.dto.CommentRequestDto;
import com.developer.soumya.dto.CommentResponseDTO;

public interface CommentService {

	List<CommentResponseDTO> getAll();

	CommentResponseDTO findById(Long commentId);

	CommentResponseDTO saveComment(CommentRequestDto commentRequestDto);

	CommentResponseDTO updateComment(Long id, CommentRequestDto commentRequestDto);

	String deleteCommentById(Long id);

}
