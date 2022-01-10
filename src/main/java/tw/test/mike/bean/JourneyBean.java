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

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "journey")
public class JourneyBean {

	@Id
	@Column(name = "journeyid")
	@GeneratedValue(
			strategy = GenerationType.IDENTITY
	)
	private Integer journeyid;

	@Column(name = "journeydetail")
	private String journeydetail;


	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	@JoinColumn(
			name = "journeymemberid",
			referencedColumnName = "memberid"
	)
	private MemberBean member;


	@OneToMany(
			mappedBy = "journey",
			cascade = {CascadeType.ALL},
			fetch = FetchType.EAGER
	)
	@JsonIgnore
	private List<BlogBean> blog;

	public MemberBean getMember() {
		return member;
	}

	public void setMember(MemberBean member) {
		this.member = member;
	}

	public List<BlogBean> getBlog() {
		return blog;
	}

	public void setBlog(List<BlogBean> blog) {
		this.blog = blog;
	}

	public Integer getJourneyid() {
		return journeyid;
	}

	public void setJourneyid(Integer journeyid) {
		this.journeyid = journeyid;
	}

	public String getJourneydetail() {
		return journeydetail;
	}

	public void setJourneydetail(String journeydetail) {
		this.journeydetail = journeydetail;
	}

	@Override
	public String toString() {
		return "JourneyBean{" +
				"journeyid=" + journeyid +
				", journeydetail='" + journeydetail + '\'' +
				'}';
	}
}
