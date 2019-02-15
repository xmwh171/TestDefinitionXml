import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/1/14 16:45
 */
public class MyNamespaceHandler extends NamespaceHandlerSupport {

    public void init() {
        registerBeanDefinitionParser("user",new UserBeanDefinitionParser());
    }
}
