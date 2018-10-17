package examples.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringExam01 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        MyBean myBean1 = (MyBean) applicationContext.getBean("myBean");
        myBean1.print();
        MyBean myBean2 = applicationContext.getBean(MyBean.class);
        myBean2.print();

        if (myBean1 == myBean2) {
            //두 참조변수가 같은 객체를 참조한다면
            System.out.println("myBean1 == myBean2");
        }

    }
}
