package com.callor.books.service;

import java.util.List;

import com.callor.books.model.BookDto;

public interface BookService {

	int insert(BookDto bookDto) throws Exception;

	List<BookDto> selectAll();

	BookDto findByBcode(String b_code);

	int update(BookDto bookDto);

}
