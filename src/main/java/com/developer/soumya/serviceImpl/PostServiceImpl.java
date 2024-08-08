package com.developer.soumya.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.developer.soumya.dto.PostRequestDto;
import com.developer.soumya.dto.PostResponseDTO;
import com.developer.soumya.entity.Post;
import com.developer.soumya.error.ResourceNotFoundException;
import com.developer.soumya.repository.PostRepository;
import com.developer.soumya.service.PostService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

	private final PostRepository postRepository;

	@Override
	public List<PostResponseDTO> getAll() {
		return postRepository.findAll().stream().map(PostServiceImpl::post_To_PostResponseDTO)
				.collect(Collectors.toList());
	}

	@Override
	public PostResponseDTO findById(Long postId) {
		Post post = postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post not found " + postId));
		return post_To_PostResponseDTO(post);
	}

	@Override
	public PostResponseDTO savePost(PostRequestDto postRequestDto) {
		Post dto_To_Post = postRequestDto_To_Post(postRequestDto);
		Post savePost = postRepository.save(dto_To_Post);
		return post_To_PostResponseDTO(savePost);
	}

	@Override
	public PostResponseDTO updatePost(Long id, PostRequestDto postRequestDto) {
		Post post = postRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Post not found " + id));
		post.setTitle(postRequestDto.getTitle());
		post.setDescription(postRequestDto.getDescription());
		post.setContent(postRequestDto.getContent());
		post.setMaximumComments(postRequestDto.getMaximumComments());
		Post savePost = postRepository.save(post);
		return post_To_PostResponseDTO(savePost);
	}

	@Override
	public String deletePostById(Long id) {
		postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post not found " + id));
		postRepository.deleteById(id);
		return "DELETED SUCCESSFULLY";
	}

	public Post postRequestDto_To_Post(PostRequestDto postRequestDto) {
		Post post = new Post();
		post.setTitle(postRequestDto.getTitle());
		post.setDescription(postRequestDto.getDescription());
		post.setContent(postRequestDto.getContent());
		post.setMaximumComments(postRequestDto.getMaximumComments());
		return post;
	}

	public static PostResponseDTO post_To_PostResponseDTO(Post post) {
		PostResponseDTO postResponseDTO = new PostResponseDTO();
		postResponseDTO.setId(post.getId());
		postResponseDTO.setTitle(post.getTitle());
		postResponseDTO.setDescription(post.getDescription());
		postResponseDTO.setContent(post.getContent());
		postResponseDTO.setComments(post.getComments().stream()
				.map(comment -> CommentServiceImpl.comment_toCommentResponseDto(comment)).collect(Collectors.toList()));
		return postResponseDTO;
	}
}
