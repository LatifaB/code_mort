

package resources.sma.core;


public abstract class Agent {
    protected int x;

    protected int y;

    protected boolean isMoved;

    protected resources.sma.core.Environement environement;

    protected boolean changementDeDirection = false;

    protected java.awt.Color color;

    public Agent(int x, int y, resources.sma.core.Environement environement) {
        resources.sma.core.Agent.this.x = x;
        resources.sma.core.Agent.this.y = y;
        resources.sma.core.Agent.this.isMoved = false;
        resources.sma.core.Agent.this.environement = environement;
        java.awt.Color[] colorList = new java.awt.Color[]{ java.awt.Color.black , java.awt.Color.blue , java.awt.Color.cyan , java.awt.Color.darkGray , java.awt.Color.green , java.awt.Color.magenta , java.awt.Color.orange , java.awt.Color.pink , java.awt.Color.red , java.awt.Color.yellow };
        java.util.Random rdm = new java.util.Random();
        if ((resources.sma.utils.Utils.seed) != 0) {
            rdm.setSeed(resources.sma.utils.Utils.seed);
        }
        resources.sma.core.Agent.this.color = colorList[rdm.nextInt(10)];
    }

    public boolean isMoved() {
        return resources.sma.core.Agent.this.isMoved;
    }

    public void resetMoved() {
        resources.sma.core.Agent.this.isMoved = false;
    }

    public abstract void update();

    public abstract void decide();

    public java.awt.Color getColor() {
        return resources.sma.core.Agent.this.color;
    }
}

