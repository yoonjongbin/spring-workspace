package com.kh.di;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DiceTestApp1UsingSpring {

	public static void main(String[] args) {
		
//		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("src/main/resources/config/dice.xml"));
		
		// BeanFactory 의 하위 인터페이스
		ApplicationContext factory = new ClassPathXmlApplicationContext("src/main/resources/config/dice.xml");
		
//		Player player1 = (Player) factory.getBean("player1");
//		
//		player1.playDice(3);
//		
//		System.out.println("===================");
//		System.out.println("선택된 주사위 눈의 합 : " + player1.getTotalValue());
//		System.out.println("===================");
		
		
//		Player player2 = (Player) factory.getBean("player2");
//		
//		player2.playDice(3);
//		
//		System.out.println("===================");
//		System.out.println("선택된 주사위 눈의 합 : " + player2.getTotalValue());
//		System.out.println("===================");
		
		
		Player player3 = (Player) factory.getBean("player3");
		
		player3.playDice(3);
		
		System.out.println("===================");
		System.out.println("선택된 주사위 눈의 합 : " + player3.getTotalValue());
		System.out.println("===================");

	}

}
