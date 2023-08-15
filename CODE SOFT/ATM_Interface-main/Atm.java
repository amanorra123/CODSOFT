class Atm{
    private double balance;
    private double depositmoney;
    private double withdrawmoney;

    public Atm(){}

    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance=balance;
    }

    public double getDepositMoney(){
        return depositmoney;
    }
    public void setDepositMoney(double depositmoney){
        this.depositmoney=depositmoney;
    }

    public double getwithDrawMoney(){
        return withdrawmoney;
    }
    public void setwithDrawMoney(double withdrawmoney){
        this.withdrawmoney=withdrawmoney;
    }
}