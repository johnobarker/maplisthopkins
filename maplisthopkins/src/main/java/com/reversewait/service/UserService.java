package com.reversewait.service;

import java.util.List;

import com.reversewait.domain.User;
import com.reversewait.domain.UserSite;

public interface UserService {
	
	User createUser(User user);
	
	User findByUserName(String userName);
	
	User findByEmailAddress(String emailAddress);
	
	User findOne(String primaryKey);
	
	User updateUser(User user);
	
	Boolean deleteUser(User user);
	
	List<User> getAllUsers();
	
	User getUserInfo(String userName);
	
	List<UserSite> getUserSites(String primaryKey);
	
}
