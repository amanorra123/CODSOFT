import java.util.HashMap;
import java.util.Map;
public class ImplementFun implements Interfaces{
    Atm atm=new Atm();
    HashMap<Double,String> map=new HashMap<>();

    @Override
    public void ViewBalance(){
        System.out.println("Available balance is: "+atm.getBalance());
    }

    @Override
    public void DepositMoney(double depositmoney){
        map.put(depositmoney,"Money added");
        atm.setBalance(atm.getBalance()+depositmoney);
        System.out.println("Money added successfully: "+depositmoney);
        ViewBalance();
    }

    @Override
    public void WithDrawMoney(double withdrawmoney){
        if(withdrawmoney<=atm.getBalance()){
            map.put(withdrawmoney,"Money Withdrawn");
            System.out.println("Amount withdrawn successfully: "+withdrawmoney);
            atm.setBalance(atm.getBalance()-withdrawmoney);
            ViewBalance();
        }else{
            System.out.println("\nInsufficient balance");
            ViewBalance();

        }
    }

    @Override
    public void ViewStatement(){
        for(Map.Entry<Double,String> e:map.entrySet()){
            System.out.println(e.getValue()+" "+e.getKey());
        }

    }
}