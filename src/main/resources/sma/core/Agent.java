package resources.sma.core;

import resources.sma.utils.Utils;

import java.awt.*;
import java.util.Random;

public abstract class Agent {
	protected int x;
	protected int y;
	protected boolean isMoved;
	protected Environement environement;
	protected boolean changementDeDirection = false;
	protected Color color;

	public Agent(int x, int y, Environement environement){
		this.x = x;
		this.y = y;
		this.isMoved = false;
		this.environement = environement;

		Color[] colorList = {Color.black,Color.blue,Color.cyan,Color.darkGray,Color.green,Color.magenta,Color.orange, Color.pink,Color.red,Color.yellow};
		Random rdm = new Random();
		if(Utils.seed != 0){
			rdm.setSeed(Utils.seed);
		}
		this.color = colorList[rdm.nextInt(10)];
		
	}
	
	public boolean isMoved(){
		return this.isMoved;
	}
	
	public void resetMoved(){
		this.isMoved = false;
	}

	public abstract void update();

	public abstract void decide();

	public Color getColor(){
		return this.color;
	}
}
