import com.yang.domain.User;
import com.yang.service.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: CY.Ma
 * @date: 2023/7/5 21:48
 * @Description:
 * @doc:
 */
public class SpringAroundTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("config");
        UserService userService = ac.getBean("userService", UserService.class);
        User user = new User();
        user.setName("菜菜");
        user.setAge(23);
        user.setGender("女");
        // 测试保存
        userService.save(user);
        System.out.println("------------");
        User byId = userService.findById("1");
        System.out.println("执行了查询操作：" + byId);
        System.out.println("------------");
        userService.update(user);
        System.out.println("------------");
        userService.del("1");
    }
}
