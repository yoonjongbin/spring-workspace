package com.kh.di;

public class HelloTestApp2 {

	public static void main(String[] args) {
		// 1. 사용할 Bean 정보를 갖는 hello.properties를 parsing
		//	  Bean(Component) 객체를 생성할 HelloFactory 객체 생성
		
		HelloFactory hf = HelloFactory.getInstance();
		
		// 2. hf 객체로 parsing 할 resource 전달
		
		hf.setConfigResource("src/main/resources/config/hello.properties");
		
		// 3. hf 객체로부터 instance.one 이름을 갖는 Hello 객체 요청
		Hello h = hf.getBean("instance.one");
		
		// 4. printMessage() 호출
		h.printMessage();
	}

}
