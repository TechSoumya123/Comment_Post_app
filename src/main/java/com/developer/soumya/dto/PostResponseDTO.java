package com.developer.soumya.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class PostResponseDTO {
	private Long id;
	private String title;
	private String description;
	private String content;
	private Long maximumComments;
	private List<CommentResponseDTO> comments = new ArrayList<>();
}
