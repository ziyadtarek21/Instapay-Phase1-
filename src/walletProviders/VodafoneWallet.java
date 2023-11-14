package walletProviders;

public class VodafoneWallet extends WalletProviders{
    private String phoneNumber;
    public VodafoneWallet(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    protected void initializeData() {
        wallets.put("01064250226", 456.1);
        wallets.put("01064250227", 50.0);
        wallets.put("01064250228", 45555.1);
        wallets.put("01064250229", 500.);
        wallets.put("01064250221", 600.0);
        wallets.put("01064250222", 700.0);
        wallets.put("01064250223", 8000.0);
        wallets.put("01064250224", 9000.0);
        wallets.put("01064250225", 10000.0);
    }

    @Override
    public boolean makePayment(double amount) {
        if (this.returnBalance(this.phoneNumber) >= amount) {
            this.setBalance(this.phoneNumber , this.returnBalance(this.phoneNumber) - amount);
            System.out.println("Payment of " + amount + " made using Vodafone Wallet.");
            return true;
        } else {
            System.out.println("Insufficient balance in Vodafone Wallet.");
            return false;
        }
    }
}
