package com.wrc.ziyo.util;

public class DictUtil {

	public static String getCplx(int value) {
		if (value == 1) {
			return "国产";
		} else {
			return "进口";
		}
	}
}
