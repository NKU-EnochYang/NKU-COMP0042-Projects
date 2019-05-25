public class MyLine
{
    private MyPoint p1;
    private MyPoint p2;

    public MyLine(MyPoint i1, MyPoint i2)
    {
        this.p1 = i1;
        this.p2 = i2;
    }

    public void printLine()
    {
        System.out.println("(" + p1.GetX() + ", " + p1.GetY() + ")" + " " +
                "(" + p2.GetX() + ", " + p2.GetY() + ")");
    }

    public boolean check()
    {
        return (p1.GetX() > 0 && p1.GetY() > 0 && p2.GetX() > 0 && p2.GetY() > 0);
    }

    public double length()
    {
        return Math.sqrt((p1.GetX() - p2.GetX()) * (p1.GetX() - p2.GetX()) +
                (p1.GetY() - p2.GetY()) * (p1.GetY() - p2.GetY()));
    }

    public boolean isIntersected(MyLine temp)
    {
//        构造两条线段的参数表达式来判断是否相交，
//        行列式为a, b   k   res1
//        　　　　c, d * m = res2
        double a = p2.GetX() - p1.GetX();
        double b = temp.p1.GetX() - temp.p2.GetX();
        double c = p2.GetY() - p1.GetY();
        double d = temp.p1.GetY() - temp.p2.GetY();
        double res1 = temp.p1.GetX() - p1.GetX();
        double res2 = temp.p1.GetY() - p1.GetY();
        double f = a * d - b * c;
//        如果秩为０，则平行或重合
        if (Math.abs(f) < 1.0e-6)
            return false;
        double k = (d * res1 - b * res2) / f;
        double m = (a * res2 - c * res1) / f;
//        k或m在０到１之间时相交
        return !(k < 0 || k > 1 || m < 0 || k > 1);
    }

    public double distance(MyPoint temp)
    {
//        直接用表达式算
        double a = p2.GetY() - p1.GetY();
        double b = p1.GetX() - p2.GetX();
        double c = p2.GetX() * p1.GetY() - p2.GetY() * p1.GetX();
        return Math.abs(a * temp.GetX() + b * temp.GetY() + c) / Math.sqrt(a * a + b * b);
    }

//    再写其他方法感觉都没什么特别的，这里就不实现其他的了
}
