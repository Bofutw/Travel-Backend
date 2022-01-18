package tw.test.mike.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.test.mike.bean.BlogBean;
import tw.test.mike.bean.CollectBean;
import tw.test.mike.bean.JourneyBean;
import tw.test.mike.bean.MemberBean;
import tw.test.mike.dao.CollectRepository;
import tw.test.mike.dao.MemberRepository;

@Service
@Transactional
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;

	public CollectRepository collectRepository;

	public List<MemberBean> selectAll(){
		return memberRepository.findAll();
	}

	public MemberBean selectbyId(MemberBean memberBean) {
		MemberBean result = null;
		Optional<MemberBean> optional =memberRepository.findById(memberBean.getMemberid());

		if(optional.isPresent()) {
			result = optional.get();

			return result;
		}
		return result;
	}
	public MemberBean selectbyEmail(String email) {
		MemberBean result = null;
		result = memberRepository.findBymemberemail(email);

		return result;
	}

	public List<MemberBean> selectbyGender(Integer gender){

		List<MemberBean> result = memberRepository.findBymembergender(gender);

		return result;
	}

	public List<JourneyBean> selectJourney(Integer memberid){
		MemberBean memberBean = new MemberBean();
		memberBean.setMemberid(memberid);
		List<JourneyBean> result = null;
		if(memberBean!=null){
			result = selectbyId(memberBean).getJourney();
			return result;
		}
		return result;

	}


	public  List<BlogBean> selectBlog(Integer memberid){
		MemberBean memberBean = new MemberBean();
		memberBean.setMemberid(memberid);
		List<BlogBean> result = null;
		if(memberBean!=null){
			result = selectbyId(memberBean).getBlog();
			return result;
		}
		return result;
	}

	public List<CollectBean> selectCollect(Integer meberid){
		MemberBean memberBean = new MemberBean();
		memberBean.setMemberid(meberid);
		List<CollectBean> result = null;

		if(memberBean!=null){
			result = selectbyId(memberBean).getCollect();
		}
		return result;
	}


	public boolean delete(MemberBean memberBean) {
		Optional<MemberBean> optional =memberRepository.findById(memberBean.getMemberid());
		if(optional.isPresent()) {
			memberRepository.delete(memberBean);
			return true;
		}
		return false;
	}
	public MemberBean update(MemberBean memberBean) {
		Optional<MemberBean> optional =memberRepository.findById(memberBean.getMemberid());
		if(optional.isPresent()) {
			return memberRepository.save(memberBean);
		}
		return null;
	}
	public MemberBean create(MemberBean memberBean) {
		Optional<MemberBean> optional = memberRepository.findById(memberBean.getMemberid());
		if(!optional.isPresent()){
			Date date = new Date();
			memberBean.setMemberregistertime(date);

			return memberRepository.save(memberBean);
		}
		return null;
	}
}
