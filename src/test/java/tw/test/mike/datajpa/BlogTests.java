package tw.test.mike.datajpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tw.test.mike.bean.MemberBean;
import tw.test.mike.dao.BlogRepository;
import tw.test.mike.service.BlogService;

@SpringBootTest
public class BlogTests {
    @Autowired
    BlogService blogService;

    @Autowired
    BlogRepository blogRepository;

    @Test
    public void testselectAll(){
        System.out.println(blogService.selectAll());
    }

    @Test
    public void testselectAllbyauthority(){
        System.out.println(blogService.selectAllbyauthority(0));
    }

    @Test
    public void testselectAllbyauthorityandmemberid(){
        MemberBean memberBean = new MemberBean();
        memberBean.setMemberid(1);
        System.out.println(blogService.selectAllbymemberidandauthority(memberBean));
    }

    @Test
    public void testselectAllBypopular(){
        System.out.println(blogService.selectAllOrderBypopular());
    }

    @Test
    public void testfindAllByOrderByBlogpopularDesc(){
        System.out.println(blogRepository.findAllByOrderByBlogpopularDesc());
    }

    @Test
    public void testfindTopByOrderByBlogpopularDesc(){
        System.out.println(blogRepository.findTop9ByOrderByBlogpopularDesc());
    }

    @Test
    public void testfindTop5ByOrderByBlogcreatetimeAsc(){
        System.out.println(blogRepository.findTop5ByOrderByBlogcreatetimeDesc());
    }

}