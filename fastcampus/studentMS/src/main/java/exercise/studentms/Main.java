package exercise.studentms;

import exercise.studentms.config.StudentMS;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("studentMS.xml");
//        MainController mc = ctx.getBean("mainController", MainController.class);
//        mc.control();

        ApplicationContext ctx2 = new AnnotationConfigApplicationContext(StudentMS.class);
        MainController mc2 = ctx2.getBean("mainController", MainController.class);
        mc2.control();
    }
}

