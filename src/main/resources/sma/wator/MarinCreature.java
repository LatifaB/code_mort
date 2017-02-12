package resources.sma.wator;


import resources.sma.core.Agent;
import resources.sma.utils.Pair;
import resources.sma.utils.Utils;

import java.awt.*;

public abstract class MarinCreature extends Agent {

    protected int age;
    protected int breedTime;
    protected Color adultColor;

    public MarinCreature(int x, int y, Wator environement) {
        super(x, y, environement);
    }

    public void update(){}

    public void updateMarinCreature(Pair direction, MarinCreature agent, int breed) {
        int nextX = direction.first();
        int nextY = direction.second();
        this.environement.setAgent(nextX,nextY,this);
        if ((this.breedTime % breed) == 0) {
            this.environement.setAgent(x, y, agent);
        }else{
            this.environement.setAgent(x, y, null);
        }
        this.x = nextX;
        this.y = nextY;
        this.breedTime++;
    }

    public abstract void count();
}
