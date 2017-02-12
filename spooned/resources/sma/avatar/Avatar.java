

package resources.sma.avatar;


public abstract class Avatar extends resources.sma.core.Agent {
    protected int dirX;

    protected int dirY;

    public Avatar(int x, int y, resources.sma.core.Environement environement) {
        super(x, y, environement);
        java.util.Random rdm = new java.util.Random();
        int[] pas = new int[]{ 1 , -1 , 0 };
        if ((resources.sma.utils.Utils.seed) != 0) {
            rdm.setSeed(resources.sma.utils.Utils.seed);
        }
        resources.sma.avatar.Avatar.this.dirX = pas[rdm.nextInt(3)];
        resources.sma.avatar.Avatar.this.dirY = pas[rdm.nextInt(3)];
    }
}

