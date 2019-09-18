package com.xq.util;

import java.util.UUID;

public class UUIDUtils {

	private UUIDUtils(){}
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
