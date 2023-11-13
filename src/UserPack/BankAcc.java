package UserPack;

public class BankAcc extends Account{

    public BankAcc(String username, String password, double balance) {
        super(username, password, balance);
    }

    @Override
    public void addMoney(double amount) {
        this.setBalance(amount);
    }

    @Override
    public boolean deductMoney(double amount) {
        if(this.getBalance()>=amount){
            double newmon=this.getBalance()-amount;
            this.addMoney(newmon);
            return true;
        }
        return false;
    }
}
