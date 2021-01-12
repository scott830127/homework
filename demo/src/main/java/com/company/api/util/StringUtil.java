package com.company.api.util;

public class StringUtil {
	public boolean isNotEmpty(String value) {
		if (value != null && !"".equals(value)) {
			return true;
		} else {
			return false;
		}
	}

}
