

package resources.sma.wator;


public class SharkUn extends resources.sma.wator.MarinCreature {
    private int starvingTime = 0;

    public SharkUn(int x, int y, resources.sma.wator.Wator environement) {
        super(x, y, environement);
        resources.sma.wator.SharkUn.this.color = java.awt.Color.pink;
        resources.sma.wator.SharkUn.this.adultColor = java.awt.Color.red;
        resources.sma.wator.SharkUn.this.age = 0;
    }

    @java.lang.Override
    public void count() {
        (resources.sma.utils.Utils.nbSharks)++;
    }

    @java.lang.Override
    public void decide() {
        (resources.sma.wator.SharkUn.this.age)++;
        if ((resources.sma.wator.SharkUn.this.age) == 1) {
            resources.sma.wator.SharkUn.this.color = resources.sma.wator.SharkUn.this.adultColor;
        }
        int nextX;
        int nextY;
        resources.sma.utils.Pair temporaire;
        resources.sma.utils.Direction dir = new resources.sma.utils.Direction();
        resources.sma.utils.Pair direction = dir.nextDirection();
        temporaire = direction;
        nextX = (resources.sma.wator.SharkUn.this.x) + (direction.first());
        nextY = (resources.sma.wator.SharkUn.this.y) + (direction.second());
        if (resources.sma.utils.Utils.isThorique()) {
            int[] tab = resources.sma.utils.Utils.modulo(nextX, nextY);
            nextX = tab[0];
            nextY = tab[1];
        }
        while ((!(resources.sma.wator.SharkUn.this.isYummy(nextX, nextY))) && ((direction = temporaire) != null)) {
            nextX = (resources.sma.wator.SharkUn.this.x) + (direction.first());
            nextY = (resources.sma.wator.SharkUn.this.y) + (direction.second());
            if (resources.sma.utils.Utils.isThorique()) {
                int[] tab = resources.sma.utils.Utils.modulo(nextX, nextY);
                nextX = tab[0];
                nextY = tab[1];
            }
            temporaire = dir.nextDirection();
        } 
        if (direction == null) {
            if ((resources.sma.wator.SharkUn.this.starvingTime) == (resources.sma.utils.Utils.sharkStraveTime)) {
                resources.sma.wator.SharkUn.this.environement.setAgent(resources.sma.wator.SharkUn.this.x, resources.sma.wator.SharkUn.this.y, null);
                return ;
            }else {
                (resources.sma.wator.SharkUn.this.starvingTime)++;
            }
            dir.initDirection();
            direction = dir.nextDirection();
            temporaire = direction;
            nextX = (resources.sma.wator.SharkUn.this.x) + (direction.first());
            nextY = (resources.sma.wator.SharkUn.this.y) + (direction.second());
            if (resources.sma.utils.Utils.isThorique()) {
                int[] tab = resources.sma.utils.Utils.modulo(nextX, nextY);
                nextX = tab[0];
                nextY = tab[1];
            }
            while ((resources.sma.wator.SharkUn.this.isOccupied(nextX, nextY)) && ((direction = temporaire) != null)) {
                nextX = (resources.sma.wator.SharkUn.this.x) + (direction.first());
                nextY = (resources.sma.wator.SharkUn.this.y) + (direction.second());
                if (resources.sma.utils.Utils.isThorique()) {
                    int[] tab = resources.sma.utils.Utils.modulo(nextX, nextY);
                    nextX = tab[0];
                    nextY = tab[1];
                }
                temporaire = dir.nextDirection();
            } 
            if (direction == null) {
                return ;
            }else {
                resources.sma.wator.SharkUn.this.updateMarinCreature(new resources.sma.utils.Pair(nextX, nextY), new resources.sma.wator.Shark(resources.sma.wator.SharkUn.this.x, resources.sma.wator.SharkUn.this.y, ((resources.sma.wator.Wator) (resources.sma.wator.SharkUn.this.environement))), resources.sma.utils.Utils.sharkBreedTime);
            }
        }else {
            resources.sma.wator.SharkUn.this.updateMarinCreature(new resources.sma.utils.Pair(nextX, nextY), new resources.sma.wator.Shark(resources.sma.wator.SharkUn.this.x, resources.sma.wator.SharkUn.this.y, ((resources.sma.wator.Wator) (resources.sma.wator.SharkUn.this.environement))), resources.sma.utils.Utils.sharkBreedTime);
            resources.sma.wator.SharkUn.this.starvingTime = 0;
        }
        return ;
    }

    private boolean isOccupied(int x, int y) {
        if (!(resources.sma.utils.Utils.isThorique())) {
            if ((((x == (-1)) || (x == (resources.sma.utils.Utils.grideSizeX))) || (y == (-1))) || (y == (resources.sma.utils.Utils.grideSizeY))) {
                return true;
            }
        }
        return ((resources.sma.wator.SharkUn.this.environement.getAgent(x, y)) != null) && ((resources.sma.wator.SharkUn.this.environement.getAgent(x, y)) instanceof resources.sma.wator.Shark);
    }

    private boolean isYummy(int x, int y) {
        if (!(resources.sma.utils.Utils.isThorique())) {
            if ((((x == (-1)) || (x == (resources.sma.utils.Utils.grideSizeX))) || (y == (-1))) || (y == (resources.sma.utils.Utils.grideSizeY))) {
                return false;
            }
        }
        return ((resources.sma.wator.SharkUn.this.environement.getAgent(x, y)) != null) && ((resources.sma.wator.SharkUn.this.environement.getAgent(x, y)) instanceof resources.sma.wator.Fish);
    }
}

