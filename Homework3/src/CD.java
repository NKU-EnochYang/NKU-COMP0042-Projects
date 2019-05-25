import java.util.ArrayList;

public class CD
{
    class info
    {
        private String name;
        private int amount;
        private int rent = 0;
        public info(String name, int amount)
        {
            this.name = name;
            this.amount = amount;
        }
        public String getName()
        {
            return this.name;
        }
        public int getAmount()
        {
            return this.amount;
        }
        public int getRent()
        {
            return this.rent;
        }
        public void setRent(int rent)
        {
            this.rent = rent;
        }
        public void setAmount(int amount)
        {
            this.amount = amount;
        }
    }
    ArrayList<info> all_cd;
    public CD()
    {
        this.all_cd = new ArrayList<info>();
    }
    public void rentCD(String name, int amount)
    {
        for(int i = 0;i<this.all_cd.size();i++)
        {
            if(this.all_cd.get(i).getName().equals(name))
            {
                if(this.all_cd.get(i).getAmount() < amount ||
                        this.all_cd.get(i).getAmount() - this.all_cd.get(i).getRent() < amount)
                {
                    System.out.println("所选CD余量不足，无法租借");
                    return;
                }
                else
                {
                    int temp = this.all_cd.get(i).getRent();
                    temp += amount;
                    this.all_cd.get(i).setRent(temp);
                }
            }
        }
    }
    public void sellCD(String name, int amount)
    {
        for(int i = 0;i<this.all_cd.size();i++)
        {
            if(this.all_cd.get(i).getName().equals(name))
            {
                if(this.all_cd.get(i).getAmount() < amount ||
                        this.all_cd.get(i).getAmount() - this.all_cd.get(i).getRent() < amount)
                {
                    System.out.println("所选CD余量不足，无法销售");
                    return;
                }
                else
                {
                    int temp = this.all_cd.get(i).getAmount();
                    temp -= amount;
                    this.all_cd.get(i).setAmount(temp);
                }
            }
        }
    }
    public void addCD(String name, int amount)
    {
        for(int i = 0;i<this.all_cd.size();i++)
        {
            if(this.all_cd.get(i).getName().equals(name))
            {
                int temp = this.all_cd.get(i).getAmount();
                temp += amount;
                this.all_cd.get(i).setAmount(temp);
            }
        }
        info temp = new info(name, amount);
        this.all_cd.add(temp);
    }
    public void countCD()
    {
        for(int i = 0;i<this.all_cd.size();i++)
        {
            System.out.println("CD name: " + this.all_cd.get(i).getName() +
                    "; amount: " + this.all_cd.get(i).getAmount() +
                    "; renting: " + this.all_cd.get(i).getRent());
        }
    }
}
