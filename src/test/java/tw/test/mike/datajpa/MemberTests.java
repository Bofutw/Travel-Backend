package tw.test.mike.datajpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tw.test.mike.bean.MemberBean;
import tw.test.mike.dao.CityRepository;
import tw.test.mike.dao.MemberRepository;
import tw.test.mike.service.MemberService;
import tw.test.mike.tools.Tools;

import javax.tools.Tool;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@SpringBootTest
public class MemberTests {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private CityRepository cityRepository;

    @Test
    public void testSelects(){

        System.out.println(memberService.selectAll());
    }

    @Test
    public void testSelectsbyId(){
//        MemberBean bean = new MemberBean();
//        bean.setMemberid(2);
//    	System.out.println(12);
        System.out.println(memberService.selectbyEmail("Robin@gmail.com"));
    }

    @Test
    public void testSelectbyGender(){
        System.out.println(memberService.selectbyGender(0));
    }

    @Test
    public void testSelectJourney(){

        System.out.println(memberService.selectJourney(1));
    }

    @Test
    public void testfind(){
        System.out.println(memberRepository.findAll());
    }

    @Test
    public void testcountAll(){
        System.out.println(memberRepository.countAllBy());
    }

    @Test
    public void testcountByMembergender(){
        System.out.println(memberRepository.countByMembergender(0));
    }

    @Test
    public void testLab(){
        MemberBean memberBean = new MemberBean();
        MemberBean result;
        memberBean.setMemberid(1);
        result = memberService.selectbyId(memberBean);
        Date birthtime = result.getMemberbirth();
        System.out.println(birthtime);

        Calendar membercalendar = Calendar.getInstance();
        membercalendar.setTime(birthtime);
        Integer memberbirthyear = membercalendar.get(Calendar.YEAR);

        Calendar nowcalendar = Calendar.getInstance();
        nowcalendar.setTime(new Date());
        Integer year = nowcalendar.get(Calendar.YEAR);

        System.out.println(year-memberbirthyear);
    }
@Test
    public void testcreate(){


        for(int i=1; i<=22;i++){

            MemberBean memberBean = new MemberBean();
            memberBean.setMemberid(65534);
            memberBean.setMembername("bofu"+i);
            memberBean.setCity(cityRepository.findById(i).get());
            memberBean.setMemberemail(memberBean.getMembername()+"@gmail.com");
            memberBean.setMembergender(i%2);
            memberBean.setMembericon("https://test/"+i);

            memberService.create(memberBean);
        }
    }

}