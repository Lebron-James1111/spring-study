import com.yang.domain.User;
import com.yang.service.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: CY.Ma
 * @date: 2023/7/4 14:02
 * @description:
 */
public class SpringAopTest {

    @Test
    public void test() throws Exception{
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("config");
        UserService userService = ac.getBean("userService", UserService.class);
        User user = new User();
        user.setNickname("caicai");
        user.setUsername("蔡雪辰");
        userService.saveUser(user);
    }

    @Test
    public void test02() {
        String s1 = "test";
        String s2 = "test";
        System.out.println(s1 == s2);
    }

    @Test
    public void test03() {
        String s1 = new String("test");
        String s2 = new String("test");

        String s3 = s1.intern();
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s2 == s3);
    }

    @Test
    public void test04() {
        String s1 = new String("te") + new String("st");
        String s2 = s1.intern();

        System.out.println(s1 == s2);// false


        String s4 = new String("he") + new String("llo");
        String s5 = s4.intern();
        System.out.println(s4 == s5); // true

    }


    public static void main(String[] args) {
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2); // false

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4); // false

//        String s = new String("1");
//        String s2 = "1";
//        s.intern();
//        System.out.println(s == s2);
//
//        String s3 = new String("1") + new String("1");
//        String s4 = "11";
//        s3.intern();
//        System.out.println(s3 == s4);



    }


}
