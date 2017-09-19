package marsh.controller;

import marsh.model.MarshyMonster;
import java.util.Scanner;
import marsh.view.MarshDisplay;

public class MarshController
{
	
	private MarshDisplay popup;
	
	public MarshController()
	{
		popup = new MarshDisplay();
	}
	
	public void start()
	{
		//MarshyMonster basic = new MarshyMonster();
		//System.out.println(basic);
		MarshyMonster jed = new MarshyMonster("Murr Bun Jed Monster", 2, 4, 0, true);
		System.out.println(jed);
		
		System.out.println("I am feeling sadistic, I'm going to remove one of Jed's arms.");
		jed.setArmCount(jed.getArmCount() - 1);
		
		interactWithMonster(jed);
	}
	
	private void interactWithMonster(MarshyMonster currentMonster)
	{
		Scanner myScanner = new Scanner(System.in);
		
		//TAKING EYES
		System.out.println(currentMonster.getName() + " wants to know why you are torturing it? How many eyes do you wish to take away for this disobedient speech?");
		int consumed = myScanner.nextInt();
		
		if (consumed == 0)
		{
			System.out.println("Sad, I thought you'd discipline your monster. ");
		}
		
		else if(consumed < 0)
		{
			System.out.println("You can't remove eyes by not removing eyes.");
		}
		
		else if(consumed - currentMonster.getEyeCount() > 0)
		{
			System.out.println("You think you are funny right? You can't remove that many eyes unless you were god and created more eyes.");
		}
		
		else
		{
			currentMonster.setEyeCount(currentMonster.getEyeCount() - consumed);
			System.out.println("You are making the right choice. It now has, " + currentMonster.getEyeCount() + " eyes.");
		}
		//TAKING EYES
		
		
		//TAKING ARMS
		System.out.println("How many arms are you actually interested in taking away from this disobedient monster?" + " He has " + currentMonster.getArmCount() + " arms.");
		// consumed = myScanner.nextint();
		
		int armTake = myScanner.nextInt();
		
		if (armTake == 0)
		{
			System.out.println("Not sadistic? Oh so sad.");
		}
		
		else if(armTake < 0)
		{
			System.out.println("You can't take away arms by not taking arms you stupid dint.");
		}
		
		else if(armTake - currentMonster.getArmCount() > 0)
		{
			System.out.println("You can't take more than that exists you stupid dint.");
		}
		
		else
		{
			currentMonster.setArmCount(currentMonster.getArmCount() - armTake);
			System.out.println("I knew you wanted to rip that monster to shreds go ahead... YES YES!!!!!!! It now has, " + currentMonster.getArmCount() + " arms.");
		}
		//TAKING ARMS
		
		//TAKING TENTACLES
		
		System.out.println("How many tentacles do you wish to rip off this monster? He has " + currentMonster.getTentacleAmount());
		double tentake = myScanner.nextDouble();
		
		if (tentake == currentMonster.getTentacleAmount())
		{
			currentMonster.setTentacleAmount(currentMonster.getTentacleAmount() - tentake);
			System.out.println("There goes all his tentacles. Nicely done.");
		}
		
		else if (tentake < 0)
		{
			System.out.println("Seriously? You can't take away by not taking away.");
		}
		
		else if (tentake - currentMonster.getTentacleAmount() > 0)
		{
			System.out.println("You can't take more than exists. Okay?");
		}
		
		else if (tentake == 0)
		{
			System.out.println("I'm sorry it had to come to this.... non violence. I dislike you.");
		}
		
		else
		{
			currentMonster.setTentacleAmount(currentMonster.getTentacleAmount() - tentake);
			System.out.println("Those were removed. Congrats!" + " He only has, " + currentMonster.getTentacleAmount() + " tentacles.");
		}
		
		popup.displayText("Hi there, ready to play god???");
		String answer = popup.getResponse("What is the air speed of a cococnut laden swallow?");
		System.out.println(answer);
		
		myScanner.close();
	}
}
