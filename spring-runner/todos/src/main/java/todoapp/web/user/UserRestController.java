package todoapp.web.user;

import java.net.URI;

import javax.annotation.security.RolesAllowed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import todoapp.core.user.application.ProfilePictureChanger;
import todoapp.core.user.domain.ProfilePicture;
import todoapp.core.user.domain.ProfilePictureStorage;
import todoapp.core.user.domain.User;
import todoapp.security.UserSession;
import todoapp.security.UserSessionRepository;
import todoapp.web.model.UserProfile;

@RestController
public class UserRestController {
	private final Logger log = LoggerFactory.getLogger(UserRestController.class);
	
	private ProfilePictureChanger profilePictureChanger;
	private ProfilePictureStorage profilePictureStorage;
	private UserSessionRepository userSessionRepository;
	
	public UserRestController(ProfilePictureChanger profilePictureChanger,
			ProfilePictureStorage profilePictureStorage, UserSessionRepository userSessionRepository) {
		this.profilePictureChanger = profilePictureChanger;
		this.profilePictureStorage = profilePictureStorage;
		this.userSessionRepository = userSessionRepository;
	}

	@RolesAllowed(UserSession.ROLE_USER)
	@GetMapping("/api/user/profile")
	public UserProfile userProfile(UserSession session) {
		return new UserProfile(session.getUser());
	}
	
	@RolesAllowed(UserSession.ROLE_USER)
	@PostMapping("/api/user/profile-picture")
	public UserProfile updateProfilePicture(MultipartFile profilePicture, UserSession session) {
		log.info("profilePicture '{}'", profilePicture);
	
		URI profilePictrueUri = profilePictureStorage.save(profilePicture.getResource());
		User updatedUser = profilePictureChanger.change(session.getName(), new ProfilePicture(profilePictrueUri));
		
		userSessionRepository.set(new UserSession(updatedUser));
		return new UserProfile(session.getUser());
	}
}
