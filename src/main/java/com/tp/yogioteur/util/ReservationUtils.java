package com.tp.yogioteur.util;

public class ReservationUtils {
	
	// 예약번호
	public static String reservataionCode(int length) {
		// 문자   아스키코드값
		// '0'    48
		// '1'    49
		// ...
		// 'A'    65
		// 'B'    66
		// ...
		// 'a'    97
		// 'b'    98
		// ...
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < length; i++) {
			if(Math.random() < 0.5) {
				sb.append( (char)((int)(Math.random() * 10) + '0') );
			} else {
				sb.append( (char)((int)(Math.random() * 26) + 'A') );
			}
		}
		return sb.toString();
	}
	
	
}
