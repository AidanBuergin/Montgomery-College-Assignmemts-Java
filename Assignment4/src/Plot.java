/*
 * Class: CMSC203 
 * Instructor: Eivazi
 * Description: The plot of land that a property takes up.
 * Due: 7/17/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: _Aidan Buergin_________
*/

public class Plot {

	private int x;
	private int y;
	private int depth;
	private int width;
	
	/**
	 *@summary constructor with no args.
	 */
	public Plot() {
		x=0;
		y=0;
		width =1;
		depth=1;
	}

	/**
	 * @summary constructor with all args.
	 * @param x
	 * @param y
	 * @param depth
	 * @param width
	 */
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.depth = depth;
		this.width = width;
	}

	/**
	 * @summary constructor that takes another plot as an arg.
	 * @param plot
	 */
	public Plot(Plot plot) {
		this.x = plot.x;
		this.y = plot.y;
		this.depth = plot.depth;
		this.width = plot.width;
	}

	/**
	 * @summary getter for x.
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @summary setter for x.
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @summary getter for y.
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @summary setter for y.
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @summary getter for depth.
	 * @return the depth
	 */
	public int getDepth() {
		return depth;
	}

	/**
	 * @summary setter for depth.
	 * @param depth the depth to set
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}

	/**
	 * @summary getter for width.
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @summary setter for width.
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * @summary checks if an argument plot is within this plot by way of math.
	 * @param plot
	 * @return whether argument plot is entirely within this plot.
	 */
	
	public boolean encompasses(Plot plot) {
		
		//these three nested if statements are tests that are only all passed
		//when the argument string is entirely contained inside this plot.
		
		if((plot.x >= this.x)
				&& (plot.y >= this.y)) {
			
			if((plot.x + plot.width) <= (this.x + this.width)){
				
				if((this.y + this.depth) >= (plot.y + plot.depth)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * @summary this method determines if the arg plot and this plot overlap.
	 * @param plot
	 * @return whether argument plot and this plot overlap.
	 */
	
	public boolean overlaps(Plot plot) {
		
		//only if all four of the conditions are met, can two plots be overlapping
		
		if(plot.x < (this.x + this.width)) {
			
			if(this.x < plot.x + plot.width) {
				
				if(plot.y < this.y + this.depth) {
					
					if(this.y < plot.y + plot.depth) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	/**
	 * @summary returns a string of all fields for the plot.
	 */

	@Override
	public String toString() {
		return x + "," + y + "," + width + "," + depth;
	}
	
	
	
	
	
	
	
	
	
	
	
	//Author: Aidan Buergin
	
}
