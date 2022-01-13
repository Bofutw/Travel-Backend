package tw.test.mike.datajpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tw.test.mike.bean.MemberBean;
import tw.test.mike.service.CityService;
import tw.test.mike.service.MemberService;

@SpringBootTest
public class CityTests {

    @Autowired
    private CityService cityService;

    @Autowired
    private MemberService memberService;

    @Test
    public void testselectbyid(){
        MemberBean temp = new MemberBean();
        MemberBean memberBean;
        temp.setMemberid(1);
        memberBean = memberService.selectbyId(temp);

        System.out.println(cityService.selectbyid(memberBean.getCity()));

    }
}
