package me.siyoon;

public class SingleMan {
    String name;
    int howLongDays;

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

    @Override
    public String toString() {
        return "SingleMan{" +
                "name='" + name + '\'' +
                ", howLongDays=" + howLongDays +
                '}';
    }
}
