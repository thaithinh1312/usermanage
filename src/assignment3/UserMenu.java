package assignment3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class UserMenu extends JFrame
{
    private JButton menu1;
    private JButton menu2;
    public User user;
    
    public UserMenu(User user)
    {
        super("User menu");
        this.user = user;
        setLayout(new GridLayout(1,4));
        
        menu1 = new JButton("Menu 1");
        add(menu1);
        
        menu2 = new JButton("Menu 2");
        add(menu2);
        
        MenuHandler handler = new MenuHandler();
        menu1.addActionListener(handler);
        menu2.addActionListener(handler);
    }
    
    private class MenuHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if (event.getSource() == menu1)
            {
                UserMenu1 usermenu1 = new UserMenu1(user);
                usermenu1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                usermenu1.setSize(300,500);
                usermenu1.setVisible(true);
            }
            
            if(event.getSource() == menu2)
            {
                UserMenu2 usermenu2 = new UserMenu2(user);
                usermenu2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                usermenu2.setSize(300,50);
                usermenu2.setVisible(true);     
            }
        }
        
    }
}
