package UserPack;

import Databases_And_APIs.WalletProviderAPI;

public class WalletAcc extends Account {
    private String Serviceprovider;
    public void setServiceprovider(String serviceprovider) {
        Serviceprovider = serviceprovider;
    }

    public String getServiceprovider() {
        return Serviceprovider;
    }

    public WalletAcc(String username, String password, double balance, User user) {
        super(username, password, balance, user);
    }

    @Override
    public void addMoney(double amount) {
        this.setBalance(amount);
        WalletProviderAPI.setBalance(getUser().getPhoneNumber(), getBalance());
    }

    @Override
    public boolean deductMoney(double amount) {
        if(this.getBalance()>=amount){
            double newmon=this.getBalance()-amount;
            this.addMoney(newmon);
            WalletProviderAPI.setBalance(getUser().getPhoneNumber(), getBalance());
            return true;
        }
        return false;
    }


}
