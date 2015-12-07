package com.wrc.ziyo.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t_rkdmx")
public class Rkdmx implements Serializable {

	@Id
	@Column(name = "RKDMX_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RKDMX_SEQ")
	@SequenceGenerator(name = "RKDMX_SEQ", allocationSize = 1, initialValue = 1, sequenceName = "RKDMX_SEQ")
	private Integer id;
	// 入库单
	@Column(name = "RKD_ID")
	private Integer rkdid;
	// 商品
	@Column(name = "TP_ID")
	private Integer tpid;
	@Column(name = "RKDJ")
	private Float rkdj;
	@Column(name = "RKSL")
	private Integer rksl;
	@Column(name = "DW")
	private String dw;
	@Column(name = "JE")
	private Float je;
	@Column(name = "SCPH")
	private String scph;
	@Column(name = "SCRQ")
	private Date scrq;
	@Column(name = "YXQ")
	private Date yxq;
	@Column(name = "BZ")
	private String bz;
	@Column(name = "SYSL")
	private Integer sysl;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRkdid() {
		return rkdid;
	}

	public void setRkdid(Integer rkdid) {
		this.rkdid = rkdid;
	}

	public Integer getTpid() {
		return tpid;
	}

	public void setTpid(Integer tpid) {
		this.tpid = tpid;
	}

	public Float getRkdj() {
		return rkdj;
	}

	public void setRkdj(Float rkdj) {
		this.rkdj = rkdj;
	}

	public Integer getRksl() {
		return rksl;
	}

	public void setRksl(Integer rksl) {
		this.rksl = rksl;
	}

	public String getDw() {
		return dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
	}

	public Float getJe() {
		return je;
	}

	public void setJe(Float je) {
		this.je = je;
	}

	public String getScph() {
		return scph;
	}

	public void setScph(String scph) {
		this.scph = scph;
	}

	public Date getScrq() {
		return scrq;
	}

	public void setScrq(Date scrq) {
		this.scrq = scrq;
	}

	public Date getYxq() {
		return yxq;
	}

	public void setYxq(Date yxq) {
		this.yxq = yxq;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public Integer getSysl() {
		return sysl;
	}

	public void setSysl(Integer sysl) {
		this.sysl = sysl;
	}

}
