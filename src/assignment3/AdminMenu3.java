package assignment3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.util.ArrayList;

public class AdminMenu3 extends JFrame
{
    public AdminMenu3(ArrayList<User> users)
    {
        super("Account list");
        setLayout(new GridLayout(15,1));
        for(User user : users)
        {
            add(new JLabel(user.getFullName()));
        }
    }
}
