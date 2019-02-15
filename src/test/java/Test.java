import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/1/14 17:48
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext bf = new ClassPathXmlApplicationContext("META-INF/test.xml");
        User user = (User)bf.getBean("testbean");
        System.out.println(user.getUserName()+":"+user.getEmail());
    }
}
