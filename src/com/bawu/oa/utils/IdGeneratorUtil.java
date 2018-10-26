package com.bawu.oa.utils;

import java.util.UUID;

public class IdGeneratorUtil {

	
	//uuid
	public static String generatorId() {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		long currentTimeMillis = System.currentTimeMillis();
		String id = uuid.substring(0, 6)+currentTimeMillis;
		return id;
	}
	
	
	public static void main(String[] args) {
		String generatorId = generatorId();
		System.out.println(generatorId);
	}
	
}
