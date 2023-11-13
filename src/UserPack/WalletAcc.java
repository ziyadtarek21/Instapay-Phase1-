package UserPack;

public class WalletAcc extends Account {
    private String Serviceprovider;
    public void setServiceprovider(String serviceprovider) {
        Serviceprovider = serviceprovider;
    }

    public String getServiceprovider() {
        return Serviceprovider;
    }

    public WalletAcc(String username, String password, double balance) {
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
