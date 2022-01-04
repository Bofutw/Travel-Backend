package tw.test.mike.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;




@Entity
@Table(name = "area")
public class AreaBean {
	@Id
	@Column(name = "areaid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer areaid;
	@Column(name = "areaname")
	private String areaname;

	@OneToMany(mappedBy = "area")
	private List<CityBean> city;
	@Override
	public String toString() {
		return "AreaBean [areaname=" + areaname + "]";
	}
	
}
