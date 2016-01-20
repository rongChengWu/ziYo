package com.wrc.ziyo.action.system;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.jdom.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.wrc.ziyo.pojo.Node;
import com.wrc.ziyo.pojo.UserPower;
import com.wrc.ziyo.pojo.Users;
import com.wrc.ziyo.service.system.NodeService;
import com.wrc.ziyo.service.system.UserPowerService;
import com.wrc.ziyo.service.users.UsersService;
import com.wrc.ziyo.util.StringUtil;

@Namespace("/systemAction")
@Scope("prototype")
@Controller
@Component("systemAction")
public class SystemAction extends ActionSupport implements ServletRequestAware,
		ServletResponseAware {
	private static final long serialVersionUID = 1L;

	@Autowired
	private NodeService nodeService;
	private HttpServletRequest request;
	private HttpServletResponse response;

	@Autowired
	private UsersService usersService;

	@Autowired
	private UserPowerService userPowerService;
	private Users users;

	@Action(value = "userLogin", results = {
			@org.apache.struts2.convention.annotation.Result(name = "success", location = "/jsp/system/mainframe.jsp", type = "redirect"),
			@org.apache.struts2.convention.annotation.Result(name = "error", location = "/error.jsp") })
	public String userLogin() {
		try {
			this.users = this.usersService.findUser(this.users);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (this.users == null) {
			this.request.setAttribute("msg", "用户名或密码错误!");
			return "error";
		}
		this.request.getSession().setAttribute("userLogin", this.users);
		try {
			List list = new ArrayList();
			if (this.users.getUserType().intValue() == 0) {
				list = this.nodeService
						.findByHqlWher(" order by levelup asc,sort desc ");
			} else {
				UserPower up = new UserPower();
				up.setUser(this.users);
				list = this.userPowerService.findByExample(up);
			}

			this.request.getSession()
					.setAttribute("userTree", packageXml(list));
		} catch (Exception e) {
			e.printStackTrace();
			this.request.setAttribute("msg", "查询节点失败！");
			return "error";
		}
		return "success";
	}

	private String packageXml(List<Node> list) {
		/* 116 */Element Tree = new Element("Tree");
		/* 117 */if ((list != null) && (list.size() > 0)) {
			/* 118 */Element Levelup = null;
			/* 119 */Element fanodeid = null;
			/* 120 */Element nodeid = null;
			/* 121 */Element name = null;
			/* 122 */Element type = null;
			/* 123 */Element url = null;
			/* 124 */Element imgurl = null;
			/* 125 */Element rem = null;

			/* 127 */for (Node node : list) {
				/* 128 */if ((Levelup == null)
						|| (!String.valueOf("Levelup-" + node.getLevelup())
								.equals(Levelup.getName()))) {
					/* 129 */if (Levelup != null)
						Tree.addContent(Levelup);
					/* 130 */Levelup = new Element("Levelup-"
							+ node.getLevelup());
				}
				/* 132 */fanodeid = new Element("fanodeid-" + node.getNodefid());
				/* 133 */nodeid = new Element("nodeid");
				/* 134 */nodeid.addContent(String.valueOf(node.getNodeid()));
				/* 135 */name = new Element("name");
				/* 136 */name.addContent(node.getNodename() == null ? "" : node
						.getNodename().toString());
				/* 137 */type = new Element("type");
				/* 138 */type.addContent(String.valueOf(node.getType()));
				/* 139 */url = new Element("url");
				/* 140 */url.addContent((node.getUrl() == null ? "" : node
						.getUrl()).toString());
				/* 141 */imgurl = new Element("imgurl");
				/* 142 */imgurl.addContent((node.getImgurl() == null ? ""
						: node.getImgurl()).toString());
				/* 143 */rem = new Element("rem");
				/* 144 */rem.addContent((node.getRem() == null ? "" : node
						.getRem()).toString());
				/* 145 */fanodeid.addContent(nodeid);
				/* 146 */fanodeid.addContent(name);
				/* 147 */fanodeid.addContent(type);
				/* 148 */fanodeid.addContent(url);
				/* 149 */fanodeid.addContent(imgurl);
				/* 150 */fanodeid.addContent(rem);
				/* 151 */Levelup.addContent(fanodeid);
			}
			/* 153 */if (Levelup != null)
				Tree.addContent(Levelup);
		}
		/* 155 */String treeStr = StringUtil.ElementToString(Tree, "GBK");
		/* 156 */System.out.println(treeStr);
		/* 157 */return treeStr;
	}

	public void setServletResponse(HttpServletResponse arg0) {
		/* 162 */this.response = arg0;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		/* 167 */this.request = arg0;
	}

	public UsersService getUsersService() {
		/* 171 */return this.usersService;
	}

	public void setUsersService(UsersService usersService) {
		/* 175 */this.usersService = usersService;
	}

	public NodeService getNodeService() {
		/* 179 */return this.nodeService;
	}

	public void setNodeService(NodeService nodeService) {
		/* 183 */this.nodeService = nodeService;
	}

	public UserPowerService getUserPowerService() {
		/* 187 */return this.userPowerService;
	}

	public void setUserPowerService(UserPowerService userPowerService) {
		/* 191 */this.userPowerService = userPowerService;
	}

	public Users getUsers() {
		/* 195 */return this.users;
	}

	public void setUsers(Users users) {
		/* 199 */this.users = users;
	}

}

/*
 * Location: C:\Users\asus\Desktop\sshFrame\WebContent\WEB-INF\classes\
 * Qualified Name: com.wrc.sshFrame.action.SystemAction JD-Core Version: 0.6.0
 */