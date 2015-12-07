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
@Table(name = "t_rkd")
public class Rkd implements Serializable {

	@Id
	@Column(name = "RKD_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RKD_SEQ")
	@SequenceGenerator(name = "RKD_SEQ", allocationSize = 1, initialValue = 1, sequenceName = "RKD_SEQ")
	private Integer id;
	@Column(name = "RKDBH")
	private String rkdbh;
	@Column(name = "ZDRQ")
	private Date zdrq;
	@Column(name = "BDJE")
	private Float bdje;
	@Column(name = "bz")
	private String bz;
	@Column(name = "USER_ID")
	private Integer userid;
	@OneToOne
	@JoinColumn(name = "USER_ID", insertable = false, updatable = false)
	private Users user;

	@Column(name = "LAST_TIME")
	private Date lastTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRkdbh() {
		return rkdbh;
	}

	public void setRkdbh(String rkdbh) {
		this.rkdbh = rkdbh;
	}

	public Date getZdrq() {
		return zdrq;
	}

	public void setZdrq(Date zdrq) {
		this.zdrq = zdrq;
	}

	public Float getBdje() {
		return bdje;
	}

	public void setBdje(Float bdje) {
		this.bdje = bdje;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Date getLastTime() {
		return lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

}
