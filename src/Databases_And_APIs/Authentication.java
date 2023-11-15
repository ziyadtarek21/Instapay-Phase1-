package Databases_And_APIs;

import UserPack.User;

public class Authentication {
    public static User login(String userName , String password){
        if (SystemDatabase.checkUsernameAndPassword(userName , password)){
            return SystemDatabase.getUserByUsername(userName);
        }else {
            return null;
        }
    }
}
