package com.developer.soumya.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BaseResponse<T> {

	private T data;
	private boolean success;
	private String code;

}
