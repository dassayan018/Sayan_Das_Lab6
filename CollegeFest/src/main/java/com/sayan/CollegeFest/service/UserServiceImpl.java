package com.sayan.CollegeFest.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sayan.CollegeFest.config.CustomeUserDetails;
import com.sayan.CollegeFest.dto.UserRegistrationDto;
import com.sayan.CollegeFest.entity.Role;
import com.sayan.CollegeFest.entity.User;
import com.sayan.CollegeFest.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Override
	public User save(UserRegistrationDto registrationDto) {
		// TODO Auto-generated method stub
		User user = new User(registrationDto.getFirstName(), registrationDto.getLastName(), registrationDto.getEmail(),
				passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ADMIN")));
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub

		User user = userRepository.findByEmail(username);
		if (user == null)
			throw new UsernameNotFoundException("Invalid Username or Passowrd.");
		CustomeUserDetails customeUserDetails = new CustomeUserDetails(user);
		return customeUserDetails;
	}

}
