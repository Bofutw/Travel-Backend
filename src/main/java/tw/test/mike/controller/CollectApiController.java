package tw.test.mike.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tw.test.mike.bean.BlogBean;
import tw.test.mike.bean.CollectBean;
import tw.test.mike.bean.MemberBean;
import tw.test.mike.service.CollectService;

@RestController
@RequestMapping("/collect")
@CrossOrigin
public class CollectApiController {

    @Autowired
    private CollectService collectService;

    @PutMapping({"/memberid={memberid}&blogid={blogid}"})
    public ResponseEntity<?> create(
        @PathVariable(name = "memberid") Integer memberid,
        @PathVariable(name = "blogid") Integer blogid){
        CollectBean bean = new CollectBean();

        MemberBean memberBean = new MemberBean();
        memberBean.setMemberid(memberid);
        bean.setMember(memberBean);

        BlogBean blogBean = new BlogBean();
        blogBean.setBlogid(blogid);
        bean.setBlog(blogBean);

        bean.setCollectid(65534);

        CollectBean result = collectService.create(bean);
        if(result!=null){
            try{
                return ResponseEntity.ok(result);
            }catch (Exception e){
                System.out.println(e);
            }

        }
        return ResponseEntity.notFound().build();
    }


}
