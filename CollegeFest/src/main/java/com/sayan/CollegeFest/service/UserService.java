package com.sayan.CollegeFest.service;

import com.sayan.CollegeFest.dto.UserRegistrationDto;
import com.sayan.CollegeFest.entity.User;

public interface UserService {
	public User save(UserRegistrationDto registrationDto);


}
