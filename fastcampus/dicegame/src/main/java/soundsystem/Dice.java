package soundsystem;

public class Dice {
    private int face;

    public Dice(int face) {
        this.face = face;
    }

    public int getNumber() {
        return (int)(Math.random() * face) +1;
    }
}
