import java.util.Scanner;
public class Test
{
    public void useAccount()
    {
    Account account_1;
    account_1 = new Account();
    account_1.initialise(("Jane"));
    account_1.print();
    account_1.deposit(100);
    account_1.print();
    account_1.withdraw(50);
    account_1.print();
    Scanner reader = new Scanner(System.in);
    System.out.println("press return to finish");
    String temp = reader.nextLine();
    System.out.println("Program Finished");
}// end method
}// end class