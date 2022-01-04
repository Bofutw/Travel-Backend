package tw.test.mike.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.test.mike.bean.MemberBean;



public interface MemberRepository extends 
					JpaRepository<MemberBean, Integer>{

}
