package assignment3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.ArrayList;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class Result extends JFrame
{
    public Result(ArrayList<User> users)
    {
        super("Result");
        setLayout(new GridLayout(10,1));
        
        for (User user : users)
        {
            JLabel hihi = new JLabel(user.getFullName());
            this.add(hihi);
            hihi.addMouseListener(new MouseAdapter()
            {
                public void mouseClicked(MouseEvent e)
                {
                    UserMenu1 usermenu1 = new UserMenu1(user);
                    usermenu1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    usermenu1.setSize(300,500);
                    usermenu1.setVisible(true);
                }
            });
        }
        
    }
}
