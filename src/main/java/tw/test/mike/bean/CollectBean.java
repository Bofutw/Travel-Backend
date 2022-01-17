package tw.test.mike.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "collect")
public class CollectBean {
	@Id
	@Column(name ="collectid" )
	Integer collectid;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "collectmemberid ",
	referencedColumnName = "memberid ")
	@JsonIgnore
	MemberBean member;

	public Integer getCollectid() {
		return collectid;
	}

	public void setCollectid(Integer collectid) {
		this.collectid = collectid;
	}


	@ManyToOne(fetch = FetchType.LAZY)//EAGER
	@JsonManagedReference
	@JoinColumn(name = "collectblogid ",
			referencedColumnName = "blogid ")
	@JsonIgnore
	BlogBean blog;

	public MemberBean getMember() {
		return member;
	}

	public void setMember(MemberBean member) {
		this.member = member;
	}

	public BlogBean getBlog() {
		return blog;
	}

	public void setBlog(BlogBean blog) {
		this.blog = blog;
	}

	@Override
	public String toString() {
		return "CollectBean{" +
				"collectid=" + collectid +
				'}';
	}
}
