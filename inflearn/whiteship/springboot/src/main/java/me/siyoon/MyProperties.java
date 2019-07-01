package me.siyoon;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("siyoon")
public class MyProperties {
    private String name;
    private int level;
    private String job;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(final int level) {
        this.level = level;
    }

    public String getJob() {
        return job;
    }

    public void setJob(final String job) {
        this.job = job;
    }
}
