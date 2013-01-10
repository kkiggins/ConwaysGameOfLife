Conway's Game of Life is a cellular automaton originally developed by John Horton Conway in 1970.
The game is actually more of a simulator, with little interaction by the "player".
The "setting" is a grid of squares, with each square either being white or black, white representing a dead cell, black representing a living cell.
Each cycle consists of each cell calculating whether it is going to be born, die, continue living, or stay dead, based on these rules:
	1: Any live cell with fewer than two live neighbours dies, as if caused by under-population.
	2: Any live cell with two or three live neighbours lives on to the next generation.
	3: Any live cell with more than three live neighbours dies, as if by overcrowding.
	4: Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

Conway (and others since him) found some "shapes" that caused interesting patterns or actions to occur. 
To find some of these, you can just search for "Conway's Game of Life Patterns" (or something similar) or go here: 
	http://en.wikipedia.org/wiki/Conway's_Game_of_Life#Examples_of_patterns

This version of the Game of Life was made as the final project in Kendrick Kiggins's Introduction to Computer Science class at Neumont University in December 2012.


Instructions:
Click on a square to change its state between "living" and "dead".
Click the "Step" button to cycle through one iteration of calculations.
