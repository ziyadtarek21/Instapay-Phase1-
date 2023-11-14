package Bills;

import Databases_And_APIs.ElectricityAPI;
import UserPack.Account;

public class ElectricityPayment implements BillPaymentStrategy{
    public void pay(Account account, String countNumber) {
        if(ElectricityAPI.findElectricityCounter(countNumber)){
            if(account.getBalance() >= ElectricityAPI.getAmount(countNumber)){
                double balance = account.getBalance();
                account.setBalance(balance - ElectricityAPI.getAmount(countNumber));
                ElectricityAPI.pay(countNumber);
                System.out.println("The Payment Has Been Done Successfully!");
            } else{
                System.out.println("There isn't enough money!");
            }
        } else{
            System.out.println("Wrong Counter Number!");
        }
    }
}
