/**
 * Created by SBT-Novogorodtcev-SV on 14.12.2016.
 */
public interface Context {

    int getCompleteTaskCount();

    int getFailedTaskCount();

    int getInterruptedTaskCount();

    void interrupt();

    boolean isFinished();
}

