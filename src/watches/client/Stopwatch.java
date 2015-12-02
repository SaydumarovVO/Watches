package watches.client;

import com.google.gwt.user.client.Timer;

/**
 * Created by Валера on 01.12.2015.
 */
public class Stopwatch {

    private int step;
    private Runnable runnable;
    private Timer t;

    public Stopwatch(int step) {
        if (step <= 0){
            throw new RuntimeException("You what, fucked?");
        }
        this.step = step;
    }


    public void onTick (Runnable runnable) {
        this.runnable = runnable;
    }

    public void pause (){
        if (isRunning()) {
            t.cancel();
        }
    }

    public boolean isRunning(){
        return t!=null && t.isRunning();
    }

    public void go (){
        t = new Timer() {
            public void run() {
                runnable.run();
            }
        };
        t.scheduleRepeating(step*1000);
    }
}
