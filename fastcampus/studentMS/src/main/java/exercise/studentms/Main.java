package exercise.studentms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("studentMS.xml");
        MainController mc = ctx.getBean("mainController", MainController.class);
        mc.control();
    }
}

