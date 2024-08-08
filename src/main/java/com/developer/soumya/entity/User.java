package com.developer.soumya.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	private String userName;
	private String email;
	private String password;
	private String phoneNumber;

	@JsonProperty(value = "start_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Los_Angeles")
	private Date startTime;

	@JsonProperty(value = "end_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Los_Angeles")
	private Date endTime;

	@JsonProperty(value = "created_date")
	@JsonFormat(pattern = "HH:mm", timezone = "America/Los_Angeles")
	private Date createdDate;

	@JsonProperty(value = "modified_date")
	@JsonFormat(pattern = "HH:mm:ss", timezone = "America/Los_Angeles")
	private Date lastModifiedDate;

}
