package examples.boot.springboard.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("application.properties")
public class WebConfig {
    @Value("${ip}")
    String ip;
    @Value("${port}")
    int port;

    @Bean
    public ServerInfo serverInfo() {
        ServerInfo serverInfo = new ServerInfo();
//        serverInfo.setIp("127.0.0.1");
        serverInfo.setIp(ip);
        serverInfo.setPort(port);
        return serverInfo;
    }
}
