package lt.CodeAcademy.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import lt.CodeAcademy.model.User;
import lt.CodeAcademy.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
