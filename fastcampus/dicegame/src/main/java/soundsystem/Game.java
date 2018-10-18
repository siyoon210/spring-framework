package soundsystem;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> playerList;

    public Game() {
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public void play() {
        for (Player p : playerList) {
            System.out.println(p.getName()+" 플레이어 주사위의 눈은 : "+p.play());
        }
    }

    public void judgeWinnder() {
        int highestNum = 0;
        List<String> winner = new ArrayList<>();
        for (Player p : playerList) {
            if (p.getNumber() > highestNum) {
                highestNum = p.getNumber();
                winner.clear();
                winner.add(p.getName());
            } else if (p.getNumber() == highestNum) {
                winner.add(p.getName());
            }
        }

        if (winner.size() > 1) {
            System.out.println("공동 우승");
        }
        for (String str : winner) {
            System.out.println("이긴사람 : " + str);
        }
    }
}
