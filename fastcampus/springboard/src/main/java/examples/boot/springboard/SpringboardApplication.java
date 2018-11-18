package examples.boot.springboard;

import examples.boot.springboard.config.ServerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringboardApplication implements CommandLineRunner {
    @Autowired
    ServerInfo serverInfo;

    public static void main(String[] args) {
        SpringApplication.run(SpringboardApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(serverInfo.getIp());
        System.out.println(serverInfo.getPort());
    }
}
