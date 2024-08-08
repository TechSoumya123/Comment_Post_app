package com.developer.soumya.pagination_Sorting_searching;

public class PageUtil {

	public static  PageDTO<?> calculatePage(int size, int page, long totalElement) {
		var pageDTO = new PageDTO<>();
		boolean isFirst = false;
		boolean isLast = false;
		long totalPage = 0;

		if (totalElement % size == 0) {
			totalPage = totalElement / size;
		} else {
			totalPage = totalElement / size + 1;
		}

		if (page == totalPage) {
			isLast = true;
		}
		if (page == 1) {
			isFirst = true;
		}

		pageDTO.setFirst(isFirst);
		pageDTO.setLast(isLast);
		pageDTO.setSize(size);
		pageDTO.setPageNumber(page);
		pageDTO.setTotalPage(totalPage);
		pageDTO.setTotalElement(totalElement);
		return pageDTO;
	}

}
