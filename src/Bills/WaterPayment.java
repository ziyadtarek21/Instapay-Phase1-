package Bills;

import Databases_And_APIs.GasAPI;
import Databases_And_APIs.WaterAPI;
import UserPack.Account;

public class WaterPayment implements BillPaymentStrategy{
    @Override
    public void pay(Account account, String countNumber) {
        if(WaterAPI.findWaterCounter(countNumber)){
            if(account.getBalance() >= WaterAPI.getAmount(countNumber)){
                double balance = account.getBalance();
                account.setBalance(balance - WaterAPI.getAmount(countNumber));
                WaterAPI.pay(countNumber);
                System.out.println("The Payment Has Been Done Successfully!");
            } else{
                System.out.println("There isn't enough money!");
            }
        } else{
            System.out.println("Wrong Counter Number!");
        }
    }
}
