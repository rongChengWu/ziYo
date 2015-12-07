package com.wrc.ziyo.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t_user_power")
public class UserPower implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "TUP_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userpower_seq")
	@SequenceGenerator(name = "userpower_seq", allocationSize = 1, initialValue = 1, sequenceName = "userpower_seq")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "TUP_USERID")
	private Users users;

	@ManyToOne
	@JoinColumn(name = "TUP_NODEID")
	private Node node;

	public Integer getId() {
		/* 42 */return this.id;
	}

	public void setId(Integer id) {
		/* 46 */this.id = id;
	}

	public Users getUser() {
		/* 50 */return this.users;
	}

	public void setUser(Users users) {
		/* 54 */this.users = users;
	}

	public Node getNode() {
		/* 58 */return this.node;
	}

	public void setNode(Node node) {
		/* 62 */this.node = node;
	}
}

/*
 * Location: C:\Users\asus\Desktop\sshFrame\WebContent\WEB-INF\classes\
 * Qualified Name: com.wrc.sshFrame.pojo.UserPower JD-Core Version: 0.6.0
 */