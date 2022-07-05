package org.karlearnder.security.service;

import org.karlearnder.security.model.User;
import org.karlearnder.security.webcontroller.dto.UserWebRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {
	
	User save(UserWebRegistrationDto webRegistrationDto);

}
