package tw.test.mike.datajpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tw.test.mike.bean.MemberBean;
import tw.test.mike.service.MemberService;

@SpringBootTest
public class MemberTests {

    @Autowired
    private MemberService memberService;

   // @Test
    public void testSelects(){

        System.out.println(memberService.selectAll());
    }

    @Test
    public void testSelectsbyId(){
        MemberBean bean = new MemberBean();
        bean.setMemberid(2);

        System.out.println(memberService.selectbyId(bean).getCity());
    }

    @Test
    public void testSelectbyGender(){
        System.out.println(memberService.selectbyGender(0));
    }

    @Test
    public void testSelectJourney(){

        System.out.println(memberService.selectJourney(1));
    }

}