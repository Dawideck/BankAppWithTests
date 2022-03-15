import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class BankTests {


    private Account acc;

    @Before
    public void createNewAccount() {
        acc = new Account();
        acc.setUserName("Dawid");
        acc.setUserSurname("Tend");
        acc.setAccNumber(123123);
    }



    @Test
    public void checkIfAccountAddsDepositsCorrectly() {

        acc.deposit(140.23);
        Assert.assertEquals(140.23, acc.getAccBalance(), 0.01);
        acc.deposit(20.00);
        Assert.assertEquals(160.23, acc.getAccBalance(), 0.01);

    }

    @Test
    public void checkIfUserNameAndSurnameAndAccNumberAddedCorrectly() {

        Assert.assertEquals("\n\nDear Dawid Tend. Your account's 123123 balance is: 0.0 PLN.\n\n", acc.showBalance());

    }


    @Test
    public void checkIfAccountWithdrawsCorrectAmount() {

        acc.deposit(200);
        acc.withdraw(100);

        Assert.assertEquals(100, acc.getAccBalance(), 0.001);

    }

    @Test
    public void checkIfAccountWithdrawReturnsCorrectMessage() {

        acc.deposit(200);

        Assert.assertEquals("\nAccount Balance updated.\n\n", acc.withdraw(200));

    }

    @Test
    public void checkIfUserCanWithdrawMoreFromAcc() {

        acc.deposit(200);
        acc.withdraw(300);

        Assert.assertEquals("\nGit yo greasy hands offa mah moneyz ya HOBO! \n\n", acc.withdraw(300));

    }


}
