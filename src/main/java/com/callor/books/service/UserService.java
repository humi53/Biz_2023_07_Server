package com.callor.books.service;

import java.util.List;

import com.callor.books.model.UserDto;

public interface UserService {

	int insert(UserDto userDto) throws Exception;

	List<UserDto> selectAll();

	UserDto findByUcode(String u_code);

	int update(UserDto userDto);

}
