package resources.sma.wator;

import resources.sma.utils.Direction;
import resources.sma.utils.Pair;
import resources.sma.utils.Utils;

import java.awt.*;

public class Fish extends MarinCreature{

	public Fish(int x, int y, Wator water) {
		super(x, y, water);
		this.color = Color.green;
		this.adultColor = Color.blue;
		this.age = 0;
	}


	@Override
	public void update() {
	}

	@Override
	public void count() {
		Utils.nbFishes++;
	}

	@Override
	public void decide() {
		this.age++;
		if(this.age == 1){
			this.color = this.adultColor;
		}
		int nextX, nextY;
		Pair temporaire = null;
		Direction dir = new Direction();
		Pair direction = dir.nextDirection();
		temporaire = direction;
		nextX = this.x + direction.first();
		nextY = this.y + direction.second();
		if(Utils.isThorique()){
			int[] tab = Utils.modulo(nextX,nextY);
			nextX = tab[0];
			nextY = tab[1];
		}
		while(!this.isEmpty(nextX,nextY) && (direction = temporaire) != null){
			nextX = this.x + direction.first();
			nextY = this.y + direction.second();
			if(Utils.isThorique()){
				int[] tab = Utils.modulo(nextX,nextY);
				nextX = tab[0];
				nextY = tab[1];
			}
			temporaire = dir.nextDirection();
		}
		if(direction == null){
			return;
		}else {
			this.updateMarinCreature(new Pair(nextX, nextY), new Fish(this.x, this.y, (Wator) this.environement), Utils.fishBreedTime);
		}
		return;
	}

	private boolean isEmpty(int x, int y){
		if(x == -1 || x == Utils.grideSizeX || y == -1 || y == Utils.grideSizeY){
			return false;
		}
		return this.environement.isEmpty(x, y);
	}

}
