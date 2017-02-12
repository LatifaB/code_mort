package resources.sma.utils;

import java.util.LinkedList;
import java.util.Random;

public class Direction {

    private LinkedList<Pair> nonVue;
    private LinkedList<Pair> dejaVue;

    public Direction(){
        initDirection();
    }

    public void initDirection(){
        nonVue = new LinkedList<Pair>();
        dejaVue = new LinkedList<Pair>();
        nonVue.add(new Pair(1, 1));
        nonVue.add(new Pair(-1, 1));
        nonVue.add(new Pair(1, -1));
        nonVue.add(new Pair(-1, -1));
        nonVue.add(new Pair(0, 1));
        nonVue.add(new Pair(0, -1));
        nonVue.add(new Pair(1, 0));
        nonVue.add(new Pair(-1, 0));
    }

    public Pair nextDirection(){
        Random rdm = new Random();
        if(Utils.seed != 0) {
            rdm.setSeed(Utils.seed);
        }
        if(nonVue.size() > 0) {
            int nextInt = rdm.nextInt(nonVue.size());
            Pair direction = nonVue.get(nextInt);
            nonVue.remove(direction);
            dejaVue.add(direction);
            return direction;
        }
        return null;
    }
}
