package com.developer.soumya.dto;

import lombok.Data;

@Data
public class CommentResponseDTO {

	private Long id;

	private String name;

	private String email;

	private String body;

	private String postTitle;
}
