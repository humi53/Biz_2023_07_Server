package com.callor.books.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.books.model.UserDto;
import com.callor.books.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	protected final UserService userService;
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String home(
			@ModelAttribute("USER")
			UserDto userDto , Model model) {
		List<UserDto> userList = userService.selectAll();
		model.addAttribute("USER_LIST", userList);
		return "user/input_user";
	}
	
	@RequestMapping(value = "/input", method=RequestMethod.POST)
	public String input(
			@ModelAttribute("USER")
			UserDto userDto
			) {
		try {
			int result = userService.insert(userDto);
		} catch (Exception e) {
			return "redirect:/user?ERROR=" + e.getMessage();
		}
		return "redirect:/user";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(
			String l_ucode,
			@ModelAttribute("USER")
			UserDto userDto,
			Model model
			) {
		userDto = userService.findByUcode(l_ucode);
		model.addAttribute("USER", userDto);
		return "user/update_user";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(
			@ModelAttribute("USER")
			UserDto userDto) {
		int result = userService.update(userDto);
		return "redirect:/user";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(
			String u_code,
			@ModelAttribute("USER")
			UserDto userDto) {
		userDto = userService.findByUcode(u_code);
		userDto.setU_stop("N");
		int result = userService.update(userDto);
		return "redirect:/user";
	}
	
	
	
	@ModelAttribute("USER")
	public UserDto userDto() {
		return new UserDto();
	}
}
