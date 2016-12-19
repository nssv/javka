/**
 * Created by SBT-Novogorodtcev-SV on 14.12.2016.
 */
public interface ExecutionManager {

    Context execute(Runnable callback, Runnable... tasks);
}
