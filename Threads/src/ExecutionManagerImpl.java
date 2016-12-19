/**
 * Created by SBT-Novogorodtcev-SV on 14.12.2016.
 */
public class ExecutionManagerImpl implements ExecutionManager {

    @Override
    public Context execute(Runnable callback, Runnable... tasks) {
        return new ContextImpl(callback, tasks);
    }


}
