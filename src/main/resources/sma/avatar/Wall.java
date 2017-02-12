package resources.sma.avatar;

import resources.sma.core.Agent;
import resources.sma.core.Environement;

import java.awt.*;


public class Wall extends Agent{
    public Wall(int x, int y, Board environement) {
        super(x, y, environement);
        this.color = Color.black;
    }

    @Override
    public void update() {

    }

    @Override
    public void decide() {

    }
}
