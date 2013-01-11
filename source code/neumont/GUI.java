//Conway's Game of Life
//Variant by: Kendrick Kiggins
//Introduction to Computer Science final project
//Instructor: Chase Dickerson
//Start date: 12/05/2012
//Finish date: 12/16/2012
//GUI class. Sets up the GUI. When run() is called will check if any of the elements in panel's cellGrid needs to change state.

package neumont;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI extends JFrame
{
	private JButton stepButton;
	
	CellPanel panel;
	
	public boolean isRunning = false;
	
	public GUI()
	{
		//Creates the GUI settings.
		super("Conway's Game of Life: Consul Edition");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		//Adds the grid of Cells to the GUI.
		panel = new CellPanel(getWidth(), getHeight());
		add(panel, BorderLayout.CENTER);
		
		//Creates the start and stop button, which will pause and resume the program.
		stepButton = new JButton("Step");
		stepButton.setSize(new Dimension(50,10));
		stepButton.addActionListener(new ActionListener()
		{
			
			//if the step button is clicked, run a generation
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				run();
			}
			
		});
		//add the step button
		add(stepButton, BorderLayout.SOUTH);
		setSize(500, 600);
	}
	
	//checks each cell's neighbors and then changes their state to either living or dead
	public void run()
	{
		//for each of the cells in the grid
		for(int i = 0; i < 50; i++)
		{
			for(int j = 0; j < 50; j++)
			{
				//check the neighbors
				panel.checkNumNeighbors(i, j);
			}
		}
		
		//for each of the cells in the grid
		for(int i = 0; i < 50; i++)
		{
			for(int j = 0; j < 50; j++)
			{
				//set the state
				panel.grid[i][j].setState();
			}
		}
	}
	
}
