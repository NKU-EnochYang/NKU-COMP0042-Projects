import java.util.Scanner;

public class Test
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("x1 y1: ");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        System.out.print("x2 y2: ");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();
        System.out.print("x3 y3: ");
        double x3 = sc.nextDouble();
        double y3 = sc.nextDouble();
        System.out.print("x4 y4: ");
        double x4 = sc.nextDouble();
        double y4 = sc.nextDouble();
        MyPoint p1 = new MyPoint(x1, y1);
        MyPoint p2 = new MyPoint(x2, y2);
        MyPoint p3 = new MyPoint(x3, y3);
        MyPoint p4 = new MyPoint(x4, y4);
        MyLine line1 = new MyLine(p1, p2);
        MyLine line2 = new MyLine(p3, p4);
        System.out.print("line1的点：");
        line1.printLine();
        System.out.print("line2的点：");
        line2.printLine();
        System.out.println("line1的check方法：" + line1.check());
        System.out.println("line1的length方法：" + line1.length());
        System.out.println("isIntersected方法(line1和line2)：" + line1.isIntersected(line2));
        System.out.println("distance方法(p4到line1)：" + line1.distance(p4));
    }
}
