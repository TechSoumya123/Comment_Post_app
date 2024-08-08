package com.developer.soumya.pagination_Sorting_searching;

public interface PostRepositoryCustom<T> {
	PageDTO<?> findAllWithCustomPage(int size, int page, String direction, String properties, String content,
			String title);
}
