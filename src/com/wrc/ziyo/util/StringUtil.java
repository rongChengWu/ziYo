package com.wrc.ziyo.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import sun.misc.BASE64Encoder;

public class StringUtil {
	public static List flagListFileUrl(List<String> list) {
		/* 28 */List rslist = new ArrayList();
		/* 29 */if (list != null) {
			/* 30 */for (String url : list) {
				/* 31 */String strUrl = StringUtil.class.getClassLoader()
						.getResource("").getPath();
				/* 32 */System.out.println("原始图片:" + url);
				/* 33 */System.out.println("原始图片地址:" + strUrl);
				/* 34 */strUrl = strUrl.substring(0, strUrl.length() - 17);

				/* 36 */url = url.replace(strUrl, "");
				/* 37 */System.out.println("图片地址:" + url);
				/* 38 */rslist.add(url);
			}
		}
		/* 41 */return rslist;
	}

	public static final String convertStringSTR(String strOrig, String str) {
		/* 46 */String strReturn = "";
		/* 47 */if ((strOrig == null) || (strOrig.equals(null))
				|| (strOrig.equals("null")))
			/* 48 */strReturn = str;
		else {
			/* 50 */strReturn = strOrig.trim();
		}
		/* 52 */return strReturn;
	}

	public static final String convertStringNull(String strOrig) {
		/* 57 */String strReturn = "";
		/* 58 */if ((strOrig == null) || (strOrig.equals(null))
				|| (strOrig.equals("null")))
			/* 59 */strReturn = "";
		else {
			/* 61 */strReturn = strOrig.trim();
		}
		/* 63 */return strReturn;
	}

	public static String doWithNull(Object o) {
		/* 68 */if (o == null) {
			/* 69 */return "";
		}
		/* 71 */return o.toString();
	}

	public static String[] split(String strSource, String strDiv) {
		/* 76 */int arynum = 0;
		int intIdx = 0;
		int intIdex = 0;
		/* 77 */int div_length = strDiv.length();
		/* 78 */if (strSource.compareTo("") != 0) {
			/* 79 */if (strSource.indexOf(strDiv) != -1) {
				/* 80 */intIdx = strSource.indexOf(strDiv);
				/* 81 */for (int intCount = 1;; intCount++) {
					/* 82 */if (strSource.indexOf(strDiv, intIdx + div_length) != -1) {
						/* 83 */intIdx = strSource.indexOf(strDiv, intIdx
								+ div_length);
						/* 84 */arynum = intCount;
					} else {
						/* 86 */arynum += 2;
						/* 87 */break;
					}
				}
			}
			/* 91 */arynum = 1;
		} else {
			/* 94 */arynum = 0;
		}
		/* 96 */intIdx = 0;
		/* 97 */intIdex = 0;
		/* 98 */String[] returnStr = new String[arynum];

		/* 100 */if (strSource.compareTo("") != 0) {
			/* 101 */if (strSource.indexOf(strDiv) != -1) {
				/* 102 */intIdx = strSource.indexOf(strDiv);
				/* 103 */returnStr[0] = strSource.substring(0, intIdx);
				/* 104 */for (int intCount = 1;; intCount++) {
					/* 105 */if (strSource.indexOf(strDiv, intIdx + div_length) != -1) {
						/* 106 */intIdex = strSource.indexOf(strDiv, intIdx
								+ div_length);
						/* 107 */returnStr[intCount] = strSource.substring(
								intIdx + div_length, intIdex);
						/* 108 */intIdx = strSource.indexOf(strDiv, intIdx
								+ div_length);
					} else {
						/* 110 */returnStr[intCount] = strSource.substring(
								intIdx + div_length, strSource.length());
						/* 111 */break;
					}
				}
			}
			/* 115 */returnStr[0] = strSource.substring(0, strSource.length());
			/* 116 */return returnStr;
		}

		/* 121 */return returnStr;
	}

	public static String arrToString(String[] arr) {
		/* 126 */if (arr == null)
			/* 127 */return "";
		/* 128 */StringBuffer sb = new StringBuffer();
		/* 129 */for (int i = 0; i < arr.length; i++) {
			/* 130 */if ((arr[i] != null) && (!arr[i].equals("")))
				/* 131 */sb.append(arr[i] + ",");
		}
		/* 133 */String returnValue = sb.toString();
		/* 134 */if (returnValue.endsWith(","))
			/* 135 */returnValue = returnValue.substring(0,
					returnValue.length() - 1);
		/* 136 */return returnValue;
	}

	public static String arrToString(String[] arr, String splitChar) {
		/* 141 */if (splitChar == null)
			/* 142 */return arrToString(arr);
		/* 143 */if (arr == null)
			/* 144 */return "";
		/* 145 */StringBuffer sb = new StringBuffer();
		/* 146 */for (int i = 0; i < arr.length; i++) {
			/* 147 */if ((arr[i] != null) && (!arr[i].equals("")))
				/* 148 */sb.append(arr[i] + splitChar);
		}
		/* 150 */String returnValue = sb.toString();
		/* 151 */if (returnValue.endsWith(splitChar))
			/* 152 */returnValue = returnValue.substring(0,
					returnValue.length() - splitChar.length());
		/* 153 */return returnValue;
	}

	public static String objectToString(Object object) {
		/* 158 */if (object == null)
			/* 159 */return "";
		/* 160 */String returnValue = "";
		/* 161 */if ((object instanceof String))
			/* 162 */returnValue = (String) object;
		/* 163 */else if ((object instanceof String[]))
			/* 164 */returnValue = arrToString((String[]) object);
		else {
			/* 166 */returnValue = object.toString();
		}
		/* 168 */return returnValue;
	}

	public static String objectToString(Object object, String splitChar) {
		/* 173 */if (object == null)
			/* 174 */return "";
		/* 175 */String returnValue = "";
		/* 176 */if ((object instanceof String))
			/* 177 */returnValue = (String) object;
		/* 178 */else if ((object instanceof String[])) {
			/* 179 */returnValue = arrToString((String[]) object, splitChar);
		}
		/* 181 */return returnValue;
	}

	public static String replace(String str, String strSub, String strRpl) {
		/* 186 */String[] tmp = split(str, strSub);
		/* 187 */String returnstr = "";
		/* 188 */if (tmp.length != 0) {
			/* 189 */returnstr = tmp[0];
			/* 190 */for (int i = 0; i < tmp.length - 1; i++) {
				/* 191 */returnstr = doWithNull(returnstr) + strRpl
						+ tmp[(i + 1)];
			}
		}
		/* 194 */return doWithNull(returnstr);
	}

	public static String htmlEncode(String txt) {
		/* 198 */if (txt != null) {
			/* 199 */txt = replace(txt, "&", "&amp;");
			/* 200 */txt = replace(txt, "&amp;amp;", "&amp;");
			/* 201 */txt = replace(txt, "&amp;quot;", "&quot;");
			/* 202 */txt = replace(txt, "\"", "&quot;");
			/* 203 */txt = replace(txt, "&amp;lt;", "&lt;");
			/* 204 */txt = replace(txt, "<", "&lt;");
			/* 205 */txt = replace(txt, "&amp;gt;", "&gt;");
			/* 206 */txt = replace(txt, ">", "&gt;");
			/* 207 */txt = replace(txt, "&amp;nbsp;", "&nbsp;");
		}

		/* 210 */return txt;
	}

	public static String unHtmlEncode(String txt) {
		/* 215 */if (txt != null) {
			/* 216 */txt = replace(txt, "&amp;", "&");
			/* 217 */txt = replace(txt, "&quot;", "\"");
			/* 218 */txt = replace(txt, "&lt;", "<");
			/* 219 */txt = replace(txt, "&gt;", ">");
			/* 220 */txt = replace(txt, "&nbsp;", " ");
		}
		/* 222 */return txt;
	}

	public static String toGBK(String str) {
		/* 227 */if (str != null) {
			/* 228 */byte[] tmpbyte = (byte[]) null;
			try {
				/* 230 */tmpbyte = str.getBytes("ISO8859_1");
			} catch (Exception e) {
				/* 232 */System.out.println("Error: Method: StringUtil.toGBK :"
						+ e.getMessage());
			}
			try {
				/* 235 */str = new String(tmpbyte, "GBK");
			} catch (Exception e) {
				/* 237 */System.out.println("Error: Method: StringUtil.toGBK :"
						+ e.getMessage());
			}
		}
		/* 240 */return str;
	}

	public static String toISO(String str) {
		/* 245 */if (str != null) {
			/* 246 */byte[] tmpbyte = (byte[]) null;
			try {
				/* 248 */tmpbyte = str.getBytes("GBK");
			} catch (Exception e) {
				/* 250 */System.out.println("Error: Method: StringUtil.toISO :"
						+ e.getMessage());
			}
			try {
				/* 253 */str = new String(tmpbyte, "ISO8859_1");
			} catch (Exception e) {
				/* 255 */System.out.println("Error: Method: StringUtil.toISO :"
						+ e.getMessage());
			}
		}
		/* 258 */return str;
	}

	public static String toUTF8(String str) {
		/* 263 */if (str != null) {
			/* 264 */byte[] tmpbyte = (byte[]) null;
			try {
				/* 266 */tmpbyte = str.getBytes("ISO-8859-1");
			} catch (Exception e) {
				/* 268 */System.out
						.println("Error: Method: StringUtil.toUTF8 :"
								+ e.getMessage());
			}
			try {
				/* 271 */str = new String(tmpbyte, "UTF-8");
			} catch (Exception e) {
				/* 273 */System.out
						.println("Error: Method: StringUtil.toUTF8 :"
								+ e.getMessage());
			}
		}
		/* 276 */return str;
	}

	public static String utf8ToGBK(String str) {
		/* 281 */if (str != null) {
			/* 282 */byte[] tmpbyte = (byte[]) null;
			try {
				/* 284 */tmpbyte = str.getBytes("UTF-8");
			} catch (Exception e) {
				/* 286 */System.out
						.println("Error: Method: StringUtil.toUTF8 :"
								+ e.getMessage());
			}
			try {
				/* 289 */str = new String(tmpbyte, "ISO-8859-1");
			} catch (Exception e) {
				/* 291 */System.out
						.println("Error: Method: StringUtil.toUTF8 :"
								+ e.getMessage());
			}
		}
		/* 294 */return str;
	}

	public static String utf8ToISO(String str) {
		/* 299 */if (str != null) {
			/* 300 */byte[] tmpbyte = (byte[]) null;
			try {
				/* 302 */tmpbyte = str.getBytes("UTF-8");
			} catch (Exception e) {
				/* 304 */System.out
						.println("Error: Method: StringUtil.toUTF8 :"
								+ e.getMessage());
			}
			try {
				/* 307 */str = new String(tmpbyte, "GBK");
			} catch (Exception e) {
				/* 309 */System.out
						.println("Error: Method: StringUtil.toUTF8 :"
								+ e.getMessage());
			}
		}
		/* 312 */return str;
	}

	public static String convertN2Br(String content) {
		/* 316 */if (content == null) {
			/* 317 */return "";
		}
		/* 319 */content = content.replaceAll("\r\n", "<br>");

		/* 321 */return content;
	}

	public static String toStandardStr(String strOrigin) {
		/* 326 */if ((strOrigin == null) || (strOrigin.equals(null)))
			/* 327 */strOrigin = "";
		else {
			/* 329 */strOrigin = strOrigin.trim();
		}
		try {
			/* 333 */strOrigin = new String(strOrigin.getBytes("GBK"),
					"ISO8859_1");
		} catch (Exception localException) {
		}
		/* 336 */return strOrigin;
	}

	public static String toChineseStr(String strOrigin) {
		/* 341 */if ((strOrigin == null) || (strOrigin.equals(null)))
			/* 342 */strOrigin = "";
		else {
			/* 344 */strOrigin = strOrigin.trim();
		}
		try {
			/* 348 */strOrigin = new String(strOrigin.getBytes("ISO8859_1"),
					"GBK");
		} catch (Exception localException) {
		}
		/* 351 */return strOrigin;
	}

	public static String convertSqlString(String sqlVar,
			String[] illegalityString) {
		/* 356 */if (sqlVar == null)
			/* 357 */return null;
		/* 358 */if ((illegalityString == null)
				|| (illegalityString.length == 0)) {
			/* 359 */illegalityString = new String[2];
			/* 360 */illegalityString[0] = "'";
			/* 361 */illegalityString[1] = "\"";
		}

		/* 364 */for (int i = 0; i < illegalityString.length; i++) {
			/* 365 */if (sqlVar.indexOf(illegalityString[i]) >= 0) {
				/* 366 */sqlVar = sqlVar.replaceAll(
						String.valueOf(illegalityString[i]), "");
			}
		}
		/* 369 */return sqlVar;
	}

	public static String EncoderByMd5(String str) throws Exception {
		/* 375 */MessageDigest md5 = MessageDigest.getInstance("MD5");
		/* 376 */BASE64Encoder base64en = new BASE64Encoder();

		/* 378 */String newstr = base64en.encode(md5.digest(str != null ? str
				.getBytes() : "".getBytes()));
		/* 379 */return newstr;
	}

	public static String ElementToString(Element ele, String encode) {
		String str = null;
		Format xmlformat = Format.getCompactFormat();
		xmlformat.setEncoding(encode);
		xmlformat.setIndent("");
		Document doc = new Document();
		doc.addContent(ele.detach());
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		XMLOutputter XMLOut = new XMLOutputter(xmlformat);
		try {
			XMLOut.output(doc, baos);
		} catch (IOException e) {
			e.printStackTrace();
		}
		str = baos.toString();
		return str;
	}

	public static Element StringToElement(String xml, String encode) {
		/* 403 */Element doc = null;
		/* 404 */SAXBuilder builder = new SAXBuilder();
		try {
			/* 406 */if ((xml != null) && (xml.length() > 0))
				doc = builder.build(
						new ByteArrayInputStream(xml.trim().getBytes(encode)))
						.getRootElement();
		} catch (Exception e) {
			/* 409 */e.printStackTrace();
		}
		/* 411 */return doc;
	}

	public static String flagUrl(HttpServletRequest req) {
		/* 416 */String reurl = (String) req.getAttribute("toobar_url");

		/* 418 */if ((req.getQueryString() != null)
				&& (req.getQueryString().indexOf("method=") != -1) &&
				/* 419 */(reurl.indexOf(".po") != -1)) {
			/* 420 */if (req.getQueryString().indexOf("&") == -1)
				/* 421 */reurl = reurl + "?" + req.getQueryString();
			else {
				/* 423 */reurl = reurl
						+ "?"
						+ req.getQueryString().substring(0,
								req.getQueryString().indexOf("&"));
			}
		}
		/* 426 */return reurl;
	}

	public static String dateToString(Date date, String formatStr) {
		SimpleDateFormat df = new SimpleDateFormat(formatStr);
		return df.format(date);
	}

	public static Date stringToDate(String str, String formatStr)
			throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat(formatStr);
		return df.parse(formatStr);
	}

	public static void main(String[] args) {
	}
}

/*
 * Location: C:\Users\asus\Desktop\sshFrame\WebContent\WEB-INF\classes\
 * Qualified Name: com.wrc.sshFrame.util.StringUtil JD-Core Version: 0.6.0
 */