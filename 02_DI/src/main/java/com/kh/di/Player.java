package com.kh.di;

import com.kh.dice.Dice;

import lombok.Data;


@Data
public class Player {
	private Dice dice;
	private int totalValue;
	
	public Player(Dice dice) {
		this.dice = dice;
	}
	
	// count 만큼 주사위를 굴려서 합을 매기는 메서드
	
	public void playDice(int count) {
		System.out.println("==>" + getClass().getName() + ".playDice() start~~");
		
		for(int i = 0; i < count; i++) {
			dice.selectedNumber();
			
			System.out.println("[" + dice.getClass().getName() + "] 의 선택된 수 : " + dice.getValue());
			
			totalValue += dice.getValue();
		}
		System.out.println("==>" + getClass().getName() + ".playeDice() end...");
	}
}
