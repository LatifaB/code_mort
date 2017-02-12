

package resources.sma.utils;


public class Direction {
    private java.util.LinkedList<resources.sma.utils.Pair> nonVue;

    private java.util.LinkedList<resources.sma.utils.Pair> dejaVue;

    public Direction() {
        initDirection();
    }

    public void initDirection() {
        nonVue = new java.util.LinkedList<resources.sma.utils.Pair>();
        dejaVue = new java.util.LinkedList<resources.sma.utils.Pair>();
        nonVue.add(new resources.sma.utils.Pair(1, 1));
        nonVue.add(new resources.sma.utils.Pair((-1), 1));
        nonVue.add(new resources.sma.utils.Pair(1, (-1)));
        nonVue.add(new resources.sma.utils.Pair((-1), (-1)));
        nonVue.add(new resources.sma.utils.Pair(0, 1));
        nonVue.add(new resources.sma.utils.Pair(0, (-1)));
        nonVue.add(new resources.sma.utils.Pair(1, 0));
        nonVue.add(new resources.sma.utils.Pair((-1), 0));
    }

    public resources.sma.utils.Pair nextDirection() {
        java.util.Random rdm = new java.util.Random();
        if ((resources.sma.utils.Utils.seed) != 0) {
            rdm.setSeed(resources.sma.utils.Utils.seed);
        }
        if ((nonVue.size()) > 0) {
            int nextInt = rdm.nextInt(nonVue.size());
            resources.sma.utils.Pair direction = nonVue.get(nextInt);
            nonVue.remove(direction);
            dejaVue.add(direction);
            return direction;
        }
        return null;
    }
}

