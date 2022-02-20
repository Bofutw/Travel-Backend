package tw.test.mike.datajpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tw.test.mike.bean.MemberBean;
import tw.test.mike.service.MemberService;
import tw.test.mike.tools.Tools;


@SpringBootTest
public class TestLab {

    @Autowired
    private MemberService memberService;

    @Test
    public void testage(){
        MemberBean bean = new MemberBean();
        bean.setMemberid(1);
        bean = memberService.selectbyId(bean);
        Integer age = Tools.age(bean);

        System.out.println(Tools.agerange(age).get("range"));
    }

    @Test
    public void testagerange(){
        System.out.println("-1 : "+Tools.agerange(-1));
        System.out.println("0 : "+Tools.agerange(0));
        System.out.println("1 : "+Tools.agerange(1));

        System.out.println("14 : "+Tools.agerange(14));
        System.out.println("15 : "+Tools.agerange(15));
        System.out.println("16 : "+Tools.agerange(16));

        System.out.println("24 : "+Tools.agerange(24));
        System.out.println("25 : "+Tools.agerange(25));
        System.out.println("26 : "+Tools.agerange(26));

        System.out.println("33 : "+Tools.agerange(33));
        System.out.println("34 : "+Tools.agerange(34));
        System.out.println("35 : "+Tools.agerange(35));

        System.out.println("43 : "+Tools.agerange(43));
        System.out.println("44 : "+Tools.agerange(44));
        System.out.println("45 : "+Tools.agerange(45));

        System.out.println("53 : "+Tools.agerange(53));
        System.out.println("54 : "+Tools.agerange(54));
        System.out.println("55 : "+Tools.agerange(55));

        System.out.println("63 : "+Tools.agerange(63));
        System.out.println("64 : "+Tools.agerange(64));
        System.out.println("65 : "+Tools.agerange(65));
    }

    @Test
    public void testrandomBirthday(){
        System.out.println(Tools.randomBirthday());
    }

    @Test
    public void testrandomYear(){
        for(int i=0;i<10;i++){
//            System.out.println(Tools.randomYear());
//            System.out.println(Tools.randomBetween(1,30));
            System.out.println((int)(Math.random()*2));
        }

    }
}
