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
	
	// Where it starts out and makes a monster Jed out of a constructor. It also removes an arm just to start off.
	public void start()
	{
		//int display = 7 % 3;
		//int count = 0;
		/*while(count < 10)
		{
			popup.displayText(display);
			count++;
		}*/
		
		/*for (count = 0; count < 10; count += 1)
		{
			popup.displayText("This is loop # " + (count + 1) + " of ten."); 
		}*/
		
		
		//MarshyMonster basic = new MarshyMonster();
		//System.out.println(basic);
		//popup.displayText(basic.toString());
		MarshyMonster jed = new MarshyMonster("Murr Bun Jed Monster", 2, 4, 0, true);
		//System.out.println(jed);
		popup.displayText(jed.toString());
		popup.displayText("You are feeling sadistic? Remove one of Jed's arms.");
		//System.out.println("I am feeling sadistic, I'm going to remove one of Jed's arms.");
		jed.setArmCount(jed.getArmCount() - 1);
		
		interactWithMonster(jed);
	}
	
	
	// This massive waste of text starts removing eyes, arms, and tentacles based on input from the user.
	private void interactWithMonster(MarshyMonster currentMonster)
	{
		Scanner myScanner = new Scanner(System.in);
		
		//TAKING EYES
		//System.out.println(currentMonster.getName() + " wants to know why you are torturing it? How many eyes do you wish to take away for this disobedient speech?");
		int consumed = 0;
		String responseEyes = popup.getResponse(currentMonster.getName() + " wants to know why you are torturing it? How many eyes do you wish to take away for this disobedient speech?");
		
		while(!isValidInteger(responseEyes))
		{
			popup.displayText("You think this is funny?");
			responseEyes = popup.getResponse("Hand to me an answer to that I actually understand which is an integer.");
		}
		
		consumed = Integer.parseInt(responseEyes);
		
		/*if(isValidInteger(responseEyes))
		{
		consumed = Integer.parseInt(responseEyes);
		}*/
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
		String responseArm = popup.getResponse("How many arms are you actually interested in taking away from this disobedient monster?" + " He has " + currentMonster.getArmCount() + " arms.");
		// consumed = myScanner.nextint();
		
		while(!isValidInteger(responseArm))
		{
			popup.displayText("I bet you are having a laugh.");
			responseArm = popup.getResponse("Quit messing around and give me an answer that is an integer.");
		}
		
		armTake = Integer.parseInt(responseArm);
		
		/*if (isValidInteger(responseArm))
		{
		armTake = Integer.parseInt(responseArm);
		}*/
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
		
		String responseTent = popup.getResponse("How many tentacles do you wish to rip off this monster? He has " + currentMonster.getTentacleAmount());
		
		//System.out.println("How many tentacles do you wish to rip off this monster? He has " + currentMonster.getTentacleAmount());
		//double tentake = myScanner.nextDouble();
		
		while(!isValidDouble(responseTent))
		{
			popup.displayText("You know you want this monster to suffer. Why do you resist with poor answers?");
			responseTent = popup.getResponse("Give me a correct answer, I need a double value.");
		}
		
		tentake = Double.parseDouble(responseTent);
		
		/*if(isValidDouble(responseTent))
		{
			tentake = Double.parseDouble(responseTent);
		}*/
		
		
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
	
	// These are guard/protection against wrong input. They are basically validation helpers. 
	private boolean isValidInteger(String sampleInt)
	{
		boolean valid = false;
		
		try
		{
			Integer.parseInt(sampleInt);
			valid = true;
		}
		catch(NumberFormatException error)
		{
			popup.displayText("You need to input an int, " + sampleInt + " is not valid.");
		}
		return valid;
	}
	
	private boolean isValidDouble(String sampleDoub)
	{
		boolean validation = false;
		
		try
		{
			Double.parseDouble(sampleDoub);
			validation = true;
		}
		catch(NumberFormatException error)
		{
			popup.displayText("You need to input a double, " + sampleDoub + " is not valid.");
		}
		return validation;
	}
	
	/*private boolean isValidBoolean(String sampBool)
	{
		
	boolean valid = false;
	
	try
	{
		Boolean.parseBoolean(sampBool);
		valid = true;
	}
	catch(NumberFormatException error)
	{
		popup.displayText("Type in a boolean value, " + sampBool + " does not work.");
	}
	
	return valid;
	}
    */
}
