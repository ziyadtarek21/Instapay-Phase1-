package Bills;

import Databases_And_APIs.ElectricityAPI;
import Databases_And_APIs.GasAPI;
import UserPack.Account;

public class GasPayment implements BillPaymentStrategy{
    @Override
    public void pay(Account account, String countNumber) {
        if(GasAPI.findGasCounter(countNumber)){
            if(account.getBalance() >= GasAPI.getAmount(countNumber)){
                account.deductMoney(GasAPI.getAmount(countNumber));
                GasAPI.pay(countNumber);
                System.out.println("The Payment Has Been Done Successfully!");
            } else{
                System.out.println("There isn't enough money!");
            }
        } else{
            System.out.println("Wrong Counter Number!");
        }
    }
}
