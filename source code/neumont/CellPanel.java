//Conway's Game of Life
//Variant by: Kendrick Kiggins
//Introduction to Computer Science final project
//Instructor: Chase Dickerson
//Start date: 12/05/2012
//Finish date: 12/16/2012
//CellPanel class. Sets up the panel that the grid of cells will be displayed on. When checkNumNeighbors() is called, will run through all of the elements in
//grid and check if any of them need to change state.

package neumont;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CellPanel extends JPanel
{
	Cell[][] grid;
	
	//The size of the grid of cells
	final int ROW_SIZE = 50;
	final int COLUMN_SIZE = 50;
	
	public CellPanel(int width, int height)
	{
		//Creates the panel that holds the cell grid
		setSize(width, height);
		setLayout(new GridLayout(ROW_SIZE, COLUMN_SIZE));
		setVisible(true);
		
		grid = new Cell[ROW_SIZE][ROW_SIZE];
		
		//Populates the grid with cells
		for(int i = 0; i < ROW_SIZE; i++)
		{
			for(int j = 0; j < COLUMN_SIZE; j++)
			{
				final int R = i;
				final int C = j;
				
				grid[i][j] = new Cell(getWidth() / ROW_SIZE, getWidth() / COLUMN_SIZE);
				add(grid[i][j]);
				grid[i][j].addActionListener
				(
						new ActionListener() 
						{
							//if the cell is clicked, change its state.
							@Override
							public void actionPerformed(ActionEvent action) 
							{
								grid[R][C].changeState();
							}
							
						}
				);
			}
		}
	}
	
	//Checks each cells neighbors and then marks them for state change if needed.
	public void checkNumNeighbors(int row, int col)
	{
		int numNeighbors = 0;
		
		//For the eight cells surrounding the cell, and the cell itself
		for(int r = -1; r <= 1; r++)
		{
			for(int c = -1; c <= 1; c++)
			{
				int r2 = row + r;
				int c2 = col + c;
				
				if (r2 >= 0 && r2 < ROW_SIZE && c2 >= 0 && c2 < COLUMN_SIZE)
				{
					if (!(r2 == row && c2 == col))
					{
						//If the given neighbor is alive, add one to numNeighbors
						if(grid[r2][c2].checkState())
						{
							numNeighbors++;
						}
					}					
				}
			}
		}
		
		//if a living cell has more than three neighbors, or less than two, mark that cell for death
		if(numNeighbors > 3 || numNeighbors < 2)
		{
			grid[row][col].setAlive = false;
		}
		//if a dead cell has exactly three neighbors, mark it for birth
		else if(numNeighbors == 3)
		{
			grid[row][col].setAlive = true;
		}
		//otherwise, mark the cell for continued life.
		else 
		{
			grid[row][col].setAlive = grid[row][col].checkState();
		}
	}
}
