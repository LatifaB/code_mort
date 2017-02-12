package resources.sma.wator;

import java.awt.Color;
import java.util.Random;

import resources.sma.core.Environement;
import resources.sma.utils.Utils;

import javax.rmi.CORBA.Util;

public class Wator extends Environement {

	public Wator(){
		Random rdm = new Random();
		if(Utils.seed != 0){
			rdm.setSeed(Utils.seed);
		}
		int x,y;
		for(int i = 0; i < Utils.nbFishes; i++){
			x = rdm.nextInt(Utils.grideSizeX);
			y = rdm.nextInt(Utils.grideSizeY);
			while(this.map[x][y] != null){
				x = rdm.nextInt(Utils.grideSizeX);
				y = rdm.nextInt(Utils.grideSizeY);
			}
			map[x][y] = new Fish(x,y,this);
		}
		for(int i = 0; i < Utils.nbSharks; i++){
			x = rdm.nextInt(Utils.grideSizeX);
			y = rdm.nextInt(Utils.grideSizeY);
			while(this.map[x][y] != null){
				x = rdm.nextInt(Utils.grideSizeX);
				y = rdm.nextInt(Utils.grideSizeY);
			}
			map[x][y] = new SharkUn(x,y,this);
		}
	}
	
	public Color[][] getColor() {
		Color[][] res = new Color[Utils.grideSizeX][Utils.grideSizeY];
		for(int i = 0; i < Utils.grideSizeX; i++ ){
			for(int j = 0; j < Utils.grideSizeY; j++){
				if(map[i][j] != null){
					res[i][j] = ((MarinCreature) map[i][j]).getColor();
				}else{
					res[i][j] = Color.cyan;
				}
			}
		}
		return res;
	}

	@Override
	public void decideAll() {
		super.decideAll();
		Utils.nbFishes = 0;
		Utils.nbSharks = 0;
		for(int i = 0; i < Utils.grideSizeX; i++){
			for(int j = 0; j < Utils.grideSizeY; j++){
				if(map[i][j] != null && !map[i][j].isMoved()){
					((MarinCreature) map[i][j]).count();
				}
			}
		}
		if(Utils.showTrace()) {
			System.out.print(Utils.nbFishes + ";" + Utils.nbSharks + ";");
		}
	}
}
