package todoapp.web.user;

import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import todoapp.security.UserSession;
import todoapp.web.model.UserProfile;

@RestController
public class UserRestController {

	@GetMapping("/api/user/profile")
	public ResponseEntity<UserProfile> userProfile(UserSession session) {
		if(Objects.isNull(session)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		
		return ResponseEntity.ok(new UserProfile(session.getUser()));
	}
}
