import Exceptions.WithoutAccessException;

public class TerminalImpl implements Terminal {
    private final TerminalServer server;
    private final PidValidator validator;

    public TerminalImpl() {
        validator = new PidValidator();
        server = new TerminalServer();
    }

    public TerminalImpl(TerminalServer server, PidValidator validator) {
        this.server = server;
        this.validator = validator;

    }

    @Override
    public void getCache(int money) throws Exception {
        server.getMoney(money);
    }

    @Override
    public void addCache(int money) throws WithoutAccessException {
        server.addMoney(money);
    }

    @Override
    public boolean Access(String pid) throws Exception {
        validator.Check(pid);
        return server.getAccess();
    }

    @Override
    public int Cache() throws Exception {
        return server.Balance();
    }


}
