package com.developer.soumya.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRequestDto {

	@JsonProperty(value = "first_name")
	private String firstName;

	@JsonProperty(value = "last_name")
	private String lastName;

	@JsonProperty(value = "user_name")
	private String userName;

	@JsonProperty(value = "email")
	private String email;

	@JsonProperty(value = "password")
	private String password;

	@JsonProperty(value = "phone_number")
	private String phoneNumber;

	@JsonProperty(value = "start_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Los_Angeles")
	private Date startTime;

	@JsonProperty(value = "end_time")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/singapore")
	private Date endTime;

	@JsonProperty(value = "creaed_date")
	@JsonFormat(pattern = "HH:mm", timezone = "America/Los_Angeles")
	private Date createdDate;

	@JsonProperty(value = "modified_date")
	@JsonFormat(pattern = "HH:mm:ss", timezone = "Asia/singapore")
	private Date lastModifiedDate;
}
