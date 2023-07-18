import com.yang.domain.User;
import com.yang.service.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: CY.Ma
 * @date: 2023/7/5 14:59
 * @description:
 */
public class SpringAdviceTypeTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("config");
        UserService userService = ac.getBean("userService", UserService.class);
        User user = new User();
        user.setNickname("caicai");
        user.setUsername("蔡雪辰");
        userService.saveUser(user, "123");
//        User byId = userService.findById("1");
    }

}
