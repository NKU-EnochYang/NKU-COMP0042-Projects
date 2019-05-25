public class PrintPrime
{
    public static void main(String[] args)
    {
        int num = 0;
        for(int i = 2;i<=100;i++)
        {
            if(isprime(i) && num < 4)
            {
                System.out.print(i + " ");
                num += 1;
            }
            else if(isprime(i) && num == 4)
            {
                System.out.println(i);
                num = 0;
            }
        }
    }

    private static boolean isprime(int num)
    {
        for (int i = 2;i<num;i++)
        {
            if(num%i == 0)
            {
                return false;
            }
        }
        return true;
    }
}
