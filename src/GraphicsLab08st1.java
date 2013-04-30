

import java.util.*;
import java.awt.*;
import java.applet.*;

public class GraphicsLab08st1 extends Applet
{

	private int numBars;	// number of bars to be sorted
	int barHeight[];		// array of bar heights
	int sortDelay;
	int count;             // delay between comparison iteration


	public void init()
	{
                setSize(1000,650);
		numBars = 47;
		sortDelay = 3000;
		barHeight = new int[numBars];
		getBarValues();
		count = 1;
	}


	public void getBarValues()
	{
		Random rand = new Random(3333); //generates a new random interger 
		for (int k = 0; k < numBars; k++)
			barHeight[k] = rand.nextInt(591) + 10;  // range of 10..600
	}


	public void paint(Graphics g)
	{
		showFrame(g);
		displayBars(g);
		sortBars(g);
		Expo.delay(sortDelay);
		showFrame(g);
		displayBars(g);
	}


	public void showFrame(Graphics g)
	{
		Expo.setColor(g,Expo.white);  //colors 
		Expo.fillRectangle(g,0,0,1000,650);
		Expo.setColor(g,Expo.black); //colors 
		Expo.fillRectangle(g,0,0,1000,15);  
		Expo.fillRectangle(g,0,0,15,650);
		Expo.fillRectangle(g,0,635,1000,650);
		Expo.fillRectangle(g,985,0,1000,650);
	}


	public void displayBars(Graphics g)
	{
		if (count == 1)
			Expo.setColor(g,Expo.red);   //determines if it matches red if so displays red if not shows blue
		else
			Expo.setColor(g,Expo.blue);
		int x = 25;
		int x2 = 35;
		int y = 635;

		for (int k=0; k<numBars; k++)
		{
			int y2 = 635 - barHeight[k];
			Expo.fillRectangle(g,x,y,x2,y2);
			x+=20;
			x2+=20;
		}
		count = 2;
		
		
	}


	public void sortBars(Graphics g) //swaps the bars so they are in the correct order
	{
		Expo.delay(sortDelay);
		for (int p = 1; p < numBars; p++)
			for (int k = 0; k < numBars-p ; k++)
			if (barHeight[k] > barHeight[k+1])
			swap(k,k+1); 
		}
	


  	private void swap(int x, int y) //completes the swap method
  	
  	{
  		int temp = barHeight [x];
  		barHeight [x] = barHeight [y];
  		barHeight [y] = temp;
  	
	}
}




