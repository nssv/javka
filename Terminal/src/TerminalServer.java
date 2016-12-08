import Exceptions.InvalidPidException;
import Exceptions.NoMoneyException;
import Exceptions.WithoutAccessException;

import java.util.Objects;


public class TerminalServer {
    private boolean access;
    private int balance;


    public TerminalServer() {
        access = false;
        balance = 100;
    }

    public boolean getAccess() {
        System.out.println("Hello world, press '/help' to view commands");
        return access = true;
    }

    public void getMoney(int money) throws Exception {
        if (!access) throw new WithoutAccessException();

        if (money > balance) throw new NoMoneyException();
        balance -= money;
    }

    public void addMoney(int money) throws WithoutAccessException {
        if (!access) throw new WithoutAccessException();
        balance += money;
    }

    public int Balance() throws Exception {
        if (!access) throw new WithoutAccessException();
        System.out.println(balance);
        return balance;
    }

}

class PidValidator {

    public void Check(String pid) throws InvalidPidException {
        if (!Objects.equals(pid, "0000")) {
            System.out.println(true);

            throw new InvalidPidException();

        }

    }
}
