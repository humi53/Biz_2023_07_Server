package com.callor.books.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.books.Dao.UserDao;
import com.callor.books.model.UserDto;
import com.callor.books.service.UserService;

@Service
public class UserServiceImplV1 implements UserService{

	protected final UserDao userDao;
	public UserServiceImplV1(UserDao userDao) {
		this.userDao = userDao;
	}


	@Override
	public int insert(UserDto userDto) throws Exception {
		
		String userName = userDto.getU_name();
		String userTel = userDto.getU_tel();
		
		List<UserDto> userList = 
				userDao.findByUnameUtel(userName, userTel);
		
		if(userList.isEmpty()){
			throw new Exception("ERROR_NAMETEL");
		}
		
		userDto.setU_stop("Y");
		return userDao.insert(userDto);
	}


	@Override
	public List<UserDto> selectAll() {
		return userDao.selectAll();
	}


	@Override
	public UserDto findByUcode(String u_code) {
		return userDao.findByUcode(u_code);
	}


	@Override
	public int update(UserDto userDto) {
		return userDao.update(userDto);
	}

}
