package com.wrc.ziyo.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_ORDER_DETAIL")
public class OrderDetail implements Serializable {

	@Id
	@Column(name = "TOD_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMER_SEQ")
	@SequenceGenerator(name = "CUSTOMER_SEQ", allocationSize = 1, initialValue = 1, sequenceName = "CUSTOMER_SEQ")
	private Integer id;

	@Column(name = "to_id")
	private Integer to_id;

	@Column(name = "tp_id")
	private Integer tp_id;

	@Column(name = "kc_id")
	private Integer kc_id;

	@Column(name = "num")
	private Integer num;

	@Column(name = "dj")
	private float dj;

	@Column(name = "je")
	private float je;

	@Column(name = "BZ")
	private String bz;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTo_id() {
		return to_id;
	}

	public void setTo_id(Integer to_id) {
		this.to_id = to_id;
	}

	public Integer getTp_id() {
		return tp_id;
	}

	public void setTp_id(Integer tp_id) {
		this.tp_id = tp_id;
	}

	public Integer getKc_id() {
		return kc_id;
	}

	public void setKc_id(Integer kc_id) {
		this.kc_id = kc_id;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public float getDj() {
		return dj;
	}

	public void setDj(float dj) {
		this.dj = dj;
	}

	public float getJe() {
		return je;
	}

	public void setJe(float je) {
		this.je = je;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

}
