//package com.developer.soumya.util;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.stereotype.Component;
//
//import com.developer.soumya.dto.requestDto.CommentRequestDto;
//import com.developer.soumya.dto.responseDto.CommentResponseDto;
//import com.developer.soumya.entity.Comment;
//
//@Component
//public class CommentMapper {
//
//	public static Comment dto_To_Comment(CommentRequestDto commentRequestDto) {
//		Comment comment = new Comment();
//		comment.setName(commentRequestDto.getName());
//		comment.setEmail(commentRequestDto.getEmail());
//		comment.setBody(commentRequestDto.getBody());
//		return comment;
//	}
//
//	public static CommentRequestDto comment_To_RequestDto(Comment comment) {
//		CommentRequestDto commentRequestDto = new CommentRequestDto();
//		commentRequestDto.setName(comment.getName());
//		commentRequestDto.setEmail(comment.getEmail());
//		commentRequestDto.setBody(comment.getBody());
//		return commentRequestDto;
//	}
//
//	public static CommentResponseDto comment_To_ResponseDto(Comment comment) {
//		CommentResponseDto commentResponseDto = new CommentResponseDto();
//		commentResponseDto.setId(comment.getId());
//		commentResponseDto.setName(comment.getName());
//		commentResponseDto.setEmail(comment.getEmail());
//		commentResponseDto.setBody(comment.getBody());
//		commentResponseDto.setPost(comment.getPost());
//		return commentResponseDto;
//	}
//
//	public static Comment existing_To_Updated_Comment(Comment existingComment, CommentRequestDto commentRequestDto) {
//		existingComment.setName(commentRequestDto.getName());
//		existingComment.setEmail(commentRequestDto.getEmail());
//		existingComment.setBody(commentRequestDto.getBody());
//		return existingComment;
//	}
//
//	public static List<CommentResponseDto> listOfComment_To_ListOfCommentResponseDtos(List<Comment> listOfComments) {
//		return listOfComments.stream().map(CommentMapper::comment_To_ResponseDto).collect(Collectors.toList());
//	}
//}
