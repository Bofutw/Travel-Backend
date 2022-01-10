package tw.test.mike.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.test.mike.bean.BlogBean;
import tw.test.mike.bean.MemberBean;
import tw.test.mike.dao.BlogRepository;

@Service
@Transactional
public class BlogService {
	@Autowired
	private BlogRepository blogRepository;

	public List<BlogBean> selectAll(){
		return blogRepository.findAll();
	}

	public List<BlogBean> selectAllbyauthority(){
		List<BlogBean> result = null;

		return result = blogRepository.findByblogauthority(1);
	}

	public List<BlogBean> selectAllbymemberidandauthority(MemberBean memberBean, Integer authority){
		List<BlogBean> result = null;

		result = blogRepository.findByMemberAndBlogauthority(memberBean, authority);

		return result;
	}
	
	public List<BlogBean> selectByKeyword(String keyword) {
		return blogRepository.findByBlogdetailLike("%"+keyword+"%");

	}

	public boolean delete(BlogBean blogBean) {
		Optional<BlogBean> optional =blogRepository.findById(blogBean.getBlogid());
		if(optional.isPresent()) {
			blogRepository.delete(blogBean);
			return true;
		}
		return false;
	}
	public BlogBean update(BlogBean blogBean) {
		Optional<BlogBean> optional =blogRepository.findById(blogBean.getBlogid());
		if(optional.isPresent()) {
			return blogRepository.save(blogBean);
		}
		return null;
	}
	public BlogBean create(BlogBean blogBean) {
		Optional<BlogBean> optional =blogRepository.findById(blogBean.getBlogid());
		if(!optional.isPresent()) {
			return blogRepository.save(blogBean);
		}
		return null;
	}
}
