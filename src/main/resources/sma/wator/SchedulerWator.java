package resources.sma.wator;

import resources.sma.core.Scheduler;
import resources.sma.particule.Surface;


public class SchedulerWator extends Scheduler {

    public SchedulerWator() {
        this.environement = new Wator();
    }
}
