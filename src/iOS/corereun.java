package iOS;

import org.junit.runner.JUnitCore;

/**
 * Created by erez.akri on 3/13/17.
 */
public class corereun extends Thread {

    String udid;

    public corereun(String udid) {
        super();
        this.udid = udid;
    }

    @Override
    public void run() {
        Safari.UDID.set(udid);
        JUnitCore.runClasses(Safari.class);
    }
}
