package Databases_And_APIs;

import UserPack.User;

public class Authentication {
    public static User login(String userName , String password){
        SystemDatabase database= new SystemDatabase();
        if (database.checkUsernameAndPassword(userName , password)){
            return database.getUserByUsername(userName);
        }else {
            return null;
        }
    }
}
