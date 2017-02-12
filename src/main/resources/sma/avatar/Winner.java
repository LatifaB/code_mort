package resources.sma.avatar;


import resources.sma.core.Agent;
import resources.sma.core.Environement;
import resources.sma.utils.Utils;

import java.awt.*;
import java.util.Random;

public class Winner extends Agent{

    public Winner(int x, int y, Environement board){
        super(x,y,board);
        this.color = Color.white;
    }

    @Override
    public void update() {

    }

    @Override
    public void decide() {
        if(((Board) this.environement).defendersNb() == 4){
            Random rdm = new Random();
            if(Utils.seed != 0){
                rdm.setSeed(Utils.seed);
            }
            int x,y;
            x = rdm.nextInt(Utils.grideSizeX);
            y = rdm.nextInt(Utils.grideSizeY);
            while(((Board) this.environement).getAgent(x,y) != null){
                x = rdm.nextInt(Utils.grideSizeX);
                y = rdm.nextInt(Utils.grideSizeY);
            }
            this.x = x;
            this.y = y;
            ((Board) this.environement).setAgent(x,y,this);
            this.color = Color.pink;
        }

    }
}
