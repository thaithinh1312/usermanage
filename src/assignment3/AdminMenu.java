package assignment3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.util.ArrayList;


public class AdminMenu extends JFrame
{
    private JButton menu1;
    private JButton menu2;
    private JButton menu3;
    private User user;
    private Library library;
    
    public AdminMenu(User user, Library library)
    {
        super("Admin Menu");
        setLayout(new GridLayout(1,2));
        
        this.user = user;
        this.library = library;
        
        menu1 = new JButton("Menu 1");
        add(menu1);
        
        menu2 = new JButton("Menu 2");
        add(menu2);
        
        menu3 = new JButton("Menu 3");
        add(menu3);
               
        MenuHandler handler = new MenuHandler();
        menu1.addActionListener(handler);
        menu2.addActionListener(handler);
        menu3.addActionListener(handler);
    }
    
    private class MenuHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if (event.getSource() == menu1)
            {
                AdminMenu1 adminmenu1 = new AdminMenu1(library);
                adminmenu1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                adminmenu1.setSize(500,50);
                adminmenu1.setVisible(true);
            }
            else if (event.getSource() == menu2)
            {
                AdminMenu2 adminmenu2 = new AdminMenu2(library);
                adminmenu2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                adminmenu2.setSize(500,50);
                adminmenu2.setVisible(true);
            }
            else if (event.getSource() == menu3)
            {
                ArrayList<User> users = library.findActiveUsers();
                AdminMenu3 adminmenu3 = new AdminMenu3(users);
                adminmenu3.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                adminmenu3.setSize(100,500);
                adminmenu3.setVisible(true);
            }
            
        }
    }
}
