package todoapp.web.user;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import todoapp.core.user.application.UserJoinder;
import todoapp.core.user.application.UserPasswordVerifier;
import todoapp.core.user.domain.User;
import todoapp.core.user.domain.UserEntityNotFoundException;
import todoapp.core.user.domain.UserPasswordNotMatchedException;
import todoapp.security.UserSession;
import todoapp.security.UserSessionRepository;

@Controller
public class UserController {
	private final Logger log = LoggerFactory.getLogger(UserController.class);
	
	private final UserPasswordVerifier verifier;
	private final UserJoinder joinder;
	private final UserSessionRepository sessionRepository;
	
	public UserController(UserPasswordVerifier verifier, UserJoinder joinder, UserSessionRepository sessionRepository) {
		this.verifier = verifier;
		this.joinder = joinder;
		this.sessionRepository = sessionRepository;
	}

	@GetMapping("/login")
	public void loginForm() {
		
	}
	
	@PostMapping("/login")
	public String loginProcess(@Valid LoginCommand command, BindingResult bindingResult, Model model) {
		log.info("username: {}, password: {}", command.getUsername(), command.getPassword());
		
		User user;
		try {
			//입력한 아이디 비밀번호로 검증 시
			user = verifier.verify(command.getUsername(), command.getPassword());
		} catch (UserPasswordNotMatchedException error) {
			model.addAttribute("message", error.getMessage());
			return "login";
		} catch (UserEntityNotFoundException error) {
			//등록된 사용자가 없으면, 신규 사용자로 가입을 시켜준다.
			user = joinder.join(command.getUsername(), command.getPassword());
		}
		log.info("currenct user: {}", user);
		sessionRepository.set(new UserSession(user));
		
		return "redirect:/todos";
	}
	
	@GetMapping("/logout")
	public View logout() {
		sessionRepository.clear();
		//return "redirect:/todos"; 와 아래는 같은 기
		return new RedirectView("/todos");
	}
	
	@ExceptionHandler(BindException.class)
	public String handlerBindException(BindException error, Model model) {
		model.addAttribute("bindResult", error.getBindingResult());
		model.addAttribute("message", "사용자 입력 값이 올바르지 않습니다.");
		return "login";
	}
	
	public static class LoginCommand{
		@Size(min = 4, max = 20)
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
