package marsh.model;

public class MarshyMonster
{
	//Declaration section of data members
	
	private String name;
	private int eyeCount;
	private int armCount;
	private double tentacleAmount;
	private boolean hasBloop;
	
	public MarshyMonster()
	{
		//initializes everything to 0, false or null.
		

	}
	
	// Basically sets up things by putting the variables into the local variables.
	public MarshyMonster(String name, int eyeCount, int arms, int tentacleCount, boolean hasBloop)
	{
		this.name = name;
		this.eyeCount = eyeCount;
		this.armCount = arms;
		this.tentacleAmount = tentacleCount;
		this.hasBloop = hasBloop;
		
		
	}
	
	// This is basically the monster description, it also has a if statement because of the true and false boolean contained within hasBloop.
	
	public String toString()
	{
		// I am bad at french, this may or may not be accurate. 
		
		if (hasBloop == false)
		{
			String description = "Je suis un monstre, j'm'appelle " + name + ", j'ai " + eyeCount + " des yeux et ";
			description += tentacleAmount + " des tentacules, mais j'ai " + armCount + " des bras! C'est " + hasBloop + ", je n'ai pas un bl00p et";
			description += " il fait pressentir des trucs."; 
			
			return description; 
		}
		else
		{
			String description = "Je suis un monstre, j'm'appelle " + name + ", j'ai " + eyeCount + " des yeux et ";
			description += tentacleAmount + " des tentacules, mais j'ai " + armCount + " des bras! C'est " + hasBloop + ", j'ai un bl00p et";
			description += " il fait pressentir des trucs."; 
			
			return description; 
		}		
	}
	
	//These are setters and getters for each monster part. They make it easier and more safe for data transfer.
	
	public String getName()
	{
		return name;
	}
	
	public int getEyeCount()
	{
		return eyeCount;
	}
	
	public int getArmCount()
	{
		return armCount;
	}
	
	public double getTentacleAmount()
	{
		return tentacleAmount;
	}
	
	public boolean hasBloop()
	{
		return hasBloop;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setEyeCount(int eyeCount)
	{
		this.eyeCount = eyeCount;
	}
	
	public void setArmCount(int armCount)
	{
		this.armCount = armCount;
	}
	
	public void setTentacleAmount(double tentacleAmount)
	{
		this.tentacleAmount = tentacleAmount;
	}
	
	public void setBloop(boolean hasBloop)
	{
		this.hasBloop = hasBloop;
	}
}
