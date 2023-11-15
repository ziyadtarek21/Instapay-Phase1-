package walletProviders;



import Databases_And_APIs.SystemDatabase;

import java.util.HashMap;

public abstract class WalletProviders {
    protected HashMap<String , Double> wallets;
    public WalletProviders() {
        this.wallets = new HashMap<>();
        initializeData();
    }
    abstract void initializeData();

    public double returnBalance(String walletNumber) {
        return wallets.get(walletNumber);
    }

    public void setBalance(String walletNumber, double balance) {
        wallets.put(walletNumber, balance);

    }

    public boolean verifyPhoneNumber(String walletNumber) {
        return wallets.containsKey(walletNumber);
    }

    public boolean receiveMoney(String walletNumber, double amount) {
        if (amount >= 0 && verifyPhoneNumber(walletNumber)) {
            setBalance(walletNumber, returnBalance(walletNumber) + amount);
            return true;
        }
        System.out.println("This account doesn't exist!");
        return false;
    }

    public abstract boolean makePayment(double amount);

}
