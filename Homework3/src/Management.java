import java.util.Scanner;

public class Management
{
    private Member member;
    private CD cd;
    private Scanner sc;
    public Management()
    {
        member = new Member();
        cd = new CD();
        sc = new Scanner(System.in);
    }
    public void run()
    {
        while(true)
        {
            System.out.println("请选择工作模式：1. 会员管理；2. CD租售");
            int state = sc.nextInt();
            if(state == 1) { member_manage(); }
            else if(state == 2) { cd_manage(); }
            else
            {
                System.out.println("No that choice! ");
                continue;
            }
        }
    }
    private void member_manage()
    {
        while(true)
        {
            System.out.println("请选择工作模式：1.增加会员；2.删除会员；3.输出已有会员信息");
            int state = sc.nextInt();
            if(state == 1)
            {
                System.out.println("请输入会员ID、会员名：");
                int id = sc.nextInt();
                String name = sc.next();
                member.add_member(id, name);
            }
            else if(state == 2)
            {
                System.out.println("请输入要删除的会员ID:");
                int id = sc.nextInt();
                member.delete_member(id);
            }
            else if(state == 3)
            {
                member.print_member();
            }
            else
            {
                System.out.println("No that choice! ");
                continue;
            }
        }
    }
    private void cd_manage()
    {
        while (true)
        {
            System.out.println("请选择工作模式：1.出租CD；2.售卖CD；3.买进CD；4.统计CD信息");
            int state = sc.nextInt();
            if(state == 1)
            {
                System.out.println("请输入要出租的CD名字、出租数量：");
                String name = sc.next();
                int amount = sc.nextInt();
                cd.rentCD(name, amount);
            }
            else if(state == 2)
            {
                System.out.println("请输入要售卖的CD名字、售卖数量：");
                String name = sc.next();
                int amount = sc.nextInt();
                cd.sellCD(name, amount);
            }
            else if(state == 3)
            {
                System.out.println("请输入要买进的CD名字、买进数量：");
                String name = sc.next();
                int amount = sc.nextInt();
                cd.addCD(name, amount);
            }
            else if(state == 4)
            {
                cd.countCD();
            }
            else
            {
                System.out.println("No that choice! ");
                continue;
            }
        }
    }
}
