package me.siyoon;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("singleman")
public class SingleManProperties {
    private String name;
    private int howLongDays;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getHowLongDays() {
        return howLongDays;
    }

    public void setHowLongDays(final int howLongDays) {
        this.howLongDays = howLongDays;
    }
}

