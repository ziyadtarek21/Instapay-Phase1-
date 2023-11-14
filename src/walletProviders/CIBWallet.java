package walletProviders;

public class CIBWallet extends WalletProviders{
    private String accountNumber;

    public CIBWallet(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    protected void initializeData() {
        wallets.put("CIB123456789", 5000.0);
        wallets.put("CIB987654321", 10000.0);
        wallets.put("CIB111223344", 7500.0);
        wallets.put("CIB555666777", 3000.0);
        wallets.put("CIB888999000", 12000.0);
        wallets.put("CIB444333222", 6000.0);
        wallets.put("CIB777888999", 9000.0);
        wallets.put("CIB666555444", 8500.0);
        wallets.put("CIB222111000", 4000.0);
        wallets.put("CIB999000111", 11000.0);
    }

    @Override
    public boolean makePayment(double amount) {
        if (this.returnBalance(this.accountNumber) >= amount) {
            this.setBalance(this.accountNumber , this.returnBalance(this.accountNumber) - amount);
            System.out.println("Payment of " + amount + " made using CIB Wallet.");
            return true;
        } else {
            System.out.println("Insufficient balance in CIB Wallet.");
            return false;
        }
    }
}
