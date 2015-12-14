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
@Table(name = "T_ORDER")
public class Order implements Serializable {

	@Id
	@Column(name = "TO_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_SEQ")
	@SequenceGenerator(name = "ORDER_SEQ", allocationSize = 1, initialValue = 1, sequenceName = "ORDER_SEQ")
	private Integer id;

	@Column(name = "XSDBH")
	private String xsdbh;

	@Column(name = "TO_TIME")
	private Date to_date;

	@Column(name = "TC_ID")
	private Integer tc_id;

	@Column(name = "FZR")
	private String fzr;

	@Column(name = "bdzj")
	private Float bdzj;

	@Column(name = "BZ")
	private String bz;

	@Column(name = "TYPE")
	private String type;

	@Column(name = "USER_ID")
	private Integer user_id;

	@Column(name = "lastTime")
	private Date lastTime;

	@Column(name = "LASET_USER")
	private Integer lastUser;

	@OneToOne
	@JoinColumn(name = "USER_ID", insertable = false, updatable = false)
	private Users zdUser;

	@OneToOne
	@JoinColumn(name = "LASET_USER", insertable = false, updatable = false)
	private Users zhUser;

	@OneToOne
	@JoinColumn(name = "TC_ID", insertable = false, updatable = false)
	private Customer customer;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getXsdbh() {
		return xsdbh;
	}

	public void setXsdbh(String xsdbh) {
		this.xsdbh = xsdbh;
	}

	public Date getTo_date() {
		return to_date;
	}

	public void setTo_date(Date to_date) {
		this.to_date = to_date;
	}

	public Integer getTc_id() {
		return tc_id;
	}

	public void setTc_id(Integer tc_id) {
		this.tc_id = tc_id;
	}

	public String getFzr() {
		return fzr;
	}

	public void setFzr(String fzr) {
		this.fzr = fzr;
	}

	public float getBdzj() {
		return bdzj;
	}

	public void setBdzj(float bdzj) {
		this.bdzj = bdzj;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Date getLastTime() {
		return lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

	public Integer getLastUser() {
		return lastUser;
	}

	public void setLastUser(Integer lastUser) {
		this.lastUser = lastUser;
	}

	public Users getZdUser() {
		return zdUser;
	}

	public void setZdUser(Users zdUser) {
		this.zdUser = zdUser;
	}

	public Users getZhUser() {
		return zhUser;
	}

	public void setZhUser(Users zhUser) {
		this.zhUser = zhUser;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
