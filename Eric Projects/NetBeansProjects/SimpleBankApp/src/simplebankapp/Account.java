
public class Account {
    private String accountNumber;
    private String accountHolder;
    private String openDate;
    private double accountBalance;
    
    public Account(String acctNumber, String acctHolder, String date, double balance){
        this.accountNumber = acctNumber;
        this.accountHolder = acctHolder;
        this.openDate = date;
        this.accountBalance = balance;
    }
    
    public void withdraw(double amount) {
        this.accountBalance = this.accountBalance - amount;
    }
    
    public void deposit(double amount) {
        this.accountBalance = this.accountBalance + amount;
    }
    
    public void transfer(Account a, double amount) {
        this.withdraw(amount);
        a.deposit(amount);
    }
    
    public String getAccountHolder(){
        return this.accountHolder;
    }
    
    public String getOpenDate() {
        return this.openDate;
    }
    
    public double getAccountBalance() {
        return this.accountBalance;
    }
            
            
    @Override
    public String toString() {
        return this.accountNumber;
    }
}
