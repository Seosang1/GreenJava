package com.project.test.dao;

import java.util.List;

import com.project.test.dto.UserDto;

public interface UserDao {
	
	String NAMESPACE = "test.mapper.testMapper.";
	
	public List<UserDto> selectList();

}
