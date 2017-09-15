package marsh.controller;

import marsh.model.MarshyMonster;

public class MarshController
{
	public void start()
	{
		MarshyMonster basic = new MarshyMonster();
		System.out.println(basic);
		MarshyMonster jed = new MarshyMonster("Murr Bun Jed Monster", 2, 0, 4, true);
		System.out.println(jed);
		
		System.out.println("I am feeling sadistic, I'm going to remove one of Jed's arms.");
		jed.setArmCount(jed.getArmCount() - 1);
		System.out.println(jed);
	}
}
