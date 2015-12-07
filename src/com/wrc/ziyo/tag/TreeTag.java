package com.wrc.ziyo.tag;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class TreeTag extends TagSupport {
	private static final long serialVersionUID = 1L;
	private String fanodeid;

	public int doStartTag() {
		/* 27 */JspWriter out = this.pageContext.getOut();
		/* 28 */HttpSession session = this.pageContext.getSession();
		/* 29 */String treexml = (String) session.getAttribute("userTree");
		try {
			/* 32 */if ((treexml != null) && (!"".equals(treexml))) {
				/* 34 */Document document = DocumentHelper.parseText(treexml);
				/* 35 */Element root = document.getRootElement();

				/* 37 */if (((this.fanodeid == null) || (""
						.equals(this.fanodeid))) &&
				/* 38 */(root.element("Levelup-0") != null)) {
					/* 39 */this.fanodeid = root.element("Levelup-0")
							.element("fanodeid-0").elementText("nodeid");
				}

				/* 43 */StringBuffer treehtml = new StringBuffer();

				/* 48 */treehtml.append(" <script type='text/javascript'>");
				/* 49 */treehtml.append("d = new dTree('d');");
				/* 50 */treehtml
						.append("d.add("
								+ this.fanodeid
								+ ",-1,'"
								+ getFaname(this.fanodeid, treexml)
								+ "&nbsp;&nbsp;&nbsp;<a href=\"javascript: d.openAll();\">打开全部</a> | <a href=\"javascript: d.closeAll();\">关闭全部</a>');");

				/* 52 */getTree(this.fanodeid, 1, root, treehtml);

				/* 54 */treehtml.append("document.write(d);");
				/* 55 */treehtml.append("</script>");

				/* 57 */out.print(treehtml.toString());
			} else {
				/* 59 */out.print("您的登录已超时！请重新登录");
			}
		} catch (Exception e) {
			/* 62 */e.printStackTrace();
		}
		/* 64 */return 1;
	}

	public int doEndTag() {
		/* 68 */return 6;
	}

	public String getFaname(String fanodeid, String xml) {
		/* 72 */String fanodename = "";
		/* 73 */if (xml.indexOf("<nodeid>" + fanodeid + "</nodeid>") != -1) {
			/* 74 */fanodename = xml.substring(xml.indexOf("<nodeid>"
					+ fanodeid + "</nodeid>"));
			/* 75 */fanodename = fanodename.substring(
					fanodename.indexOf("<name>") + 6,
					fanodename.indexOf("</name>"));
		}
		/* 77 */return fanodename;
	}

	public void getTree(String fanodeid, int Levelup, Element tree,
			StringBuffer treehtml) {
		/* 83 */Iterator iter = tree.elementIterator("Levelup-" + Levelup);
		/* 84 */while (iter.hasNext()) {
			/* 85 */Element levelEl = (Element) iter.next();
			/* 86 */List ellist = levelEl.elements("fanodeid-" + fanodeid);
			/* 87 */for (int i = 0; i < ellist.size(); i++) {
				/* 88 */Element fanode = (Element) ellist.get(i);

				/* 94 */String strurl = "";
				/* 95 */if (fanode.elementText("url").indexOf(",") != -1)
					/* 96 */strurl = fanode.elementText("url").substring(0,
							fanode.elementText("url").indexOf(","));
				else {
					/* 98 */strurl = fanode.elementText("url");
				}

				/* 102 */String imgOpen = "";
				/* 103 */String imgClose = "";
				/* 104 */if (fanode.elementText("imgurl").indexOf(",") != -1) {
					/* 105 */imgOpen = fanode.elementText("imgurl").substring(
							0, fanode.elementText("imgurl").indexOf(","));
					/* 106 */imgClose = fanode.elementText("imgurl").substring(
							fanode.elementText("imgurl").indexOf(",") + 1,
							fanode.elementText("imgurl").length());
				} else {
					/* 108 */imgOpen = fanode.elementText("imgurl");
					/* 109 */imgClose = fanode.elementText("imgurl");
				}

				/* 114 */if ("0".equals(fanode.elementText("type"))) {
					/* 115 */treehtml.append("d.add("
							+ fanode.elementText("nodeid") + "," +
							/* 116 */fanodeid + "," +
							/* 117 */"'" + fanode.elementText("name") + "'," +
							/* 118 */"'" + strurl + "'," +
							/* 119 */"'" + fanode.elementText("rem") + "'," +
							/* 120 */"''," +
							/* 121 */"'" + imgOpen + "'," +
							/* 122 */"'" + imgClose + "'," +
							/* 123 */"false" +
							/* 124 */");");

					/* 126 */getTree(fanode.elementText("nodeid"), Levelup + 1,
							tree, treehtml);
				}
			}
		}
	}

	public String getFanodeid() {
		/* 133 */return this.fanodeid;
	}

	public void setFanodeid(String fanodeid) {
		/* 138 */this.fanodeid = fanodeid;
	}
}

/*
 * Location: C:\Users\asus\Desktop\sshFrame\WebContent\WEB-INF\classes\
 * Qualified Name: com.wrc.sshFrame.tag.TreeTag JD-Core Version: 0.6.0
 */