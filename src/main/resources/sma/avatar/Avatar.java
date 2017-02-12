package resources.sma.avatar;


import resources.sma.core.Agent;
import resources.sma.core.Environement;
import resources.sma.utils.Utils;

import java.util.Random;

public abstract class Avatar extends Agent{

    protected int dirX;
    protected int dirY;

    public Avatar(int x, int y, Environement environement) {
        super(x, y, environement);

        Random rdm = new Random();

        int[] pas = {1,-1,0};
        if(Utils.seed != 0){
            rdm.setSeed(Utils.seed);
        }
        this.dirX = pas[rdm.nextInt(3)];
        this.dirY = pas[rdm.nextInt(3)];
    }
}
