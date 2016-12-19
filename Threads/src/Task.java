/**
 * Created by SBT-Novogorodtcev-SV on 15.12.2016.
 */
public class Task implements Runnable {

    private final String message;
    private final long delay;
    private final boolean isException;

    Task(String message, long delay, boolean isException) {
        this.message = message;
        this.delay = delay;
        this.isException = isException;
    }


    @Override
    public void run() {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Message: " + message + " delay: " + delay + " exception: "+isException);
        if(isException) throw new RuntimeException();
    }
}
