package tw.test.mike.bean;

import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "blog")
public class BlogBean {
	@Id
	@Column(name = "blogid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto increment
	private Integer blogid;
	@Column(name = "blogdetail",columnDefinition = "json")
	private String blogdetail;
	@Column(name = "blogauthority")
	private Integer blogauthority;
	
	
	@ManyToOne(cascade = CascadeType.ALL,
			fetch = FetchType.EAGER)
	@JoinColumn(
			name = "blogjourneyid",//對照原先table內欄位
			referencedColumnName = "journeyid"	//對照參照對象欄位		
			)

	private JourneyBean journey;

	
	@ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="blogmemberid",
	referencedColumnName = "memberid"
	)

	@JsonBackReference
	private MemberBean member;
	
	

	public JourneyBean getJourney() {
		return journey;
	}
	public void setJourney(JourneyBean journey) {
		this.journey = journey;
	}
	public MemberBean getMember() {
		return member;
	}
	public void setMember(MemberBean member) {
		this.member = member;
	}
	public Integer getBlogid() {
		return blogid;
	}
	public void setBlogid(Integer blogid) {
		this.blogid = blogid;
	}

	public String getBlogdetail() {
		return blogdetail;
	}
	public void setBlogdetail(String blogdetail) {
		this.blogdetail = blogdetail;
	}
	public Integer getBlogauthority() {
		return blogauthority;
	}
	public void setBlogauthority(Integer blogauthority) {
		this.blogauthority = blogauthority;
	}

	@Override
	public String toString() {
		return "BlogBean [blogid=" + blogid + ", blogdetail=" + blogdetail + ", blogauthority=" + blogauthority + "]";
	}

	
	

}
