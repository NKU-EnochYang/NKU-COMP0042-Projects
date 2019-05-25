import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Calculator extends JFrame implements ActionListener
{
    private String[] opts = {"sin", "MC", "7", "8", "9", "+", "Back",
            "cos", "MR", "4", "5", "6", "-", "Clear",
            "tan", "MS", "1", "2", "3", "*", " ",
            "+/-", "M+", "0", ".", "=", "/", " "};
    private JButton[] buttons = new JButton[opts.length];
    private JTextField output = new JTextField("0");
    private double cache = 0.0;
    private String opr = "=";
    private double cal_res = 0.0;
    private boolean first_sign = true;

    public Calculator()
    {
        super();
        init();
        this.setLocation(500, 300);
        this.setTitle("Calculator of YANG YANG");
        this.pack();
    }

    public static void main(String args[])
    {
        Calculator my_cal = new Calculator();
        my_cal.setVisible(true);
    }
    private void init()
    {
        output.setHorizontalAlignment(JTextField.RIGHT);
        output.setEditable(false);
        JPanel text_panel = new JPanel();
        text_panel.setLayout(new BorderLayout());
        text_panel.add(output, BorderLayout.CENTER);
        JPanel buttons_panel = new JPanel();
        buttons_panel.setLayout(new GridLayout(4, 7));
        for(int i = 0;i<buttons.length;i++)
        {
            buttons[i] = new JButton(opts[i]);
            buttons[i].addActionListener(this);
        }

        for(int i = 0;i<buttons.length;i++)
            buttons_panel.add(buttons[i]);
        setLayout(new BorderLayout());
        add(text_panel, BorderLayout.NORTH);
        add(buttons_panel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e)
    {
        String clicked = e.getActionCommand();
        if("0123456789.".contains(clicked))
            num(clicked);
        else if(clicked.contains("M"))
            m(clicked);
        else if(clicked.equals("Back"))
            back();
        else if(clicked.equals("Clear"))
            clear();
        else
            cal(clicked);
    }

    private void back()
    {
        String text = output.getText();
        if(text.length() > 0)
        {
            text = text.substring(0, text.length() - 1);
            if(text.length() == 0)
            {
                output.setText("0");
                first_sign = true;
                opr = "=";
            }
            else
            {
                output.setText(text);
            }
        }
    }

    private void clear()
    {
        output.setText("0");
        first_sign = true;
        cache = 0.0;
        opr = "=";
    }

    private void num(String button)
    {
        if(first_sign)
            output.setText(button);
        else if (button.equals(".") && !output.getText().contains("."))
            output.setText(output.getText() + ".");
        else if(!button.equals("."))
            output.setText(output.getText() + button);
        first_sign = false;
    }

    private void m(String button)
    {
        if(button.equals("MS"))
        {
            cache = get_num();
            first_sign = true;
        }
        else if(button.equals("MC"))
            cache = 0.0;
        else if(button.equals("M+"))
            cache += get_num();
        else
            print_output(cache);
    }

    private void cal(String button)
    {
        if(opr.equals("+"))
            cal_res += get_num();
        else if(opr.equals("-"))
            cal_res -= get_num();
        else if(opr.equals("*"))
            cal_res *= get_num();
        else if(opr.equals("/"))
            cal_res /= get_num();
        else if(opr.equals("="))
            cal_res = get_num();
        else if(opr.equals("sin"))
            cal_res = Math.sin(get_num());
        else if(opr.equals("cos"))
            cal_res = Math.cos(get_num());
        else if(opr.equals("tan"))
            cal_res = Math.tan(get_num());
        else if(opr.equals("+/-"))
            cal_res *= -1.0;
        //output.setText(String.valueOf(cal_res));
        print_output(cal_res);
        opr = button;
        first_sign = true;

    }

    private void print_output(double cal_res)
    {
        int t = (int)cal_res;
        if(cal_res - t != 0)
            output.setText(String.valueOf(cal_res));
        else
            output.setText(String.valueOf(t));
    }
    private double get_num()
    {
        return Double.valueOf(output.getText());
    }
}
