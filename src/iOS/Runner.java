package iOS;

/**
 * Created by erez.akri on 3/13/17.
 */
public class Runner {

    public static void main(String arg[]) {

        Thread t1 = new Thread(new corereun("36f0a41a8fca9263c1f977b915dcb5668a0b83fc"));
        Thread t2 = new Thread(new corereun("636cb7a36d429661e6be6d70e1447a66268f73ff"));
        t1.start();
        t2.start();
    }
}
