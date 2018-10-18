package soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GameTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("diceplayer.xml");
        Game game = applicationContext.getBean("game", Game.class);
        game.play();
        game.judgeWinnder();
    }
}
