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
@Table(name = "T_CUSTOMER")
public class Customer implements Serializable {

	@Id
	@Column(name = "TC_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMER_SEQ")
	@SequenceGenerator(name = "CUSTOMER_SEQ", allocationSize = 1, initialValue = 1, sequenceName = "CUSTOMER_SEQ")
	private Integer id;

	@Column(name = "KHBH")
	private String khbh;

	@Column(name = "KHMC")
	private String khmc;

	@Column(name = "JC")
	private String jc;

	@Column(name = "DZ")
	private String dz;

	@Column(name = "LXR")
	private String lxr;

	@Column(name = "LXDH")
	private String lxrdh;

	@Column(name = "QY")
	private String qy;

	@Column(name = "YWY")
	private String ywy;

	@Column(name = "FHFS")
	private String fhfs;

	@Column(name = "bz")
	private String bz;

	@Column(name = "HKFS")
	private String hkfs;

	@Column(name = "USER_ID")
	private Integer userid;

	@Column(name = "LAST_TIME")
	private Date lastTime;

	@OneToOne
	@JoinColumn(name = "USER_ID", insertable = false, updatable = false)
	private Users users;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKhbh() {
		return khbh;
	}

	public void setKhbh(String khbh) {
		this.khbh = khbh;
	}

	public String getKhmc() {
		return khmc;
	}

	public void setKhmc(String khmc) {
		this.khmc = khmc;
	}

	public String getJc() {
		return jc;
	}

	public void setJc(String jc) {
		this.jc = jc;
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

	public String getLxrdh() {
		return lxrdh;
	}

	public void setLxrdh(String lxrdh) {
		this.lxrdh = lxrdh;
	}

	public String getQy() {
		return qy;
	}

	public void setQy(String qy) {
		this.qy = qy;
	}

	public String getYwy() {
		return ywy;
	}

	public void setYwy(String ywy) {
		this.ywy = ywy;
	}

	public String getFhfs() {
		return fhfs;
	}

	public void setFhfs(String fhfs) {
		this.fhfs = fhfs;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getHkfs() {
		return hkfs;
	}

	public void setHkfs(String hkfs) {
		this.hkfs = hkfs;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Date getLastTime() {
		return lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

}
