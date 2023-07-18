import com.yang.domain.User;
import com.yang.extension.ValidateExtensionService;
import com.yang.service.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: CY.Ma
 * @date: 2023/7/6 16:51
 * @description:
 */
public class SpringDeclareParentsTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("config");
        UserService userService = ac.getBean("userService", UserService.class);
        User user = new User();
        user.setNickname("孙子");
        user.setUsername("蔡雪辰");

        userService.saveUser(user);

//        // 验证用户名称是否合法
//        // 类型强转
//        ValidateExtensionService validateExtensionService = (ValidateExtensionService) userService;
//        if (validateExtensionService.checkUser(user)) {
//            userService.saveUser(user);
//        } else {
//            System.out.println("nickName校验失败");
//        }

    }
}
