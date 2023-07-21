package com.callor.books.Dao;

import java.util.List;

import com.callor.books.model.BookDto;
import com.callor.books.model.UserDto;

public interface UserDao {

	// 전체조회
	public List<UserDto> selectAll();
	// 등록
	public int insert(UserDto userDto);
	// 삭제인척
	// 이름, 전화번호로 검색


	public UserDto findByUcode(String u_code);

	public int update(UserDto userDto);
	
	public List<UserDto> findByUnameUtel(String u_name, String u_tel);
	
	

}
