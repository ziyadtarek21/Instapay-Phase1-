package Bills;

import UserPack.Account;

public interface BillPaymentStrategy {
    void pay(Account account, String countNumber);
}
