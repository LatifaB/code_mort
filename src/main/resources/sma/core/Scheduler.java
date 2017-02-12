package resources.sma.core;

import java.awt.Color;
import java.util.Observable;

import resources.sma.particule.Surface;
import resources.sma.utils.Utils;


public abstract class Scheduler extends Observable{

	protected Environement environement;
	
	public void run(){
		setChanged();
		notifyObservers();
		if(Utils.isInfinity()){
			while(true){
				try {
					environement.decideAll();
					setChanged();
					notifyObservers();
					Thread.sleep(Utils.delay);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}else{
			for(int i = 0; i < Utils.nbTricks;i++){
				try {
					environement.decideAll();
					setChanged();
					notifyObservers();
					Thread.sleep(Utils.delay);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public Color[][] getMap(){
		return  environement.getColor();
	}
	
}
