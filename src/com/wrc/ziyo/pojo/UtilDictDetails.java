package com.wrc.ziyo.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class UtilDictDetails implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "UDD_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dict_detail_seq")
	@SequenceGenerator(name = "dict_detail_seq", allocationSize = 1, initialValue = 1, sequenceName = "dict_detail_seq")
	private Integer id;

	@Column(name = "UD_ID")
	private Integer udId;

	@Column(name = "UDD_NAME")
	private String name;

	@Column(name = "UDD_VALUE")
	private String value;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUdId() {
		return udId;
	}

	public void setUdId(Integer udId) {
		this.udId = udId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
