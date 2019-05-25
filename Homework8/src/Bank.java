import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ArrayBlockingQueue;

public class Bank {
    public static void main(String args[])throws Exception{
        Customers customers = new Customers(20);
        RandomCustomer customer = new RandomCustomer(customers);
        Staff staff = new Staff(customers);
        System.out.println("--------银行上班--------");
        customer.start();
        staff.start();
        TimeUnit.SECONDS.sleep(5);
        customer.exit = true;
        TimeUnit.SECONDS.sleep(4);
        staff.exit = true;
        TimeUnit.SECONDS.sleep(1);
    }
}

class Customer {
    private int time;
    private int balance;
    private int money;
    private int op;

    public Customer(int serviceTime, int balance, int i_op, int money) {
        this.time = serviceTime;
        this.balance = balance;
        this.money = money;
        this.op = i_op;
    }

    public int getBalance() {
        return balance;
    }

    public int getMoney() {
        return money;
    }

    public int getTime() {
        return time;
    }

    public int getOp() {
        return op;
    }

    public boolean opt(int op) {
        if(op == 0) {
            if(money<=balance) {
                balance -= money;
                System.out.println("取款成功："+money+" 余额："+this.balance);
                return true;
            }
            else {
                System.out.println("取款失败：" + money + " 余额不足：" + this.balance);
                return false;
            }
        }
        else if(op == 1){
            balance += money;
            System.out.println("存款成功：" + money + " 余额：" + this.balance);
            return true;
        }
        return false;
    }
}

class Customers extends ArrayBlockingQueue<Customer> {
    public Customers(int maxSize) {
        super(maxSize);
    }
}

class RandomCustomer extends Thread
{
    public boolean exit = false;
    private Customers customers;

    public RandomCustomer(Customers customers) {
        this.customers = customers;
    }

    public void run()
    {
        Random rand = new Random();
        try{
            while(!exit) {
                TimeUnit.MILLISECONDS.sleep(rand.nextInt(1000));
                customers.put(new Customer(rand.nextInt(1000),rand.nextInt(1000),rand.nextInt(2),rand.nextInt(1000)));  //随机的顾客需求
            }
        }
        catch (InterruptedException e) {
            System.out.println("Customer Thread Interrupted. ");
            e.printStackTrace();
        }
    }
}

class Staff extends Thread
{
    public boolean exit = false;
    private int customersServed = 0;
    private Customers customers;
    public int totalMoney = 10000;

    public Staff(Customers customers)
    {
        this.customers = customers;
    }

    public void run()
    {
        try
        {
            while(!exit) {
                if(customers.size() == 0){
                    continue;
                }
                Customer customer = customers.take();
                TimeUnit.MILLISECONDS.sleep(customer.getTime());
                if(customer.getOp() == 1){
                    customer.opt(customer.getOp());
                    totalMoney += customer.getMoney();
                }
                else{
                    customer.opt(customer.getOp());
                    totalMoney -= customer.getMoney();
                }
                synchronized(this)
                {
                    customersServed++;
                    System.out.println("当前顾客号："+customersServed);
                    System.out.println("当前等待人数："+customers.size());
                    System.out.println("银行余额："+totalMoney);
                }
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("Staff Thread Interrupted. ");
            e.printStackTrace();
        }

        System.out.println("--------银行下班--------");
    }
}