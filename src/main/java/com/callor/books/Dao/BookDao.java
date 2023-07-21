package com.callor.books.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.callor.books.model.BookDto;

public interface BookDao {

	public List<BookDto> selectAll();

	public int insert(BookDto bookDto);

	public BookDto findByBcode(String b_code);
	
	public List<BookDto> selectBnameBauther(@Param("b_name") String b_name, @Param("b_auther") String b_auther);

	public int update(BookDto bookDto);
	
	// 도서코드 중복 체크
	public int bcodeCount(String b_code);
	
	public int bnameCount(String b_name);

}
