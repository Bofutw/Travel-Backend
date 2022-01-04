package tw.test.mike.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.test.mike.bean.BlogBean;

public interface BlogRepository extends 
			JpaRepository<BlogBean, Integer>{
	
	public List<BlogBean> findByBlogdetailLike(String name);
	//實現除了基本crud以外的資料庫互動
}
