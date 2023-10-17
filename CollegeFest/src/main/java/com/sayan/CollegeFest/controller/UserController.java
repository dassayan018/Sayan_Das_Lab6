package com.sayan.CollegeFest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sayan.CollegeFest.dto.UserRegistrationDto;
import com.sayan.CollegeFest.entity.User;
import com.sayan.CollegeFest.service.UserService;

@Controller
@RequestMapping("/registration")
public class UserController {
	@Autowired
	UserService userService;
	@GetMapping
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		return"registration";
	}
	@PostMapping
	public String registerUser(@ModelAttribute("user") UserRegistrationDto registrationDto) {
		userService.save(registrationDto);
		return "redirect:/registration?success";
	}
}
