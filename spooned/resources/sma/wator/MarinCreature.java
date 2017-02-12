

package resources.sma.wator;


public abstract class MarinCreature extends resources.sma.core.Agent {
    protected int age;

    protected int breedTime;

    protected java.awt.Color adultColor;

    public MarinCreature(int x, int y, resources.sma.wator.Wator environement) {
        super(x, y, environement);
    }

    public void update() {
    }

    public void updateMarinCreature(resources.sma.utils.Pair direction, resources.sma.wator.MarinCreature agent, int breed) {
        int nextX = direction.first();
        int nextY = direction.second();
        resources.sma.wator.MarinCreature.this.environement.setAgent(nextX, nextY, resources.sma.wator.MarinCreature.this);
        if (((resources.sma.wator.MarinCreature.this.breedTime) % breed) == 0) {
            resources.sma.wator.MarinCreature.this.environement.setAgent(x, y, agent);
        }else {
            resources.sma.wator.MarinCreature.this.environement.setAgent(x, y, null);
        }
        resources.sma.wator.MarinCreature.this.x = nextX;
        resources.sma.wator.MarinCreature.this.y = nextY;
        (resources.sma.wator.MarinCreature.this.breedTime)++;
    }

    public abstract void count();
}

