

package resources.sma;


public class Main {
    public static void main(java.lang.String[] args) {
        resources.sma.particule.SchedulerBille bille = new resources.sma.particule.SchedulerBille();
        resources.sma.particule.MyViewBille viewBille = new resources.sma.particule.MyViewBille();
        bille.addObserver(viewBille);
        bille.run();
    }
}

