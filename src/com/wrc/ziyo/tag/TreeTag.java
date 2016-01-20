package com.wrc.ziyo.tag;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * 
 * @author James
 * @version 1.0 左侧菜单 2015-12-21 跟新为 metro 风格
 * 
 */
public class TreeTag extends TagSupport {
	private static final long serialVersionUID = 1L;
	private String fanodeid;

	public int doStartTag() {
		JspWriter out = this.pageContext.getOut();
		HttpSession session = this.pageContext.getSession();
		String treexml = (String) session.getAttribute("userTree");
		try {
			if ((treexml != null) && (!"".equals(treexml))) {
				Document document = DocumentHelper.parseText(treexml);
				Element root = document.getRootElement();

				if (((this.fanodeid == null) || ("".equals(this.fanodeid)))
						&& (root.element("Levelup-0") != null)) {
					this.fanodeid = root.element("Levelup-0")
							.element("fanodeid-0").elementText("nodeid");
				}

				StringBuffer treehtml = new StringBuffer();

				treehtml.append(" <script type='text/javascript'>");
				treehtml.append("d = new dTree('d');");
				treehtml.append("d.add("
						+ this.fanodeid
						+ ",-1,'"
						+ getFaname(this.fanodeid, treexml)
						+ "&nbsp;&nbsp;&nbsp;<a href=\"javascript: d.openAll();\">打开全部</a> | <a href=\"javascript: d.closeAll();\">关闭全部</a>');");

				getTree(this.fanodeid, 1, root, treehtml);

				treehtml.append("document.write(d);");
				treehtml.append("</script>");

				out.print(treehtml.toString());
			} else {
				out.print("您的登录已超时！请重新登录");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}

	public int doEndTag() {
		return 6;
	}

	public String getFaname(String fanodeid, String xml) {
		String fanodename = "";
		if (xml.indexOf("<nodeid>" + fanodeid + "</nodeid>") != -1) {
			fanodename = xml.substring(xml.indexOf("<nodeid>" + fanodeid
					+ "</nodeid>"));
			fanodename = fanodename.substring(fanodename.indexOf("<name>") + 6,
					fanodename.indexOf("</name>"));
		}
		return fanodename;
	}

	public void getTree(String fanodeid, int Levelup, Element tree,
			StringBuffer treehtml) {
		Iterator iter = tree.elementIterator("Levelup-" + Levelup);
		while (iter.hasNext()) {
			Element levelEl = (Element) iter.next();
			List ellist = levelEl.elements("fanodeid-" + fanodeid);
			for (int i = 0; i < ellist.size(); i++) {
				Element fanode = (Element) ellist.get(i);

				String strurl = "";
				if (fanode.elementText("url").indexOf(",") != -1)
					strurl = fanode.elementText("url").substring(0,
							fanode.elementText("url").indexOf(","));
				else {
					strurl = fanode.elementText("url");
				}

				String imgOpen = "";
				String imgClose = "";
				if (fanode.elementText("imgurl").indexOf(",") != -1) {
					imgOpen = fanode.elementText("imgurl").substring(0,
							fanode.elementText("imgurl").indexOf(","));
					imgClose = fanode.elementText("imgurl").substring(
							fanode.elementText("imgurl").indexOf(",") + 1,
							fanode.elementText("imgurl").length());
				} else {
					imgOpen = fanode.elementText("imgurl");
					imgClose = fanode.elementText("imgurl");
				}

				if ("0".equals(fanode.elementText("type"))) {
					treehtml.append("d.add(" + fanode.elementText("nodeid")
							+ "," + fanodeid + "," + "'"
							+ fanode.elementText("name") + "'," + "'" + strurl
							+ "'," + "'" + fanode.elementText("rem") + "',"
							+ "''," + "'" + imgOpen + "'," + "'" + imgClose
							+ "'," + "false" + ");");

					getTree(fanode.elementText("nodeid"), Levelup + 1, tree,
							treehtml);
				}
			}
		}
	}

	public String getFanodeid() {
		return this.fanodeid;
	}

	public void setFanodeid(String fanodeid) {
		this.fanodeid = fanodeid;
	}
}
