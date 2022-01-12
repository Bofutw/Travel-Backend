package tw.test.mike.datajpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tw.test.mike.bean.JourneyBean;
import tw.test.mike.bean.MemberBean;
import tw.test.mike.service.JourneyService;

@SpringBootTest
public class JourneyTests {
    @Autowired
    private JourneyService journeyService;


   // @Test
    public void testSelects(){
        System.out.println(journeyService.selectAll());
    }

   // @Test
    public void testSelectsbyId(){
        JourneyBean journeyBean = new JourneyBean();
        journeyBean.setJourneyid(1);

        System.out.println(journeyService.selectbyId(journeyBean));
    }

   // @Test
    public void testSelectBlog(){
        JourneyBean journeyBean = new JourneyBean();
        journeyBean.setJourneyid(1);

        System.out.println(journeyService.selectBlog(journeyBean));
    }
    @Test
    public void testpost(){
        JourneyBean journeyBean = new JourneyBean();
        journeyBean.setJourneyid(1);
        MemberBean member =new MemberBean();
        
        journeyService.create(journeyBean);
        System.out.println(journeyService.selectBlog(journeyBean));
    }

}
