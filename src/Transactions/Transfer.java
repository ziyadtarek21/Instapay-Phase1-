package Transactions;

import UserPack.Account;

public interface Transfer {
    boolean transfer(Account account, String info);
}
