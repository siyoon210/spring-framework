package soundsystem;

public class Player {
    private Dice dice;
    private String name;
    private int number;

    public Player() {

    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public int play() {
        this.number = dice.getNumber();
        return number;
    }
}
