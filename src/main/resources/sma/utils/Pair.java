package resources.sma.utils;

public class Pair {
    public final int first;
    public final int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int first(){
        return this.first;
    }

    public int second(){
        return this.second;
    }

    public boolean equals(Object o){
        if(o instanceof Pair){
            Pair pair = (Pair) o;
            return (this.first == pair.first()) && (this.second == pair.second());
        }else{
            return false;
        }
    }
}
