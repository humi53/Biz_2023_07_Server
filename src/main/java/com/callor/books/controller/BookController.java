package com.callor.books.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.books.model.BookDto;
import com.callor.books.service.BookService;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
@RequestMapping(value = "/book")
public class BookController {
	
	protected final BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String home(
			@ModelAttribute("BOOK")
			BookDto bookDto , Model model) {
		List<BookDto> bookList = bookService.selectAll();
		model.addAttribute("BOOK_LIST", bookList);
		return "book/input_book";
	}
	
	@RequestMapping(value = "/input", method = RequestMethod.POST)
	public String input(
			@ModelAttribute("BOOK")
			BookDto bookDto) {
		try {
			int result = bookService.insert(bookDto);
		} catch (Exception e) {
			return "redirect:/book?ERROR=" + e.getMessage();
		}
		return "redirect:/book";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(
			String l_bcode,
			@ModelAttribute("BOOK")
			BookDto bookDto,
			Model model) {
		bookDto = bookService.findByBcode(l_bcode);
		model.addAttribute("BOOK", bookDto);
		return "book/update_book";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(
			@ModelAttribute("BOOK")
			BookDto bookDto) {
		int result = bookService.update(bookDto);
		return "redirect:/book";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(
			String b_code,
			@ModelAttribute("BOOK")
			BookDto bookDto) {
		bookDto = bookService.findByBcode(b_code);
		bookDto.setB_stop("N");
		int result = bookService.update(bookDto);
		return "redirect:/book";
		
	}
	
	@ModelAttribute("BOOK")
	public BookDto bookDto() {
		return new BookDto();
	}
}
