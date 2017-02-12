package resources.sma.avatar;


import resources.sma.core.Environement;
import resources.sma.utils.Utils;

import java.awt.*;

public class Hunter extends Avatar{

    private float vitesse = 0;

    public Hunter(int x, int y, Environement environement) {
        super(x, y, environement);
        this.color = Color.red;
    }

    @Override
    public void update() {

    }

    @Override
    public void decide() {
        if(vitesse  >= 1){
            vitesse = 0;
            int newX, newY;
            for (int dirX = -1; dirX < 2; dirX++) {
                newX = this.x + dirX;
                for (int dirY = -1; dirY < 2; dirY++) {
                    newY = this.y + dirY;
                    if (this.isOK(newX, newY)) {
                        this.environement.setAgent(this.x, this.y, null);
                        this.environement.setAgent(newX, newY, this);
                        this.x = newX;
                        this.y = newY;
                    }
                }
            }
        }
        vitesse = vitesse + Utils.speedHunter;
    }

    private boolean isOK(int x, int y){
        if(x == -1 || x == Utils.grideSizeX || y == -1 || y == Utils.grideSizeY){
            return false;
        }
        if(((Board) this.environement).getCaseDijkstra(x, y) == 1){
            ((Board) this.environement).loose();
            return true;
        }
        if(((Board) this.environement).defendersAte()) {
            return ((Board) this.environement).getCaseDijkstra(x, y) > ((Board) this.environement).getCaseDijkstra(this.x, this.y);
        }else{
            return ((Board) this.environement).getCaseDijkstra(x, y) < ((Board) this.environement).getCaseDijkstra(this.x, this.y)
                    && 0 < ((Board) this.environement).getCaseDijkstra(x, y);
        }
    }
}
