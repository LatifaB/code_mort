

package resources.sma.utils;


public class Pair {
    public final int first;

    public final int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int first() {
        return resources.sma.utils.Pair.this.first;
    }

    public int second() {
        return resources.sma.utils.Pair.this.second;
    }

    public boolean equals(java.lang.Object o) {
        if (o instanceof resources.sma.utils.Pair) {
            resources.sma.utils.Pair pair = ((resources.sma.utils.Pair) (o));
            return ((resources.sma.utils.Pair.this.first) == (pair.first())) && ((resources.sma.utils.Pair.this.second) == (pair.second()));
        }else {
            return false;
        }
    }
}

