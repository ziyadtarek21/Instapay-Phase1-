package Transactions;

import UserPack.Account;

import java.util.Scanner;

public class TransferManger {
    public Transfer transfer;

    void setTransfer(Transfer transfer){
        this.transfer = transfer;
    }
    /*
    * احذر حنيكه من ريمو تم اضافه parameters ل function manage transfer
    * */
   public void manageTransfer(Account account){
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the info of the other account: ");
        String input = scanner.nextLine();
        if(transfer.transfer(account, input)){
            System.out.println("the process has been done successfully!");
        } else{
            System.out.println("there is something went wrong!");
        }
    }
}
