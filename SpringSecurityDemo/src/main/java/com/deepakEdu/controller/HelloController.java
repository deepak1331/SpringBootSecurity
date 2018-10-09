package com.deepakEdu.controller;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest")
public class HelloController {

	@GetMapping(value = "/hello/{name}")
	public String hello(@PathVariable String name, @AuthenticationPrincipal final UserDetails userDetails) {

		System.out.println("Inside Hello");
		return "Hello dear, " + name;
	}
	
	@GetMapping(value = "bye/{name}")
	public String bye(@PathVariable String name, @AuthenticationPrincipal final UserDetails userDetails) {
		String username = userDetails.getUsername();
		Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
		System.out.println("Hi User : "+username);
		authorities.forEach(System.out::println);
		System.out.println("Inside Bye");
		return "Good Bye " + name;
	}
}
