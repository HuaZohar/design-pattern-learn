package buildpattern.prototype;

import javax.swing.*;
import java.awt.*;

/**
 * @author zzh
 */
public class TestPrototype {

    public static void main(String[] args) throws CloneNotSupportedException {
        JFrame jf = new JFrame("原型模式测试");
        jf.setLayout(new GridLayout(1, 2));
        Container contentPane = jf.getContentPane();
        SunWuKong obj1 = new SunWuKong();
        contentPane.add(obj1);
        SunWuKong obj2 = (SunWuKong) obj1.clone();
        contentPane.add(obj2);
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class SunWuKong extends JPanel implements Cloneable {
    public SunWuKong() {
        JLabel label = new JLabel("Wukong.jpg");
        this.add(label);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (SunWuKong) super.clone();
    }


}
