package Databases_And_APIs;

import UserPack.Account;
import UserPack.BankAcc;
import UserPack.User;

import java.util.HashMap;
import java.util.Map;

public class SystemDatabase {
    static Map<String, User> users = new HashMap<String, User>(){};

    SystemDatabase(){
        User user1 = new User("remon", "atef", "01091820070","654");
        user1.setAcc(new BankAcc("RemoElPremo", "123456", 98465.5));
        users.put("remo", user1);

        User user2 = new User("ahmed", "mohamed", "97612","451320");
        user2.setAcc(new BankAcc("idk", "123456", 6541.45));
        users.put("ahmed", user2);


    }

    static void addUser(User user){
        users.put(user.getAcc().getUsername(), user);
    }

    public static boolean receiveMoney(String info, double input) {
        if(input >= 0 && getAccountByUsername(info) != null){


            // check if this really works or is it a pass by value shit
                //  |
                 // \/
            Account account = getAccountByUsername(info);
            account.setBalance(account.getBalance()+input);
            return true;
        }
        System.out.println("this account doesn't exist!");
        return false;
    }

    User getUserByUsername(String username){
        if(users.containsKey(username))
            return users.get(username);
        return null;
    }

    static Account getAccountByUsername(String username){
        return users.get(username).getAcc();
    }

    boolean checkUsernameAndPassword(String username, String password){
        return users.get(username).getAcc().getPassword().equals(password);
    }
}
