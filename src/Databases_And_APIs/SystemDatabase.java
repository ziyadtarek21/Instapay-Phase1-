package Databases_And_APIs;

import UserPack.Account;
import UserPack.User;

import java.util.HashMap;
import java.util.Map;

public class SystemDatabase {
    static Map<String, User> users = new HashMap<String, User>(){{
        // add dummy users
    }};

    static void addUser(User user){
        users.put(user.getAcc().getUsername(), user);
    }

    User getUserByUsername(String username){
        return users.get(username);
    }

    Account getAccountByUsername(String username){
        return users.get(username).getAcc();
    }

    boolean checkUsernameAndPassword(String username, String password){
        return users.get(username).getAcc().getPassword().equals(password);
    }
}
