package tw.test.mike.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.test.mike.bean.MemberBean;

import java.util.List;


public interface MemberRepository
		extends JpaRepository<MemberBean, Integer> {

	public List<MemberBean> findBymembergender(Integer gender);
	public MemberBean findBymemberemail(String email);
}

