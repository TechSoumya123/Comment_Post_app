package com.developer.soumya.pagination_Sorting_searching;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.developer.soumya.entity.Post;
import com.developer.soumya.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PostControllerImplementPaginationAndSorting {

	private final PostRepository postRepository;

	@GetMapping("/ok")
	public Page<Post> getAllWithPage(@PageableDefault Pageable pageable) {
		return postRepository.findAll(pageable);
	}

	@GetMapping("/ok/title")
	public Page<Post> getAllWithTitlePage(@RequestParam(defaultValue = "", required = false) String title,
			@PageableDefault Pageable pageable) {
		return postRepository.findByTitle(title, pageable);
	}

	@GetMapping("/op")
	public <T> PageDTO<?> getAllPageCustom(@RequestParam(defaultValue = "10", required = false) int size,
			@RequestParam(defaultValue = "1", required = false) int page,
			@RequestParam(defaultValue = "asc", required = false) String direction,
			@RequestParam(defaultValue = "", required = false) String properties,
			@RequestParam(defaultValue = "", required = false) String content,
			@RequestParam(defaultValue = "", required = false) String title) {
		return postRepository.findAllWithCustomPage(size, page, direction, properties, content, title);
	}
}
