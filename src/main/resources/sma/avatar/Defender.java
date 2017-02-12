package resources.sma.avatar;


import resources.sma.core.Agent;
import resources.sma.core.Environement;
import resources.sma.utils.Utils;

import java.awt.*;
import java.util.Random;

public class Defender extends Agent{


    public void addLife() {
        this.life++;
    }

    private int life = 0;

    public Defender(int x, int y, Environement environement) {
        super(x, y, environement);
        this.color = Color.orange;

    }

    public void update(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void update() {
    }

    @Override
    public void decide() {
        if(this.life == Utils.defenderLife ){
            if(((Board)this.environement).defenderAteContain(this)) {
                ((Board) this.environement).defenderReborn(this);
            }else{

                this.environement.setAgent(this.x,this.y,null);
            }
            Random rdm = new Random();
            if(Utils.seed != 0){
                rdm.setSeed(Utils.seed);
            }
            int x,y;
            x = rdm.nextInt(Utils.grideSizeX);
            y = rdm.nextInt(Utils.grideSizeY);
            while(((Board)this.environement).getAgent(x,y) != null){
                x = rdm.nextInt(Utils.grideSizeX);
                y = rdm.nextInt(Utils.grideSizeY);
            }
            this.x = x;
            this.y = y;
            this.environement.setAgent(x,y,this);
            this.life = 0;
        }
    }
}
