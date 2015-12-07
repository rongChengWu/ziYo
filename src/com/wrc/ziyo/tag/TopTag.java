package com.wrc.ziyo.tag;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class TopTag extends TagSupport {
	private static final long serialVersionUID = 1L;

	public int doStartTag() {
		JspWriter out = this.pageContext.getOut();
		HttpSession session = this.pageContext.getSession();
		String treexml = (String) session.getAttribute("userTree");
		try {
			if ((treexml != null) && (!"".equals(treexml))) {
				StringBuffer treehtml = new StringBuffer();
				Document document = DocumentHelper.parseText(treexml);
				Element root = document.getRootElement();
				Iterator iter = root.elementIterator("Levelup-0");
				int j = 0;
				while (iter.hasNext()) {
					Element parEl = (Element) iter.next();
					System.out.println(parEl.getName());
					System.out.println(parEl.elementText("fanodeid-0"));
					List ellist = parEl.elements("fanodeid-0");

					for (int i = 0; i < ellist.size(); i++) {
						Element fanode = (Element) ellist.get(i);

						String name = fanode.elementText("name");
						System.out.println(name);
						String nodeid = fanode.elementText("nodeid");
						String style = "";
						if (j == 0)
							style = "current";
						else
							style = "";
						treehtml.append("<li><a name='level0' class='");
						treehtml.append(style);
						treehtml.append("' href='#' onclick='ShowTree(");
						treehtml.append(nodeid);
						treehtml.append(",this)'><span>" + name
								+ "</span></a></li>");
						j++;
					}
				}

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
}

/*
 * Location: C:\Users\asus\Desktop\sshFrame\WebContent\WEB-INF\classes\
 * Qualified Name: com.wrc.sshFrame.tag.TopTag JD-Core Version: 0.6.0
 */