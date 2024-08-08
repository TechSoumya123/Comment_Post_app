package com.developer.soumya.serviceImpl;

import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.developer.soumya.dto.BaseResponse;
import com.developer.soumya.dto.UserRequestDto;
import com.developer.soumya.entity.User;
import com.developer.soumya.repository.UserRepository;
import com.developer.soumya.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Override
	public BaseResponse<?> saveUser(UserRequestDto userRequestDto) {
		var baseResponse = new BaseResponse<>();
		var validateResult=validateUser(userRequestDto);
		if (Objects.isNull(validateResult)) {
			User user = userRequestDTO_To_User(userRequestDto);
			User saveUser = userRepository.save(user);
			baseResponse.setData(saveUser);
			baseResponse.setCode(String.valueOf(HttpStatus.OK));
			baseResponse.setSuccess(true);
		}else {
			baseResponse.setCode(validateResult.getCode());
			baseResponse.setSuccess(validateResult.isSuccess());
		}
		return baseResponse;
	}

	private BaseResponse<?> validateUser(UserRequestDto userRequestDto) {
		var baseResponse = new BaseResponse<>();
		baseResponse.setSuccess(true);
		User user = userRepository.findByEmail(userRequestDto.getEmail());
		if (!ObjectUtils.isEmpty(user)) {
			baseResponse.setSuccess(false);
			baseResponse.setCode(String.valueOf(HttpStatus.BAD_REQUEST));
			return baseResponse;
		}
		return baseResponse;

	}

	public static User userRequestDTO_To_User(UserRequestDto userRequestDto) {
		User user = new User();
		user.setFirstName(userRequestDto.getFirstName());
		user.setLastName(userRequestDto.getLastName());
		user.setUserName(userRequestDto.getUserName());
		user.setEmail(userRequestDto.getEmail());
		user.setPassword(userRequestDto.getPassword());
		user.setPhoneNumber(userRequestDto.getPhoneNumber());
		user.setEndTime(userRequestDto.getEndTime());
		user.setStartTime(userRequestDto.getStartTime());
		user.setStartTime(userRequestDto.getStartTime());
		user.setCreatedDate(userRequestDto.getCreatedDate());
		user.setLastModifiedDate(userRequestDto.getLastModifiedDate());
		return user;
	}

}
