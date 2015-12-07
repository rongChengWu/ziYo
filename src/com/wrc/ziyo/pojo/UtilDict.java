package com.wrc.ziyo.pojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

public class UtilDict implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "UD_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dict_seq")
	@SequenceGenerator(name = "dict_seq", allocationSize = 1, initialValue = 1, sequenceName = "dict_seq")
	private Integer id;

	@Column(name = "UD_CODE")
	private String code;

	@Column(name = "UD_NAME")
	private String name;

	@Column(name = "LAST_TIME")
	private String lastTime;

	@OneToMany
	@JoinColumn(name = "UD_ID", insertable = false, updatable = false)
	private List<UtilDictDetails> uddList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastTime() {
		return lastTime;
	}

	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}

	public List<UtilDictDetails> getUddList() {
		return uddList;
	}

	public void setUddList(List<UtilDictDetails> uddList) {
		this.uddList = uddList;
	}

}
