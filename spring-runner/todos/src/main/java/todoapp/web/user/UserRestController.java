package todoapp.web.user;

import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import todoapp.security.UserSession;
import todoapp.security.UserSessionRepository;
import todoapp.web.model.UserProfile;

@RestController
public class UserRestController {
	private final UserSessionRepository sessionRepository;
	
	public UserRestController(UserSessionRepository sessionRespository) {
		this.sessionRepository = sessionRespository;
	}

	@GetMapping("/api/user/profile")
	public ResponseEntity<UserProfile> userProfile() {
		UserSession session = sessionRepository.get();
		if(Objects.isNull(session)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		
		return ResponseEntity.ok(new UserProfile(session.getUser()));
	}
}
