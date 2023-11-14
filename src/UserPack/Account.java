package UserPack;

public abstract class Account {
    private String username;
    private String password;
    private double balance;

    public User getUser() {
        return u;
    }

    public User u;

    public Account(String username, String password, double balance, User user) {
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.u = user;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setUser(User u) {

        this.u = u;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public abstract void addMoney(double amount);
    public abstract boolean deductMoney(double amount);

}
