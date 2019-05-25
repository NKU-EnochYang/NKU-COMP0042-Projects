import java.util.ArrayList;

public class Member
{
    class User
    {
        private String name;
        private int id;
        public User(int i_id, String i_name)
        {
            id = i_id;
            name = i_name;
        }
        public String getName()
        {
            return name;
        }
        public int getId()
        {
            return id;
        }
    }
    private ArrayList<User> member;
    public Member()
    {
        member = new ArrayList<User>();
    }
    public void add_member(int id, String name)
    {
        for(int i = 0;i<member.size();i++)
        {
            if (member.get(i).getId() == id)
            {
                System.out.println("ID已存在，无法添加！");
                return;
            }
        }
        User n_member = new User(id, name);
        member.add(n_member);
    }
    public void delete_member(int id)
    {
        for(int i = 0;i<member.size();i++)
        {
            if(member.get(i).getId() == id)
            {
                member.remove(i);
                return;
            }
        }
        System.out.println("无此ID用户，无法删除！");
    }
    public void print_member()
    {
        for(int i = 0;i<member.size();i++)
        {
            System.out.println("ID: " + member.get(i).getId() +
                    "; Name: " + member.get(i).getName());
        }
    }
}
