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
	@GeneratedValue(
			strategy = GenerationType.IDENTITY
	)
	@Column(name = "blogid")
	private Integer blogid;


	@Column(name = "blogdetail")
	private String blogdetail;

	@Column(name = "blogauthority")
	private Integer blogauthority;


	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	@JoinColumn(
			name = "blogmemberid",
			referencedColumnName = "memberid"
	)
	private MemberBean member;


	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	@JoinColumn(
			name = "blogjourneyid",
			referencedColumnName = "journeyid"
	)
	private JourneyBean journey;

	public MemberBean getMember() {
		return member;
	}

	public void setMember(MemberBean member) {
		this.member = member;
	}

	public JourneyBean getJourney() {
		return journey;
	}

	public void setJourney(JourneyBean journey) {
		this.journey = journey;
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
		return "BlogBean{" +
				"blogid=" + blogid +
				", blogdetail='" + blogdetail + '\'' +
				", blogauthority=" + blogauthority +
				'}';
	}


}
