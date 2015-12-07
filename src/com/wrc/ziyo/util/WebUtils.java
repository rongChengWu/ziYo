package com.wrc.ziyo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class WebUtils {
	public static final String getParam(HttpServletRequest request,
			String name, String defval) {
		String param = request.getParameter(name);
		String value = defval;
		if (param != null) {
			value = param.trim();
		}
		return value;
	}

	public static final int getParam(HttpServletRequest request, String name,
			int defval) {
		String param = request.getParameter(name);
		int value = defval;
		if (param != null) {
			try {
				value = Integer.parseInt(param);
			} catch (NumberFormatException ignore) {
			}
		}
		return value;
	}

	public static final long getParam(HttpServletRequest request, String name,
			long defval) {
		String param = request.getParameter(name);
		long value = defval;
		if (param != null) {
			try {
				value = Long.parseLong(param);
			} catch (NumberFormatException ignore) {
			}
		}
		return value;
	}

	public static final Float getParambyFloat(HttpServletRequest request,
			String name, float defval) {
		String param = request.getParameter(name);
		float value = defval;
		if (param != null) {
			try {
				value = Float.parseFloat(param);
			} catch (NumberFormatException ignore) {
			}
		}
		return value;
	}

	public static final float getParambyFloatBasic(HttpServletRequest request,
			String name, float defval) {
		String param = request.getParameter(name);
		float value = defval;
		if (param != null) {
			try {
				value = Float.parseFloat(param);
			} catch (NumberFormatException ignore) {
			}
		}
		return value;
	}

	public static final String[] getParamValues(HttpServletRequest request,
			String name, String defval) {
		String strArray[] = null;
		strArray = request.getParameterValues(name);
		if (strArray != null && strArray.length > 0) {
			for (int i = 0; i < strArray.length; i++) {
				if (strArray[i] != null) {
					strArray[i] = strArray[i].trim();
				} else {
					strArray[i] = "";
				}
			}
		}
		return strArray;
	}

	/**
	 * 获取 Date
	 * 
	 * @param request
	 * @param name
	 * @param defval
	 *            默认值
	 * @param formatStr
	 *            表达式 ‘yyyy-MM-dd’
	 * @return
	 */
	public static final Date getParambyDate(HttpServletRequest request,
			String name, Date defval, String formatStr) {
		SimpleDateFormat df = new SimpleDateFormat(formatStr);
		String param = request.getParameter(name);
		Date value = defval;
		if (param != null) {
			try {
				value = df.parse(param);
			} catch (NumberFormatException ignore) {
			} catch (ParseException e) {
			}
		}
		return value;
	}

}
