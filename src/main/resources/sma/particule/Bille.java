package resources.sma.particule;

import resources.sma.core.Agent;
import resources.sma.utils.Utils;

import java.util.Random;

public class Bille extends Agent{

	protected int pasX;
	protected int pasY;

	public Bille(int x, int y, Surface surface){
		super(x,y,surface);
		Random rdm = new Random();

		int[] pas = {1,-1};
		if(Utils.seed != 0){
			rdm.setSeed(Utils.seed);
		}
		this.pasX = pas[rdm.nextInt(2)];
		this.pasY = pas[rdm.nextInt(2)];

	}
	
	public void decide(){
		this.isMoved = true;

		// detecion du bord seulement si c'est pas thorique
		int i = this.x + this.pasX;
		int j = this.y + this.pasY;

		if(!Utils.isThorique()){
			if((i == (-1)) || (i == Utils.grideSizeX)){
				this.pasX = this.pasX * (-1);
				this.changementDeDirection = true;
			}
			if((j == (-1)) || (j == Utils.grideSizeY)){
				this.pasY = this.pasY * (-1);
				this.changementDeDirection = true;
			}
			i = this.x + this.pasX;
			j = this.y + this.pasY;
		}
		
		//detection de la collision
		if(Utils.isThorique()){
			i = (i + Utils.grideSizeX) % Utils.grideSizeX;
			j = (j + Utils.grideSizeY) % Utils.grideSizeY;
		}
		if(environement.getAgent(i, j) != null){
			echange( (Bille) environement.getAgent(i, j));
		}else{
			update();
		}

		if(changementDeDirection == true){
			System.out.println("Agent;");
			changementDeDirection = false;
		}
	}


	private void echange(Bille agent){
		int aux = agent.getPasX();
		agent.setPasX(this.pasX);
		this.pasX = aux;
		aux = agent.getPasY();
		agent.setPasY(this.pasY);
		this.pasY = aux;
		this.changementDeDirection = true;
	}

	public void update(){
		int i = this.x + this.pasX;
		int j = this.y + this.pasY;
		if(Utils.isThorique()){
			i = ( i + Utils.grideSizeX) % Utils.grideSizeX;
			j = ( j + Utils.grideSizeY) % Utils.grideSizeY;
		}
		environement.setAgent(this.x, this.y, null);
		this.x = i;
		this.y = j;
		environement.setAgent(i, j, this);
	}

	private void setPasY(int pasY2) {
		this.pasY = pasY2;
	}

	private int getPasY() {
		return this.pasY;
	}

	private void setPasX(int pasX2) {
		this.pasX = pasX2;
	}

	private int getPasX() {
		return this.pasX;
	}

}
