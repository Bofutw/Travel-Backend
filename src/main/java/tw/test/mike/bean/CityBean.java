package tw.test.mike.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class CityBean {
	@Id
	@Column(name = "cityid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cityid;
	@Column(name = "cityname")
	private String cityname;

	@ManyToOne(cascade = CascadeType.ALL,
			fetch = FetchType.EAGER) //避免lazy與collection衝突
	@JoinColumn(name = "cityareaid",//對照原先table內欄位
	referencedColumnName = "areaid")//對照參照對象欄位
	private AreaBean area;

	@Override public String toString() {
		return "CityBean [cityid=" + cityid + ", cityname=" + cityname + "]";
	}

	public Integer getCityid() {
		return cityid;
	}

	public void setCityid(Integer cityid) {
		this.cityid = cityid;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public AreaBean getArea() {
		return area;
	}

	public void setArea(AreaBean area) {
		this.area = area;
	}


}
