package com.developer.soumya.pagination_Sorting_searching;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageDTO<T> {

	private int pageNumber;
	private int size;
	private long totalElement;
	private boolean isLast;
	private boolean isFirst;
	private long totalPage;
	private List<?> data;

}
