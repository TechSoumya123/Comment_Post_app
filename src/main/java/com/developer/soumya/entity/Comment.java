package com.developer.soumya.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityResult;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.SqlResultSetMappings;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NamedQueries(value = { @NamedQuery(name = "Comment.findAllComments", query = "select c from Comment c"),
		@NamedQuery(name = "Comment.customFindById", query = "select c from Comment c where c.id = ?1"),
		@NamedQuery(name = "Comment.findWithLike", query = "select c from Comment c where c.name like ?1") })

@SqlResultSetMappings(value = {
		@SqlResultSetMapping(name = "findAllWithNativeQuery", entities = {
				@EntityResult(entityClass = Comment.class) }),
		@SqlResultSetMapping(name = "findByIdWithNativeQuery", entities = {
				@EntityResult(entityClass = Comment.class) })

})

@NamedNativeQueries(value = {
		@NamedNativeQuery(name = "Comment.findAllWithNativeQuery", query = "select c.* from comment_table c", resultSetMapping = "findAllWithNativeQuery"),
		@NamedNativeQuery(name = "Comment.findByIdWithNativeQuery", query = "select c.* from comment_table c where c.id=?1", resultSetMapping = "findByIdWithNativeQuery") })

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "comment_table")
public class Comment implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String email;

	private String body;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "post_id")
	@JsonIgnore
	private Post post;

}
