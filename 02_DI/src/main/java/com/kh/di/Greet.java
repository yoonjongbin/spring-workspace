package com.kh.di;

import lombok.Getter;
import lombok.Setter;


// 속성이 여러 개이면 외부에 선언
@Setter
@Getter
public class Greet {
	// 하나면 내부에 선언가능
//	@Setter
//	@Getter
	
	private String message;
	
	public Greet() {
		System.out.println(getClass().getName() + "...Instance Create...");
	}
	
	public Greet(String message) {
		this.message = message;
	}
	
	public void printMessage() {
		System.out.println(getClass().getName() + "=>" + message);
	}
}
