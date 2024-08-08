package com.developer.soumya.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PostRequestDto {

	@NotNull(message = "Title must be required")
	@NotEmpty(message = "Title must not be empty")
	@Length(min = 1, max = 40, message = "Invalid input field tile")
	private String title;

	@NotNull(message = "Description is required")
	@NotEmpty
	private String description;

	@NotNull(message = "Content is required")
	@NotEmpty(message = "Content must not be empty")
	private String content;

	@NotNull(message = "Maximum of comments is required")
	@Max(value = 6)
	@Min(value = 1)
	private Long maximumComments;
}
