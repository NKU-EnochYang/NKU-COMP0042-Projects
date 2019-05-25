import java.util.Calendar;
import java.util.Scanner;

public class PrintCalender
{
    public static void main(String[] args)
    {
        Calendar calendar = Calendar.getInstance();
        int count = 1;
        int days;
        Scanner sc=new Scanner(System.in);
        System.out.print("请输入年份：");
        int year = sc.nextInt();
        System.out.print("请输入月份：");
        int month = sc.nextInt();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DATE, 0);
        if (((year % 4 == 0 && year % 100 != 0)||(year % 400 == 0)) && month == 2)
        {
            days = 29;
        }
        else
        {
            days = DayNum(month);
        }
        System.out.println(year + "年" + month + "月");
        System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
        while (count <=days)
        {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            int day = calendar.getTime().getDay();
            if (count ==1)
            {
                for (int i = 0; i < day; i++)
                {
                    System.out.print("\t");
                }
            }
            if (day == 0)
            {
                System.out.println();
            }
            System.out.print(calendar.get(Calendar.DATE) + "\t");
            count++;
        }

    }

    private static int DayNum(int n) {
        int num = 0;
        switch (n)
        {
            case 2:
                num = 28;
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                num = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                num = 30;
                break;
        }
        return num;
    }
}
