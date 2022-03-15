public class Account {

    private String userName;
    private String userSurname;
    private int accNumber;
    private double accBalance;

    public Account(String userName, String userSurname, int accNumber) {

        this.userName = userName;
        this.userSurname = userSurname;
        this.accNumber = accNumber;
        this.accBalance = 0;

    }

    public Account(){

    }

    public String showBalance() {

        return "\n\nDear " + userName + " " + userSurname + ". Your account's " + accNumber + " balance is: " + accBalance + " PLN.\n\n";
    }

    public void deposit(double deposit) {
        accBalance += deposit;
    }

    public double getAccBalance() {

        return accBalance;
    }

    public int getAccNumber(){
        return accNumber;
    }


    public String withdraw(double withdrawAmount) {

        if (withdrawAmount > accBalance) {
            return "\nGit yo greasy hands offa mah moneyz ya HOBO! \n\n";
        } else {
            accBalance -= withdrawAmount;
        }
        return "\nAccount Balance updated.\n\n";
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }

}
