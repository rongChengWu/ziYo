package com.wrc.ziyo.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_SUPPLIERS")
public class Suppliers implements Serializable {

	@Id
	@Column(name = "TS_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Suppliers_seq")
	@SequenceGenerator(name = "Suppliers_seq", allocationSize = 1, initialValue = 1, sequenceName = "Suppliers_seq")
	private Integer id;

	@Column(name = "GYSBH")
	private String gysbh;

	@Column(name = "GYSMC")
	private String gysmc;

	@Column(name = "DZ")
	private String dz;

	@Column(name = "LXR")
	private String lxr;

	@Column(name = "LXDH")
	private String lxdh;

	@Column(name = "SX")
	private String sx;

	@Column(name = "BZ")
	private String bz;

	@Column(name = "USERID")
	private Integer userid;

	@OneToOne
	@JoinColumn(name = "USERID", insertable = false, updatable = false)
	private Users users;

	@Column(name = "LAST_TIME")
	private Date lastTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGysbh() {
		return gysbh;
	}

	public void setGysbh(String gysbh) {
		this.gysbh = gysbh;
	}

	public String getGysmc() {
		return gysmc;
	}

	public void setGysmc(String gysmc) {
		this.gysmc = gysmc;
	}

	public String getDz() {
		return dz;
	}

	public void setDz(String dz) {
		this.dz = dz;
	}

	public String getLxr() {
		return lxr;
	}

	public void setLxr(String lxr) {
		this.lxr = lxr;
	}

	public String getLxdh() {
		return lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	public String getSx() {
		return sx;
	}

	public void setSx(String sx) {
		this.sx = sx;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Date getLastTime() {
		return lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

}
