package resources.sma.particule;

import java.awt.Color;
import java.util.Random;

import resources.sma.core.Environement;
import resources.sma.utils.Utils;

public class Surface extends Environement{
	
	public Surface(){
		super();
		
		Random rdm = new Random();
		if(Utils.seed != 0){
			rdm.setSeed(Utils.seed);
		}
		int x,y;
		for(int i = 0; i < Utils.nbParticules; i++){
			x = rdm.nextInt(Utils.grideSizeX);
			y = rdm.nextInt(Utils.grideSizeY);
			while(this.map[x][y] != null){
				x = rdm.nextInt(Utils.grideSizeX);
				y = rdm.nextInt(Utils.grideSizeY);
			}
			map[x][y] = new Bille(x,y,this);
		}
	}

	public Color[][] getColor(){
		Color[][] res = new Color[Utils.grideSizeX][Utils.grideSizeY];
		for(int i = 0; i < Utils.grideSizeX; i++ ){
			for(int j = 0; j < Utils.grideSizeY; j++){
				if(map[i][j] != null){
					res[i][j] = ((Bille) map[i][j]).getColor();
				}else{
					res[i][j] = null;
				}
			}
		}
		return res;
	}
}
