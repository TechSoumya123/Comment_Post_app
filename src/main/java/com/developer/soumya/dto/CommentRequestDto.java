package com.developer.soumya.dto;

import lombok.Data;

@Data
public class CommentRequestDto {
	private String name;
	private String email;
	private String body;
	private Long postId;
}
