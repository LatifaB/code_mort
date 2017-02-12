package resources.sma.avatar;

import resources.sma.core.Scheduler;

import java.util.LinkedList;


public class SchedulerAvatar extends Scheduler{

    public SchedulerAvatar() {
        this.environement = new Board();
    }

    public LinkedList<Prey> getPreys(){
        return ((Board) this.environement).prey();
    }
}
