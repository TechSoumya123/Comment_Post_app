//package com.developer.soumya.util;
//
//import static com.developer.soumya.util.CommentMapper.*;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.stereotype.Component;
//
//import com.developer.soumya.dto.requestDto.PostRequestDto;
//import com.developer.soumya.dto.responseDto.PostResponeDto;
//import com.developer.soumya.entity.Post;
//
//@Component
//public class PostMapper {
//
//	public static PostResponeDto post_To_PostResponseDto(Post post) {
//		return PostResponeDto.builder()
//				.id(post.getId()).title(post.getTitle())
//				.description(post.getDescription())
//				.content(post.getContent())
//				.comments(post.getComments().stream()
//						.map(comment -> comment_To_ResponseDto(comment)).collect(Collectors.toSet()))
//				.build();
//	}
//
//	public static Post postRequestDto_To_Post(PostRequestDto postRequestDto) {
//		Post post = new Post();
//		post.setTitle(postRequestDto.getTitle());
//		post.setDescription(postRequestDto.getDescription());
//		post.setContent(postRequestDto.getContent());
//		return post;
//	}
//
//	public static Post existingPost_To_UpdatePost(Post existingPost, PostRequestDto postRequestDto) {
//		existingPost.setTitle(postRequestDto.getTitle());
//		existingPost.setDescription(postRequestDto.getDescription());
//		existingPost.setContent(postRequestDto.getContent());
//		return existingPost;
//	}
//
//	public static List<PostResponeDto> post_To_PostResponeDtos(List<Post> listOfPosts) {
//		return listOfPosts.stream().map(PostMapper::post_To_PostResponseDto).collect(Collectors.toList());
//	}
//}
