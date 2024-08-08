package com.developer.soumya.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.developer.soumya.dto.CommentRequestDto;
import com.developer.soumya.dto.CommentResponseDTO;
import com.developer.soumya.entity.Comment;
import com.developer.soumya.entity.Post;
import com.developer.soumya.error.ResourceNotFoundException;
import com.developer.soumya.repository.CommentRepository;
import com.developer.soumya.repository.PostRepository;
import com.developer.soumya.service.CommentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

	private final CommentRepository commentRepository;

	private final PostRepository postRepository;

	@Override
	public List<CommentResponseDTO> getAll() {
		return commentRepository.findAll().stream().map(CommentServiceImpl::comment_toCommentResponseDto)
				.collect(Collectors.toList());
	}

	@Override
	public CommentResponseDTO findById(Long commentId) {
		return commentRepository.findById(commentId).map(CommentServiceImpl::comment_toCommentResponseDto)
				.orElseThrow(() -> new ResourceNotFoundException("Comment not found " + commentId));
	}

	@Override
	public CommentResponseDTO saveComment(CommentRequestDto commentRequestDto) {
		Post post = postRepository.findById(commentRequestDto.getPostId())
				.orElseThrow(() -> new ResourceNotFoundException("Post not found " + commentRequestDto.getPostId()));
		Comment comment = new Comment();
		comment.setName(commentRequestDto.getName());
		comment.setEmail(commentRequestDto.getEmail());
		comment.setBody(commentRequestDto.getBody());
		comment.setPost(post);
		Comment saveok = commentRepository.save(comment);
		return comment_toCommentResponseDto(saveok);
	}

	@Override
	public CommentResponseDTO updateComment(Long id, CommentRequestDto commentRequestDto) {
		Comment comment = commentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Comment not found " + id));
		Post post = postRepository.findById(commentRequestDto.getPostId())
				.orElseThrow(() -> new ResourceNotFoundException("Post not found " + commentRequestDto.getPostId()));
		comment.setBody(commentRequestDto.getBody());
		comment.setEmail(commentRequestDto.getEmail());
		comment.setName(commentRequestDto.getName());
		comment.setPost(post);
		Comment updateComment = commentRepository.save(comment);
		return comment_toCommentResponseDto(updateComment);
	}

	@Override
	public String deleteCommentById(Long id) {
		commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comment not found " + id));
		commentRepository.deleteById(id);
		return "SUCCESS";
	}

	public static CommentResponseDTO comment_toCommentResponseDto(Comment comment) {
		CommentResponseDTO commentResponseDTO = new CommentResponseDTO();
		commentResponseDTO.setId(comment.getId());
		commentResponseDTO.setBody(comment.getBody());
		commentResponseDTO.setEmail(comment.getEmail());
		commentResponseDTO.setName(comment.getName());
		commentResponseDTO.setPostTitle(comment.getPost().getTitle());
		return commentResponseDTO;
	}

}
