import java.util.*;
public class MainClass{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        Interfaces obj=new ImplementFun();

        int AtmNo=12345;
        int AtmPin=8840;

        System.out.println("Enter Atm Number");
        int atmno=sc.nextInt();
        System.out.println("Enter Atm Pin");
        int atmpin=sc.nextInt();

        if(atmno==AtmNo && atmpin==AtmPin){
            while(true){
                System.out.println("\nPress 1 to View Balance\nPress 2 to Widdraw\nPress 3 to Deposit\nPress 4 to View Statement\nPress 5 to Exit");
                int inpkey=sc.nextInt();

                if(inpkey==1){
                    obj.ViewBalance();
                }
                else if(inpkey==2){
                    System.out.println("Enter the amount to Withdraw");
                    double amt=sc.nextDouble();
                    obj.WithDrawMoney(amt);
                }
                else if(inpkey==3){
                    System.out.println("Enter the amount to deposit");
                    double amt=sc.nextDouble();
                    obj.DepositMoney(amt);
                }
                else if(inpkey==4){
                    obj.ViewStatement();
                }
                else if(inpkey==5){
                    System.exit(0);
                }
                else{
                    System.out.println("Something went wrong! PLEASE TRY AGAIN");
                }

                System.out.println("\nPress any key to continue\nPress 0 to exit");
                inpkey=sc.nextInt();
                if(inpkey==0){
                    System.exit(0);
                }
            }
        }else{
            System.out.println("Invalid Atm Number oo Atm Pin");
            System.exit(0);
        }
    }
}