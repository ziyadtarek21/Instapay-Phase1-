package UserPack;

import Databases_And_APIs.BankAPI;

public class BankAcc extends Account{

    private String cardNumber;
    public BankAcc(String username, String password, double balance, User user) {
        super(username, password, balance, user);
    }

    @Override
    public void addMoney(double amount) {

        this.setBalance(amount);
        BankAPI.setBalance(cardNumber, getBalance());
    }

    @Override
    public boolean deductMoney(double amount) {
        if(this.getBalance()>=amount){
            double newmon=this.getBalance()-amount;
            this.addMoney(newmon);
            BankAPI.setBalance(cardNumber, getBalance());
            return true;
        }
        return false;
    }

    public void setCardNumber(String cardNumber){
        this.cardNumber = cardNumber;
    }
}
