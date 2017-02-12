

package resources.sma.avatar;


public class Hunter extends resources.sma.avatar.Avatar {
    private float vitesse = 0;

    public Hunter(int x, int y, resources.sma.core.Environement environement) {
        super(x, y, environement);
        resources.sma.avatar.Hunter.this.color = java.awt.Color.red;
    }

    @java.lang.Override
    public void update() {
    }

    @java.lang.Override
    public void decide() {
        if ((vitesse) >= 1) {
            vitesse = 0;
            int newX;
            int newY;
            for (int dirX = -1; dirX < 2; dirX++) {
                newX = (resources.sma.avatar.Hunter.this.x) + dirX;
                for (int dirY = -1; dirY < 2; dirY++) {
                    newY = (resources.sma.avatar.Hunter.this.y) + dirY;
                    if (resources.sma.avatar.Hunter.this.isOK(newX, newY)) {
                        resources.sma.avatar.Hunter.this.environement.setAgent(resources.sma.avatar.Hunter.this.x, resources.sma.avatar.Hunter.this.y, null);
                        resources.sma.avatar.Hunter.this.environement.setAgent(newX, newY, resources.sma.avatar.Hunter.this);
                        resources.sma.avatar.Hunter.this.x = newX;
                        resources.sma.avatar.Hunter.this.y = newY;
                    }
                }
            }
        }
        vitesse = (vitesse) + (resources.sma.utils.Utils.speedHunter);
    }

    private boolean isOK(int x, int y) {
        if ((((x == (-1)) || (x == (resources.sma.utils.Utils.grideSizeX))) || (y == (-1))) || (y == (resources.sma.utils.Utils.grideSizeY))) {
            return false;
        }
        if ((((resources.sma.avatar.Board) (resources.sma.avatar.Hunter.this.environement)).getCaseDijkstra(x, y)) == 1) {
            ((resources.sma.avatar.Board) (resources.sma.avatar.Hunter.this.environement)).loose();
            return true;
        }
        if (((resources.sma.avatar.Board) (resources.sma.avatar.Hunter.this.environement)).defendersAte()) {
            return (((resources.sma.avatar.Board) (resources.sma.avatar.Hunter.this.environement)).getCaseDijkstra(x, y)) > (((resources.sma.avatar.Board) (resources.sma.avatar.Hunter.this.environement)).getCaseDijkstra(resources.sma.avatar.Hunter.this.x, resources.sma.avatar.Hunter.this.y));
        }else {
            return ((((resources.sma.avatar.Board) (resources.sma.avatar.Hunter.this.environement)).getCaseDijkstra(x, y)) < (((resources.sma.avatar.Board) (resources.sma.avatar.Hunter.this.environement)).getCaseDijkstra(resources.sma.avatar.Hunter.this.x, resources.sma.avatar.Hunter.this.y))) && (0 < (((resources.sma.avatar.Board) (resources.sma.avatar.Hunter.this.environement)).getCaseDijkstra(x, y)));
        }
    }
}

