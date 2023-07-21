package com.callor.books.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.books.Dao.BookDao;
import com.callor.books.model.BookDto;
import com.callor.books.service.BookService;

@Service
public class BookServiceImplV1 implements BookService{

	protected final BookDao bookDao;
	public BookServiceImplV1(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public int insert(BookDto bookDto) throws Exception {
		String bookCode = bookDto.getB_code();
		String bookName = bookDto.getB_name();
		
//		if(bookDao.bcodeCount(bookCode) >= 1) {
//			throw new Exception("ERRBCODE");
//		}
//		if(bookDao.bnameCount(bookName) >= 1) {
//			throw new Exception("ERRNAME");
//		}
		bookDto.setB_stop("Y");
		return bookDao.insert(bookDto);
	}
	
	@Override
	public List<BookDto> selectAll() {
		return bookDao.selectAll();
	}

	@Override
	public BookDto findByBcode(String b_code) {
		return bookDao.findByBcode(b_code);
	}

	@Override
	public int update(BookDto bookDto) {
		return bookDao.update(bookDto);
	}
	
}
