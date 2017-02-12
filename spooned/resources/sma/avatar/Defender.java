

package resources.sma.avatar;


public class Defender extends resources.sma.core.Agent {
    public void addLife() {
        (resources.sma.avatar.Defender.this.life)++;
    }

    private int life = 0;

    public Defender(int x, int y, resources.sma.core.Environement environement) {
        super(x, y, environement);
        resources.sma.avatar.Defender.this.color = java.awt.Color.orange;
    }

    public void update(int x, int y) {
        resources.sma.avatar.Defender.this.x = x;
        resources.sma.avatar.Defender.this.y = y;
    }

    @java.lang.Override
    public void update() {
    }

    @java.lang.Override
    public void decide() {
        if ((resources.sma.avatar.Defender.this.life) == (resources.sma.utils.Utils.defenderLife)) {
            if (((resources.sma.avatar.Board) (resources.sma.avatar.Defender.this.environement)).defenderAteContain(resources.sma.avatar.Defender.this)) {
                ((resources.sma.avatar.Board) (resources.sma.avatar.Defender.this.environement)).defenderReborn(resources.sma.avatar.Defender.this);
            }else {
                resources.sma.avatar.Defender.this.environement.setAgent(resources.sma.avatar.Defender.this.x, resources.sma.avatar.Defender.this.y, null);
            }
            java.util.Random rdm = new java.util.Random();
            if ((resources.sma.utils.Utils.seed) != 0) {
                rdm.setSeed(resources.sma.utils.Utils.seed);
            }
            int x;
            int y;
            x = rdm.nextInt(resources.sma.utils.Utils.grideSizeX);
            y = rdm.nextInt(resources.sma.utils.Utils.grideSizeY);
            while ((((resources.sma.avatar.Board) (resources.sma.avatar.Defender.this.environement)).getAgent(x, y)) != null) {
                x = rdm.nextInt(resources.sma.utils.Utils.grideSizeX);
                y = rdm.nextInt(resources.sma.utils.Utils.grideSizeY);
            } 
            resources.sma.avatar.Defender.this.x = x;
            resources.sma.avatar.Defender.this.y = y;
            resources.sma.avatar.Defender.this.environement.setAgent(x, y, resources.sma.avatar.Defender.this);
            resources.sma.avatar.Defender.this.life = 0;
        }
    }
}

