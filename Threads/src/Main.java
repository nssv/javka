public class Main {

    public static void main(String[] args) throws InterruptedException {

        ExecutionManager executionManager = new ExecutionManagerImpl();

        Runnable callback = new Task("callback", 0, false);

        Runnable[] tasks = {
                new Task("1", 5, false), //fail
                new Task("2", 10, false), //
                new Task("3", 20, true),
                new Task("4", 45, false),
                new Task("5", 60, false),
                new Task("6", 70, true)
        };

        Context statrt = executionManager.execute(callback, tasks);

        Thread.sleep(10);

        statrt.interrupt();
        Thread.sleep(1000);

        System.out.println("Finished: "+(statrt.isFinished()));
        System.out.println("Completed: "+(statrt.getCompleteTaskCount()));
        System.out.println("Failed: "+(statrt.getFailedTaskCount()));
        System.out.println("Interrupted: "+(statrt.getInterruptedTaskCount()));
    }
}
