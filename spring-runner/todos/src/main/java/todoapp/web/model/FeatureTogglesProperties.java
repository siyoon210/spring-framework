package todoapp.web.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 기능 토글 모델
 *
 * @author springrunner.kr@gmail.com
 */
@Component
@ConfigurationProperties("site.feat")
public class FeatureTogglesProperties {

    private boolean auth = false;
    private boolean onlineUsersCounter = false;

    public boolean isAuth() {
        return auth;
    }

    public void setAuth(boolean auth) {
        this.auth = auth;
    }

    public boolean isOnlineUsersCounter() {
        return onlineUsersCounter;
    }

    public void setOnlineUsersCounter(boolean onlineUsersCounter) {
        this.onlineUsersCounter = onlineUsersCounter;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FeatureTogglesProperties{");
        sb.append("auth=").append(auth);
        sb.append(", onlineUsersCounter=").append(onlineUsersCounter);
        sb.append('}');
        return sb.toString();
    }

}
