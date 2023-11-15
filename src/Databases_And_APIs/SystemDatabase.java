package Databases_And_APIs;
import UserPack.Account;
import UserPack.BankAcc;
import UserPack.User;
import UserPack.WalletAcc;
import walletProviders.VodafoneWallet;
import java.util.HashMap;
import java.util.Map;
public class SystemDatabase {
    static Map<String, User> users = new HashMap<String, User>(){};
     SystemDatabase(){
        //bankacc2
        User user1 = new User("remon", "atef", "01091820070","654");
        user1.setAcc(new BankAcc("RemoElPremo", "123456", 98465.5, user1));
        users.put("RemoElPremo", user1);
        //bankacc1
        User user3 = new User("remon", "atef", "01091820070","654");
        user3.setAcc(new BankAcc("z", "123456", 98465.5, user1));
        users.put("z", user3);


        //wallet1
        User user2 = new User("ahmed", "mohamed", "01064250226","451320");
        user2.setAcc(new WalletAcc("idk", "123456", 6541.45, user2));
        WalletAcc w=(WalletAcc)user2.getAcc();
        VodafoneWallet v=new VodafoneWallet("010642502226");
        w.setServiceprovider(v);
        users.put("idk", user2);

        //wallet2
        User user4 = new User("ahmed", "mohamed", "01064250227","451320");
        user4.setAcc(new WalletAcc("idk1", "123456", 6541.45, user2));
        WalletAcc w1=(WalletAcc)user4.getAcc();
        VodafoneWallet v1=new VodafoneWallet("010642502226");
        w1.setServiceprovider(v1);
        users.put("idk1", user4);

    }
    public static boolean checkUsername(String username) {
        return users.containsKey(username);
    }
    public static void addUser(User user){
        users.put(user.getAcc().getUsername(), user);
    }
    public static boolean receiveMoney(String info, double input,boolean ifwallet) {
        if(input >= 0 && getAccountByUsername(info) != null){
            Account account = getAccountByUsername(info);
            if (account instanceof BankAcc&&ifwallet){
                return false;
            }
            account.setBalance(account.getBalance()+input);
            return true;
        }
        System.out.println("this account doesn't exist!");
        return false;
    }
    static User getUserByUsername(String username){
        if(users.containsKey(username))
            return users.get(username);
        return null;
    }

    public static Account getAccountByUsername(String username){
        return users.get(username).getAcc();
    }
    static boolean checkUsernameAndPassword(String username, String password){
        return users.get(username).getAcc().getPassword().equals(password);
    }
}
