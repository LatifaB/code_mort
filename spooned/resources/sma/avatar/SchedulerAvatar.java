

package resources.sma.avatar;


public class SchedulerAvatar extends resources.sma.core.Scheduler {
    public SchedulerAvatar() {
        resources.sma.avatar.SchedulerAvatar.this.environement = new resources.sma.avatar.Board();
    }

    public java.util.LinkedList<resources.sma.avatar.Prey> getPreys() {
        return ((resources.sma.avatar.Board) (resources.sma.avatar.SchedulerAvatar.this.environement)).prey();
    }
}

