package com.lhk.utils;

import java.util.Random;

public class GenerateId {
	private static final String alpha = "abcdefghijklmnopqrstuvwxyz"; // a-z
    private static final String alphaUpperCase = alpha.toUpperCase(); // A-Z
    private static final String digits = "0123456789"; // 0-9
    private static final String ALPHA_NUMERIC = alpha + alphaUpperCase + digits;
    
    private static Random generator = new Random();
	
    private static int randomNumber(int min, int max) {
        return generator.nextInt((max - min) + 1) + min;
    }
    
    private static String generate(String id) {
		StringBuilder sb = new StringBuilder();
		String idString = id;
		for (int i = 0; i < 5; i++) {
            int number = randomNumber(0, ALPHA_NUMERIC.length() - 1);
            char ch = ALPHA_NUMERIC.charAt(number);
            sb.append(ch);
        }
		return idString + sb.toString();
	}
    
    public static String generateId(String id) {
    	if(id == "ORD") {
    		return generate(id);
    	}
    	else if(id == "OD") {
    		return generate(id);
    	}
    	else if (id == "CA") {
			return generate(id);
		}
    	else if (id == "PR") {
			return generate(id);
		}
    	else if (id == "ACC") {
			return generate(id);
		}
    	else if (id == "CU") {
			return generate(id);
		}
    	else {
			return generate(id);
		}
    }
}
