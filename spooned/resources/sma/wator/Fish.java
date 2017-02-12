

package resources.sma.wator;


public class Fish extends resources.sma.wator.MarinCreature {
    public Fish(int x, int y, resources.sma.wator.Wator water) {
        super(x, y, water);
        resources.sma.wator.Fish.this.color = java.awt.Color.green;
        resources.sma.wator.Fish.this.adultColor = java.awt.Color.blue;
        resources.sma.wator.Fish.this.age = 0;
    }

    @java.lang.Override
    public void update() {
    }

    @java.lang.Override
    public void count() {
        (resources.sma.utils.Utils.nbFishes)++;
    }

    @java.lang.Override
    public void decide() {
        (resources.sma.wator.Fish.this.age)++;
        if ((resources.sma.wator.Fish.this.age) == 1) {
            resources.sma.wator.Fish.this.color = resources.sma.wator.Fish.this.adultColor;
        }
        int nextX;
        int nextY;
        resources.sma.utils.Pair temporaire = null;
        resources.sma.utils.Direction dir = new resources.sma.utils.Direction();
        resources.sma.utils.Pair direction = dir.nextDirection();
        temporaire = direction;
        nextX = (resources.sma.wator.Fish.this.x) + (direction.first());
        nextY = (resources.sma.wator.Fish.this.y) + (direction.second());
        if (resources.sma.utils.Utils.isThorique()) {
            int[] tab = resources.sma.utils.Utils.modulo(nextX, nextY);
            nextX = tab[0];
            nextY = tab[1];
        }
        while ((!(resources.sma.wator.Fish.this.isEmpty(nextX, nextY))) && ((direction = temporaire) != null)) {
            nextX = (resources.sma.wator.Fish.this.x) + (direction.first());
            nextY = (resources.sma.wator.Fish.this.y) + (direction.second());
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
            resources.sma.wator.Fish.this.updateMarinCreature(new resources.sma.utils.Pair(nextX, nextY), new resources.sma.wator.Fish(resources.sma.wator.Fish.this.x, resources.sma.wator.Fish.this.y, ((resources.sma.wator.Wator) (resources.sma.wator.Fish.this.environement))), resources.sma.utils.Utils.fishBreedTime);
        }
        return ;
    }

    private boolean isEmpty(int x, int y) {
        if ((((x == (-1)) || (x == (resources.sma.utils.Utils.grideSizeX))) || (y == (-1))) || (y == (resources.sma.utils.Utils.grideSizeY))) {
            return false;
        }
        return resources.sma.wator.Fish.this.environement.isEmpty(x, y);
    }
}

