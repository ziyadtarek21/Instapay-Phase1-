package walletProviders;

public class OrangeWallet extends WalletProviders{
    private String phoneNumber;
    public OrangeWallet(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    @Override
    protected void initializeData() {
        wallets.put("01264250226", 456.1);
        wallets.put("01264250227", 50.0);
        wallets.put("01264250228", 45555.1);
        wallets.put("01264250229", 500.);
        wallets.put("01264250221", 600.0);
        wallets.put("01264250222", 700.0);
        wallets.put("01264250223", 8000.0);
        wallets.put("01264250224", 9000.0);
        wallets.put("01264250225", 10000.0);
    }

    @Override
    public boolean makePayment(double amount) {
        if (this.returnBalance(this.phoneNumber) >= amount) {
            this.setBalance(this.phoneNumber , this.returnBalance(this.phoneNumber) - amount);
            System.out.println("Payment of " + amount + " made using Orange Wallet.");
            return true;
        } else {
            System.out.println("Insufficient balance in Orange Wallet.");
            return false;
        }
    }
}
