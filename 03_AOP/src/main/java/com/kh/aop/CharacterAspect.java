package com.kh.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

// 일반적인 자바 클래스가 아니라 애스팩트임을 나타낸다.
@Aspect
public class CharacterAspect {
	
	/*
	 * * 포인트 컷 표현식
	 * 	execution([수식어] 리턴타입 [클래스이름].이름(파라미터))
	 * 
	 * 	- 수식어 : public, private 등 수식어를 명시 (생략가능)
	 * 	- 리턴타입 : 리턴 타입을 명시
	 * 	- 클래스 이름 및 이름 : 클래스 이름과 메소드 이름을 명시(클래스 이름은 풀패키지명으로 명시, 생략가능)
	 * 	- 파라미터 : 메소드의 파라미터를 명시
	 * 	- "*" : 모든 값을 표현
	 * 	- ".." : 0개 이상을 의미
	 * 
	 * */
	
	@Pointcut("execution(* com.kh.character.Character.quest(..))")
	public void questPointcut() {}
	
	@Before(value="questPointcut()")
	public void beforeQuest(JoinPoint jp) {
		// 퀘스트를 수행하기 전에 필요한 부가 작업들 수행
		String questName = (String) jp.getArgs()[0];
		
		System.out.println(questName + " 퀘스트 준비 중...");
	}
	
	
	@After("execution(* com.kh.character.Character.quest(..))")
	public void afterQuest() {
		System.out.println("퀘스트 수행 완료....");
	}
	
	@Around("execution(* com.kh.character.Weapon.attack())")
	public String attackAdviced(ProceedingJoinPoint jp) {
		String result = null;
		
		System.out.println("공격을 준비 중 입니다...");
		try {
			result = (String) jp.proceed();
			System.out.println(result);
			System.out.println("공격을 성공했습니다...");
		} catch (Throwable e) {
			System.out.println("에러가 발생하였습니다. 사유 : " + e.getMessage());
		}
		
		return result;
	}
}
