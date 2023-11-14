package UserPack;

import walletProviders.WalletProviders;

public class WalletAcc extends Account {
    private WalletProviders walletProviders;
    public void setServiceprovider(WalletProviders walletProviders) {
        this.walletProviders = walletProviders;
    }

    public WalletProviders getServiceprovider() {
        return this.walletProviders;
    }

    public WalletAcc(String username, String password, double balance, User user) {
        super(username, password, balance, user);
    }

    @Override
    public void addMoney(double amount) {
        this.setBalance(this.getBalance() + amount);
        walletProviders.setBalance(getUser().getPhoneNumber(), getBalance());
    }

    @Override
    public boolean deductMoney(double amount) {
        if(this.getBalance()>=amount){
            double newAmount=this.getBalance()-amount;
            this.setBalance(newAmount);
            walletProviders.setBalance(getUser().getPhoneNumber(), newAmount);
            return true;
        }
        return false;
    }
}
