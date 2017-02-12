package resources.sma.wator;

import resources.sma.utils.Direction;
import resources.sma.utils.Pair;
import resources.sma.utils.Utils;

import java.awt.*;

public class SharkUn extends MarinCreature{
    private int starvingTime = 0;

    public SharkUn(int x, int y, Wator environement) {
        super(x, y, environement);
        this.color = Color.pink;
        this.adultColor = Color.red;
        this.age = 0;
    }

    @Override
    public void count() {
        Utils.nbSharks++;
    }


    @Override
    public void decide() {

        this.age++;
        if(this.age == 1){
            this.color = this.adultColor;
        }
        int nextX, nextY;
        Pair temporaire;
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
        while(!this.isYummy(nextX,nextY) && (direction = temporaire) != null){
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
            if(this.starvingTime == Utils.sharkStraveTime){
                this.environement.setAgent(this.x,this.y,null);
                return;
            }else{
                this.starvingTime++;
            }

            dir.initDirection();
            direction = dir.nextDirection();
            temporaire = direction;
            nextX = this.x + direction.first();
            nextY = this.y + direction.second();
            if(Utils.isThorique()){
                int[] tab = Utils.modulo(nextX,nextY);
                nextX = tab[0];
                nextY = tab[1];
            }
            while(this.isOccupied(nextX,nextY) && (direction = temporaire) != null){
                nextX = this.x + direction.first();
                nextY = this.y + direction.second();
                if(Utils.isThorique()){
                    int[] tab = Utils.modulo(nextX,nextY);
                    nextX = tab[0];
                    nextY = tab[1];
                }
                temporaire = dir.nextDirection();
            }
            if(direction == null) {
                return;
            }else{
                this.updateMarinCreature(new Pair(nextX,nextY),new Shark(this.x,this.y,(Wator)this.environement), Utils.sharkBreedTime);
            }
        }else {
            this.updateMarinCreature(new Pair(nextX,nextY),new Shark(this.x,this.y,(Wator)this.environement), Utils.sharkBreedTime);
            this.starvingTime = 0;
        }
        return;
    }

    private boolean isOccupied(int x, int y){
        if(!Utils.isThorique()) {
            if (x == (-1) || x == Utils.grideSizeX || y == (-1) || y == Utils.grideSizeY) {
                return true;
            }
        }
        return this.environement.getAgent(x, y) != null && this.environement.getAgent(x,y) instanceof Shark;
    }

    private boolean isYummy(int x, int y){
        if(!Utils.isThorique()) {
            if (x == -1 || x == Utils.grideSizeX || y == -1 || y == Utils.grideSizeY) {
                return false;
            }
        }
        return this.environement.getAgent(x, y) != null && this.environement.getAgent(x,y) instanceof Fish;
    }
}
