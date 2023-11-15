package walletProviders;

public class EtisalatWallet extends WalletProviders {
    private String phoneNumber;
    public EtisalatWallet(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    @Override
    protected void initializeData() {
        wallets.put("01164250226", 456.1);
        wallets.put("01164250227", 50.0);
        wallets.put("01164250228", 45555.1);
        wallets.put("01164250229", 500.);
        wallets.put("01164250221", 600.0);
        wallets.put("01164250222", 700.0);
        wallets.put("01164250223", 8000.0);
        wallets.put("01164250224", 9000.0);
        wallets.put("01164250225", 10000.0);
    }

    @Override
    public boolean makePayment(double amount) {
        if (this.returnBalance(this.phoneNumber) >= amount) {
            this.setBalance(this.phoneNumber , this.returnBalance(this.phoneNumber) - amount);
            System.out.println("Payment of " + amount + " made using Etisalat Wallet.");
            return true;
        } else {
            System.out.println("Insufficient balance in Etisalat Wallet.");
            return false;
        }
    }
}
