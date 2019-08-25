package todoapp.web.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import todoapp.core.user.application.UserPasswordVerifier;

@Controller
public class UserController {
	private final Logger log = LoggerFactory.getLogger(UserController.class);
	
	private final UserPasswordVerifier verifier;
	
	public UserController(UserPasswordVerifier verifier) {
		this.verifier = verifier;
	}

	@GetMapping("/login")
	public void loginForm() {
		
	}
	
	@PostMapping("/login")
	public String loginProcess(LoginCommand command) {
		log.info("username: {}, password: {}", command.getUsername(), command.getPassword());
		return "login";
	}
	
	public static class LoginCommand{
		private String username;
		private String password;
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
	}
}
