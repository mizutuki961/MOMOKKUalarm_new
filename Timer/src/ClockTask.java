import java.util.TimerTask;

/**
 * 
 */

/**
 * @author 0H02004 大槻祐斗
 *
 */


public class ClockTask extends TimerTask {
    private Clock clock;

    public ClockTask(Clock clock) {
        this.clock = clock;
    }

    public void run() {
        clock.update(scheduledExecutionTime());
    }
}
