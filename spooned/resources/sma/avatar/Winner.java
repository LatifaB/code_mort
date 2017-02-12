

package resources.sma.avatar;


public class Winner extends resources.sma.core.Agent {
    public Winner(int x, int y, resources.sma.core.Environement board) {
        super(x, y, board);
        resources.sma.avatar.Winner.this.color = java.awt.Color.white;
    }

    @java.lang.Override
    public void update() {
    }

    @java.lang.Override
    public void decide() {
        if ((((resources.sma.avatar.Board) (resources.sma.avatar.Winner.this.environement)).defendersNb()) == 4) {
            java.util.Random rdm = new java.util.Random();
            if ((resources.sma.utils.Utils.seed) != 0) {
                rdm.setSeed(resources.sma.utils.Utils.seed);
            }
            int x;
            int y;
            x = rdm.nextInt(resources.sma.utils.Utils.grideSizeX);
            y = rdm.nextInt(resources.sma.utils.Utils.grideSizeY);
            while ((((resources.sma.avatar.Board) (resources.sma.avatar.Winner.this.environement)).getAgent(x, y)) != null) {
                x = rdm.nextInt(resources.sma.utils.Utils.grideSizeX);
                y = rdm.nextInt(resources.sma.utils.Utils.grideSizeY);
            } 
            resources.sma.avatar.Winner.this.x = x;
            resources.sma.avatar.Winner.this.y = y;
            ((resources.sma.avatar.Board) (resources.sma.avatar.Winner.this.environement)).setAgent(x, y, resources.sma.avatar.Winner.this);
            resources.sma.avatar.Winner.this.color = java.awt.Color.pink;
        }
    }
}

