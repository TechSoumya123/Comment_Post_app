package com.developer.soumya.pagination_Sorting_searching;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import com.developer.soumya.entity.Post;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PostRepositoryCustomImpl<T> implements PostRepositoryCustom<T> {

	private final EntityManager entityManager;

	@Override
	public PageDTO<?> findAllWithCustomPage(int size, int page, String direction, String properties, String content,
			String title) {

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Long> count = criteriaBuilder.createQuery(Long.class);
		count.select(criteriaBuilder.count(count.from(Post.class)));

		// get total element to calculate page
//		Long totalElement = entityManager.createQuery(count).getSingleResult();

		// write query to get data

		CriteriaQuery<Post> query = criteriaBuilder.createQuery(Post.class);

		Root<Post> from = query.from(Post.class);

		CriteriaQuery<Post> select = query.select(from);

		List<Predicate> predicates = new ArrayList<>();

//		solve searching like operator

		if (!ObjectUtils.isEmpty(content)) {
			predicates.add(criteriaBuilder.like(from.get("content"), " %" + content + "%"));
		}
		if (!ObjectUtils.isEmpty(title)) {
			predicates.add(criteriaBuilder.like(from.get("title"), "%" + title + "%"));

		}
		select.select(from).where(predicates.toArray(new Predicate[] {}));

//		solve direction and sort 

		if (direction.equalsIgnoreCase("desc") && !ObjectUtils.isEmpty(properties)) {
			query.orderBy(criteriaBuilder.asc(from.get(properties)));

		} else if (direction.equalsIgnoreCase("asc") && !ObjectUtils.isEmpty(properties)) {
			query.orderBy(criteriaBuilder.asc(from.get(properties)));
		}

//		solve page and size
		TypedQuery<Post> typedQuery = entityManager.createQuery(select);

//		solve total elements
		long totalCount = typedQuery.getResultList().size();

		int offSet = (page - 1) * size;
		typedQuery.setFirstResult(offSet);
		typedQuery.setMaxResults(size);

//		set data and return 
		PageDTO<?> pageDTO = PageUtil.calculatePage(size, page, totalCount);
		pageDTO.setData(typedQuery.getResultList());
		return pageDTO;
	}

}
