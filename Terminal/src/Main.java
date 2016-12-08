import Exceptions.InvalidPidException;
import Exceptions.NoMoneyException;
import Exceptions.WithoutAccessException;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception {
        TerminalImpl terminal = new TerminalImpl(new TerminalServer(), new PidValidator());
        Scanner scanner = new Scanner(System.in);
        boolean varexit = true;
        boolean access = false;
        System.out.println("Enter pid");

        while (!access) {
            String pin = scanner.nextLine();
            try {
                access = terminal.Access(pin);
            } catch (InvalidPidException e) {
                e.getMessage();
            }


            while (varexit) {
                while (!access) {
                    String command = scanner.nextLine();
                    try {
                        access = terminal.Access(pin);
                    } catch (InvalidPidException e) {
                        e.getMessage();
                    }
                }
                String command = scanner.nextLine();

                if (command.equals("/help"))
                    System.out.println("format: 'command' \n        'x' \n'add x' - put some money, \n'get x' - give some money, \n'balance' - check your balance, \n'exit' - exit operation");
                if (command.equals("add")) {
                    int dn = Integer.parseInt(scanner.nextLine());
                    try {
                        terminal.addCache(dn);
                    } catch (WithoutAccessException e) {
                        System.out.println("Access Denied: Enter pid");
                    }
                }
                if (command.equals("get")) {
                    int dn = Integer.parseInt(scanner.nextLine());
                    try {
                        try {
                            terminal.getCache(dn);
                        } catch (NoMoneyException e) {
                            System.out.println("Not enough money: Try again");
                        }
                    } catch (WithoutAccessException e) {
                        System.out.println("Access Denied: Enter pid");
                    }
                }
                if (command.equals("balance")) {
                    try {
                        terminal.Cache();
                    } catch (WithoutAccessException e) {
                        System.out.println("Access Denied: Enter pid ");
                    }
                }
                if (command.equals("exit")) varexit = false;

                if (!command.equals("add") && !command.equals("get") && !command.equals("balance") && !command.equals("/help") && !command.equals("exit"))
                    System.out.println("Wrong command");
            }


        }
    }

}