package Bills;

import UserPack.Account;

public class BillPaymentContext {
    private BillPaymentStrategy strategy;

    public void doPayment(Account account, String counterNumber){
        strategy.pay(account, counterNumber);
    }
}
