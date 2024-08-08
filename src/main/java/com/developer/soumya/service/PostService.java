package com.developer.soumya.service;

import java.util.List;

import com.developer.soumya.dto.PostRequestDto;
import com.developer.soumya.dto.PostResponseDTO;

public interface PostService {

	List<PostResponseDTO> getAll();

	PostResponseDTO findById(Long postId);

	PostResponseDTO savePost(PostRequestDto postRequestDto);

	PostResponseDTO updatePost(Long id, PostRequestDto postRequestDto);

	String deletePostById(Long id);

}
