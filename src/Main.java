import Bills.BillPaymentContext;
import Bills.ElectricityPayment;
import Bills.GasPayment;
import Bills.WaterPayment;
import Databases_And_APIs.Authentication;
import Register.RegistrationManager;
import Transactions.*;
import UserPack.Account;
import UserPack.*;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome to our Instapay clone");
        boolean signedIn = false;
        Account signedAcc = null;
        Scanner scanner = new Scanner(System.in);
        User currnetuser=null;
        while (true){
            if(!signedIn){

                System.out.println("do you want to sign in or login ?");
                System.out.println("1.register");
                System.out.println("2.login ");
                int x = scanner.nextInt();
                if(x == 1){
                    RegistrationManager registrationManager = new RegistrationManager();
                    if(registrationManager.doRegister()){
                        System.out.println("Regestration sucssesful , You can LogIn now");

                    }
                    else{
                        System.out.println("Regestration failed nigga");
                    }
                } else if (x == 2){
                        String username;
                        String passwrd;
                    System.out.println("Please Enter Username");
                    username=scanner.next();
                    System.out.println("Please Enter Password");
                    passwrd=scanner.next();
                    if(Authentication.login(username,passwrd)!=null){
                        currnetuser=Authentication.login(username,passwrd);
                        signedAcc= currnetuser.getAcc();
                        System.out.println("login sucssesful");
                        signedIn=true;
                    }
                    else{
                        System.out.println("Login Failed");
                    }
                } else {
                    System.out.println("Please choose right number");
                }
            }

            else{
                while (signedIn){
                    System.out.println(currnetuser.getAcc().getUsername());
                    System.out.println("Balance: "+currnetuser.getAcc().getBalance());
                    boolean bank=false;
                    if(currnetuser.getAcc()instanceof WalletAcc){
                        System.out.println("Wallet Account");
                    }
                    else{
                        bank=true;
                        System.out.println("Bank Account");
                    }
                    System.out.println("Menu:");
                    System.out.println("1-Pay bills");
                    System.out.println("2-Transfer Money");
                    System.out.println("3-LogOut");
                    int choice;
                    choice=scanner.nextInt();
                    if(choice==1){
                        BillPaymentContext b= new BillPaymentContext();
                        System.out.println("choose what kind of bills");
                        while (true){
                            System.out.println("1-Gas");
                            System.out.println("2-Water");
                            System.out.println("3-Electricity");
                            System.out.println("4-cancel");
                            int choicebills;
                            choicebills=scanner.nextInt();
                            if(choicebills==1){
                                String counternum;
                                System.out.println("enter counter number");
                                counternum=scanner.next();
                                b.strategy=new GasPayment();
                                b.doPayment(signedAcc,counternum);
                            }
                            else if(choicebills==2){
                                String counternum;
                                System.out.println("enter counter number");
                                counternum=scanner.next();
                                b.strategy=new WaterPayment();
                                b.doPayment(signedAcc,counternum);
                            }
                            else if(choicebills==3){
                                String counternum;
                                System.out.println("enter counter number");
                                counternum=scanner.next();
                                b.strategy=new ElectricityPayment();
                                b.doPayment(signedAcc,counternum);
                            }
                            else if(choicebills==4){
                                break;
                            }
                        }
                    }
                    else if(choice==2){
                        TransferManger t=new TransferManger();
                        while (true){
                            if(bank){
                                System.out.println("1-Send by username");
                                System.out.println("2-send to bank account");
                                System.out.println("3-send to wallet");
                                System.out.println("4-cancel");
                            }
                            else{
                                System.out.println("1-Send by username");
                                System.out.println("2-send to wallet");
                                System.out.println("3-cancel");
                            }
                            int choicetrans;
                            choicetrans=scanner.nextInt();
                            if(choicetrans==1){
                                t.transfer=new AccountTransfer();
                                t.manageTransfer(signedAcc);
                            }
                            else if(choicetrans==2&&!bank){
                                t.transfer=new PhoneTransfer();
                                t.manageTransfer(signedAcc);
                            }
                            else if(choicetrans==2&&bank){
                                t.transfer=new BankTransfer();
                                t.manageTransfer(signedAcc);
                            }
                            else if(choicetrans==3&&!bank){
                                break;
                            }
                            else if(choicetrans==3&&bank){
                                t.transfer=new PhoneTransfer();
                                t.manageTransfer(signedAcc);
                            }
                            else if(choicetrans==4&&bank){
                                break;
                            }
                            else{
                                System.out.println("Invalid choice");
                            }
                        }

                    }
                    else if(choice==3){
                        signedIn=false;
                    }
                    else{
                        System.out.println("Invalid choice");
                    }

                }


            }
        }
    }
}