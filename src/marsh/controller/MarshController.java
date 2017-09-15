package marsh.controller;

import marsh.model.MarshyMonster;
import java.util.Scanner;

public class MarshController
{
	public void start()
	{
		//MarshyMonster basic = new MarshyMonster();
		//System.out.println(basic);
		MarshyMonster jed = new MarshyMonster("Murr Bun Jed Monster", 2, 4, 0, true);
		System.out.println(jed);
		
		System.out.println("I am feeling sadistic, I'm going to remove one of Jed's arms.");
		jed.setArmCount(jed.getArmCount() - 1);
		System.out.println(jed);
		
		interactWithMonster(jed);
	}
	
	private void interactWithMonster(MarshyMonster currentMonster)
	{
		Scanner myScanner = new Scanner(System.in);
		System.out.println(currentMonster.getName() + " wants to know why you are torturing it? How many eyes do you wish to take away for this disobedient speech?");
		int consumed = myScanner.nextInt();
		currentMonster.setEyeCount(currentMonster.getEyeCount() - consumed);
		System.out.println(currentMonster);
		
		myScanner.close();
	}
}
