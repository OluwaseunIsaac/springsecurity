package org.karlearnder.security.webcontroller;

import org.karlearnder.security.service.UserService;
import org.karlearnder.security.webcontroller.dto.UserWebRegistrationDto;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


//controller annotation means its a spring mvc controller and its able to handle http request
@Controller
@RequestMapping("/registration")
public class UserWebRegistrationController {
	
	private UserService userService;

	public UserWebRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	
	@ModelAttribute("user")
	public UserWebRegistrationDto userRegistrationDto() {
		return new UserWebRegistrationDto();
	}
	
	
	@GetMapping
	public String showRegistrationPage() {
		return "registration";
	}
	
	
	//This is an alternative approach to the two codes above
//	@GetMapping
//	public String showRegistrationPage(Model model) {
//		model.addAttribute("user", new UserWebRegistrationDto());
//		return "registration";
//	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserWebRegistrationDto registrationDto) {
		
		userService.save(registrationDto);
		return "redirect:/registration?success";
	}
	
}
