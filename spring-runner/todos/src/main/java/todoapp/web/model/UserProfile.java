package todoapp.web.model;

import todoapp.core.user.domain.User;

import java.util.Objects;

/**
 * 사용자 프로필 모델
 *
 * @author springrunner.kr@gmail.com
 */
public class UserProfile {

    private static final String DEFAULT_PROFILE_PICTURE_URL = "/assets/img/profile-picture.png";

    private User user;

    public UserProfile(User user) {
        this.user = Objects.requireNonNull(user, "user object must be not null");
    }

    public String getName() {
        return user.getUsername();
    }

    public String getProfilePictureUrl() {
        if (user.hasProfilePicture()) {
            throw new UnsupportedOperationException("사용자 프로필 이미지 주소(Url)를 작성하세요.");
        }

        // 프로필 이미지가 없으면 기본 프로필 이미지를 사용한다.
        return DEFAULT_PROFILE_PICTURE_URL;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserProfile{");
        sb.append("name=").append(getName());
        sb.append('}');
        return sb.toString();
    }

}
