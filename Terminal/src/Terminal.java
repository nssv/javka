import Exceptions.InvalidPidException;
import Exceptions.WithoutAccessException;

public interface Terminal {

    void getCache(int money) throws Exception;

    void addCache(int money) throws WithoutAccessException, Exception;

    boolean Access(String pid) throws InvalidPidException, Exception;

    int Cache() throws Exception;
}
