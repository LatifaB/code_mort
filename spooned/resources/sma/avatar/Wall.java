

package resources.sma.avatar;


public class Wall extends resources.sma.core.Agent {
    public Wall(int x, int y, resources.sma.avatar.Board environement) {
        super(x, y, environement);
        resources.sma.avatar.Wall.this.color = java.awt.Color.black;
    }

    @java.lang.Override
    public void update() {
    }

    @java.lang.Override
    public void decide() {
    }
}

