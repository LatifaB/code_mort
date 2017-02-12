

package resources.sma.core;


public abstract class Scheduler extends java.util.Observable {
    protected resources.sma.core.Environement environement;

    public void run() {
        setChanged();
        notifyObservers();
        if (resources.sma.utils.Utils.isInfinity()) {
            while (true) {
                try {
                    environement.decideAll();
                    setChanged();
                    notifyObservers();
                    java.lang.Thread.sleep(resources.sma.utils.Utils.delay);
                } catch (java.lang.InterruptedException e) {
                    e.printStackTrace();
                }
            } 
        }else {
            for (int i = 0; i < (resources.sma.utils.Utils.nbTricks); i++) {
                try {
                    environement.decideAll();
                    setChanged();
                    notifyObservers();
                    java.lang.Thread.sleep(resources.sma.utils.Utils.delay);
                } catch (java.lang.InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public java.awt.Color[][] getMap() {
        return environement.getColor();
    }
}

