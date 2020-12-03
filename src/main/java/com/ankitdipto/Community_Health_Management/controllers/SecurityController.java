package com.ankitdipto.Community_Health_Management.controllers;

import com.ankitdipto.Community_Health_Management.USER.MyUser;
import com.ankitdipto.Community_Health_Management.USER.UserDTO;
import com.ankitdipto.Community_Health_Management.USER.UserDetailsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class SecurityController 
{
	@Autowired
	UserDetailsServiceImpl userService;

	@GetMapping("/sign-up")
    public String signUp( Model model) 
    {
        UserDTO userDto = new UserDTO();
        model.addAttribute("user", userDto);
        return "register";
    }    

    @GetMapping("/sign-in")
	String signIn() {

		return "login";
	}

	/*@GetMapping("/sign-up")
	String signUp() {

		return "register";
	}*/

	@PostMapping("/sign-up")
	String signUp(@ModelAttribute("user") UserDTO userDto) 
	{
		if(userDto==null)
		{
			System.out.println("user is null");
			return "redirect:/";
		}
		userService.signUpUser(userDto);
		return "redirect:/login";
	}
}
