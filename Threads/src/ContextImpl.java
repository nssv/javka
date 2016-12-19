import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Created by SBT-Novogorodtcev-SV on 15.12.2016.
 */
public class ContextImpl implements Context {

    private boolean isFinished;
    private volatile boolean isInterrupted;
    private Map<Thread, State> mapThreads = Collections.synchronizedMap(new LinkedHashMap<>());

    private synchronized int getStateCount(State state) {
        int count = 0;


        for (Map.Entry<Thread, State> thread : mapThreads.entrySet()) {
            if (thread.getValue() == state) count++;
        }
        return count;
    }


    ContextImpl(Runnable callback, Runnable[] tasks) {
        new Thread(() -> {
            for (Runnable task : tasks) {
                Thread thread = new Thread(task);
                synchronized (this) {
                    thread.setUncaughtExceptionHandler((t, e) -> {
                        mapThreads.put(thread, State.FAILED);
                    });
                    if (!isInterrupted) {
                        mapThreads.put(thread, State.RUNNING);
                        thread.start();

                    } else {
                        mapThreads.put(thread, State.INTERRUPTED);
                    }
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(mapThreads);
        }).start();


        new Thread(() -> {
            while (!isFinished) {
                synchronized (this) {
                    for (Map.Entry<Thread, State> thread : mapThreads.entrySet()) {
                        if (thread.getKey().getState() == Thread.State.TERMINATED && thread.getValue() != State.FAILED ) {
//                            System.out.println(thread.getValue());
                            thread.setValue(State.COMPLETED);
                            isFinished = true;
                        } else {
                            isFinished = false;
                        }
                    }
                }
            }
            callback.run();
        }
        ).start();
    }


    @Override
    public int getCompleteTaskCount() {
        return getStateCount(State.COMPLETED);
    }

    @Override
    public int getFailedTaskCount() {
        return getStateCount(State.FAILED);
    }

    @Override
    public int getInterruptedTaskCount() {
        return getStateCount(State.INTERRUPTED);
    }

    @Override
    public void interrupt() {
        isInterrupted = true;
    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }
}
