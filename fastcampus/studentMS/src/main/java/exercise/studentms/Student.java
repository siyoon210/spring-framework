package exercise.studentms;

public class Student {
    private String name;
    private int math;
    private int eng;
    private int lang;

    public Student(String name, int math, int eng, int lang) {
        this.name = name;
        this.math = math;
        this.eng = eng;
        this.lang = lang;
    }

    public String getName() {
        return name;
    }

    public int getMath() {
        return math;
    }

    public int getEng() {
        return eng;
    }

    public int getLang() {
        return lang;
    }
}
