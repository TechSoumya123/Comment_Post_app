package com.developer.soumya.service;

import com.developer.soumya.dto.BaseResponse;
import com.developer.soumya.dto.UserRequestDto;

public interface UserService {
	BaseResponse<?> saveUser(UserRequestDto userRequestDto);
}
