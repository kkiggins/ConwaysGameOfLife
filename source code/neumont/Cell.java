//Conway's Game of Life
//Variant by: Kendrick Kiggins
//Introduction to Computer Science final project
//Instructor: Chase Dickerson
//Start date: 12/05/2012
//Finish date: 12/16/2012
//Cell class. Sets up each individual cell. changeState() will check if it's alive or dead, and then switch the state to the opposite.
//alive() makes the cell a living cell, and dead() makes it a dead one. checkState() returns the state of the cell.

package neumont;

import java.awt.*;
import javax.swing.*;

public class Cell extends JButton
{
	private boolean isAlive = false;
	boolean setAlive = false;
	
	public Cell(int width, int height)
	{
		setSize(new Dimension(width, height));
		dead();
		setAlive = false;
	}
	
	//Changes the state of the cell. If it's living, kill it, otherwise, make it living.
	public void changeState()
	{
		if(isAlive)
		{
			dead();
		}
		else
		{
			alive();
		}
	}
	
	//Makes a dead cell a living one.
	public void alive()
	{
		isAlive = true;
		setBackground(Color.BLACK);
	}
	
	//Makes a living cell a dead one.
	public void dead()
	{
		isAlive = false;
		setBackground(Color.WHITE);
	}
	
	//Returns whether or not the cell is alive.
	public boolean checkState()
	{
		return isAlive;
	}
	
	//Marks the cell for either death or birth.
	public void setState()
	{
		if(setAlive)
		{
			isAlive = true;
			setBackground(Color.BLACK);
		}
		else
		{
			isAlive = false;
			setBackground(Color.WHITE);
		}
					
	}
}
