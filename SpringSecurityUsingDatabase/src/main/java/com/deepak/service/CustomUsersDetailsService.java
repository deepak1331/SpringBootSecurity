package com.deepak.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.deepak.model.CustomUserDetails;
import com.deepak.model.Users;
import com.deepak.repository.UsersRepository;

@Service
public class CustomUsersDetailsService implements UserDetailsService {

	@Autowired
	private UsersRepository usersRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Users> optionalUser = usersRepository.findByUsername(username);
		// throw excption if value isn't present
		optionalUser.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
		//return the CustomuserDetails object if not null
		return optionalUser.map(CustomUserDetails::new).get();
	}
}
