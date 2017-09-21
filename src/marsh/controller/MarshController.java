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
		//popup.displayText(basic.toString());
		MarshyMonster jed = new MarshyMonster("Murr Bun Jed Monster", 2, 4, 0, true);
		//System.out.println(jed);
		popup.displayText(jed.toString());
		popup.displayText("I am feeling sadistic, I'm going to remove one of Jed's arms.");
		//System.out.println("I am feeling sadistic, I'm going to remove one of Jed's arms.");
		jed.setArmCount(jed.getArmCount() - 1);
		
		interactWithMonster(jed);
	}
	
	private void interactWithMonster(MarshyMonster currentMonster)
	{
		Scanner myScanner = new Scanner(System.in);
		
		//TAKING EYES
		//System.out.println(currentMonster.getName() + " wants to know why you are torturing it? How many eyes do you wish to take away for this disobedient speech?");
		int consumed = 0;
		String response = popup.getResponse(currentMonster.getName() + " wants to know why you are torturing it? How many eyes do you wish to take away for this disobedient speech?");
		
		if(isValidInteger(response))
		{
		consumed = Integer.parseInt(response);
		}
		//int consumed = myScanner.nextInt();
		
		if (consumed == 0)
		{
			popup.displayText("Sad, I thought you'd discipline your monster. ");
		}
		
		else if(consumed < 0)
		{
			popup.displayText("You can't remove eyes by not removing eyes.");
		}
		
		else if(consumed - currentMonster.getEyeCount() > 0)
		{
			popup.displayText("You think you are funny right? You can't remove that many eyes unless you were god and created more eyes.");
		}
		
		else
		{
			currentMonster.setEyeCount(currentMonster.getEyeCount() - consumed);
			popup.displayText("You are making the right choice. It now has, " + currentMonster.getEyeCount() + " eyes.");
		}
		//TAKING EYES
		
		
		//TAKING ARMS
		int armTake = 0;
		String response2 = popup.getResponse("How many arms are you actually interested in taking away from this disobedient monster?" + " He has " + currentMonster.getArmCount() + " arms.");
		// consumed = myScanner.nextint();
		
		if (isValidInteger(response2))
		{
		armTake = Integer.parseInt(response2);
		}
		//int armTake = myScanner.nextInt();
		
		if (armTake == 0)
		{
			popup.displayText("Not sadistic? Oh so sad.");
		}
		
		else if(armTake < 0)
		{
			popup.displayText("You can't take away arms by not taking arms you stupid dint.");
		}
		
		else if(armTake - currentMonster.getArmCount() > 0)
		{
			popup.displayText("You can't take more than that exists you stupid dint.");
		}
		
		else
		{
			currentMonster.setArmCount(currentMonster.getArmCount() - armTake);
			popup.displayText("I knew you wanted to rip that monster to shreds go ahead... YES YES!!!!!!! It now has, " + currentMonster.getArmCount() + " arms.");
		}
		//TAKING ARMS
		
		//TAKING TENTACLES
		
		double tentake = 0.0;
		
		String response3 = popup.getResponse("How many tentacles do you wish to rip off this monster? He has " + currentMonster.getTentacleAmount());
		
		//System.out.println("How many tentacles do you wish to rip off this monster? He has " + currentMonster.getTentacleAmount());
		//double tentake = myScanner.nextDouble();
		
		if(isValidDouble(response3))
		{
			tentake = Double.parseDouble(response3);
		}
		
		
		if (tentake == currentMonster.getTentacleAmount())
		{
			currentMonster.setTentacleAmount(currentMonster.getTentacleAmount() - tentake);
			popup.displayText("There goes all his tentacles. Nicely done.");
		}
		
		else if (tentake < 0)
		{
			popup.displayText("Seriously? You can't take away by not taking away.");
		}
		
		else if (tentake - currentMonster.getTentacleAmount() > 0)
		{
			popup.displayText("You can't take more than exists. Okay?");
		}
		
		else if (tentake == 0)
		{
			popup.displayText("I'm sorry it had to come to this.... non violence. I dislike you.");
		}
		
		else
		{
			currentMonster.setTentacleAmount(currentMonster.getTentacleAmount() - tentake);
			popup.displayText("Those were removed. Congrats!" + " He only has, " + currentMonster.getTentacleAmount() + " tentacles.");
		}
		
		//TAKING TENTACLES
		
		//popup.displayText("Hi there, ready to play god???");
		//String answer = popup.getResponse("What is the air speed of a cococnut laden swallow?");
		//popup.displayText(answer);
		
		myScanner.close();
	}
	
	private boolean isValidInteger(String sample)
	{
		boolean valid = false;
		
		try
		{
			Integer.parseInt(sample);
			valid = true;
		}
		catch(NumberFormatException error)
		{
			popup.displayText("You need to input an int, " + sample + " is not valid.");
		}
		return valid;
	}
	
	private boolean isValidDouble(String sample2)
	{
		boolean validation = false;
		
		try
		{
			Double.parseDouble(sample2);
			validation = true;
		}
		catch(NumberFormatException error)
		{
			popup.displayText("You need to input a double, " + sample2 + " is not valid.");
		}
		return validation;
	}
}
