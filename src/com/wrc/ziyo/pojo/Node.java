package com.wrc.ziyo.pojo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t_node")
public class Node implements Serializable {

	// 节点ID
	@Id
	@Column(name = "NODE_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "node_seq")
	@SequenceGenerator(name = "node_seq", allocationSize = 1, initialValue = 1, sequenceName = "node_seq")
	private Integer nodeid;

	// 节点名称
	@Column(name = "NODE_NAME", nullable = false, length = 50)
	private String nodename;

	// 父节点ID
	@Column(name = "NODE_FID", nullable = false, length = 8)
	private Integer nodefid;

	// 第几层 0,1,2...
	@Column(name = "NODE_LEVEUP", nullable = false, length = 2)
	private Integer levelup;

	// 节点功能标志 0：节点,1:功能(10,不用选中数据的操作. 11,选中单条数据的操作 12,可选多条数据的操作),2:不显示隐藏
	@Column(name = "NODE_TYPE", nullable = false, length = 2)
	private Integer type;

	// URL 一个功能多个URL以,号分开
	@Column(name = "NODE_URL", nullable = false, length = 100)
	private String url;

	// 前序图片 打开与关闭等多个图片以,号分开
	@Column(name = "NODE_IMGURL", nullable = false, length = 100)
	private String imgurl;

	// 启用标志 Y启用 N不启用
	@Column(name = "NODE_FLAG", nullable = false, length = 2)
	private String flag;

	// 排序 顺序排序
	@Column(name = "NODE_SORT", nullable = false, length = 2)
	private Integer sort;

	// 备注
	@Column(name = "NODE_REM", nullable = false, length = 120)
	private String rem;

	public Node() {
	}

	public Node(Integer nodeid, String nodename, Integer nodefid,
			Integer levelup, Integer type, String flag, Integer sort) {
		/* 67 */this.nodeid = nodeid;
		/* 68 */this.nodename = nodename;
		/* 69 */this.nodefid = nodefid;
		/* 70 */this.levelup = levelup;
		/* 71 */this.type = type;
		/* 72 */this.flag = flag;
		/* 73 */this.sort = sort;
	}

	public Node(Integer nodeid, String nodename, Integer nodefid,
			Integer levelup, Integer type, String url, String imgurl,
			String flag, Integer sort, String rem, Set rolenodes) {
		/* 80 */this.nodeid = nodeid;
		/* 81 */this.nodename = nodename;
		/* 82 */this.nodefid = nodefid;
		/* 83 */this.levelup = levelup;
		/* 84 */this.type = type;
		/* 85 */this.url = url;
		/* 86 */this.imgurl = imgurl;
		/* 87 */this.flag = flag;
		/* 88 */this.sort = sort;
		/* 89 */this.rem = rem;
	}

	public Integer getNodeid() {
		/* 95 */return this.nodeid;
	}

	public void setNodeid(Integer nodeid) {
		/* 99 */this.nodeid = nodeid;
	}

	public String getNodename() {
		/* 103 */return this.nodename;
	}

	public void setNodename(String nodename) {
		/* 107 */this.nodename = nodename;
	}

	public Integer getNodefid() {
		/* 112 */return this.nodefid;
	}

	public void setNodefid(Integer nodefid) {
		/* 116 */this.nodefid = nodefid;
	}

	public Integer getLevelup() {
		/* 120 */return this.levelup;
	}

	public void setLevelup(Integer levelup) {
		/* 124 */this.levelup = levelup;
	}

	public Integer getType() {
		/* 128 */return this.type;
	}

	public void setType(Integer type) {
		/* 132 */this.type = type;
	}

	public String getUrl() {
		/* 136 */return this.url;
	}

	public void setUrl(String url) {
		/* 140 */this.url = url;
	}

	public String getImgurl() {
		/* 144 */return this.imgurl;
	}

	public void setImgurl(String imgurl) {
		/* 148 */this.imgurl = imgurl;
	}

	public String getFlag() {
		/* 152 */return this.flag;
	}

	public void setFlag(String flag) {
		/* 156 */this.flag = flag;
	}

	public Integer getSort() {
		/* 160 */return this.sort;
	}

	public void setSort(Integer sort) {
		/* 164 */this.sort = sort;
	}

	public String getRem() {
		/* 168 */return this.rem;
	}

	public void setRem(String rem) {
		/* 172 */this.rem = rem;
	}
}

/*
 * Location: C:\Users\asus\Desktop\sshFrame\WebContent\WEB-INF\classes\
 * Qualified Name: com.wrc.sshFrame.pojo.Node JD-Core Version: 0.6.0
 */