import java.util.Properties;

public class main
{
    public static void main(String []args)
    {
        if(args.length == 0)
        {
            Properties props = System.getProperties();
            props.list(System.out);
        }
        else
        {
            Properties props = System.getProperties();
            if(props.getProperty(args[0]) == null)
            {
                System.out.println("No that properties!");
            }
            else
            {
                System.out.println(args[0] + "=" + props.getProperty(args[0]));
            }
        }
    }
}
