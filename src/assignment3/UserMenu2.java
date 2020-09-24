package assignment3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

public class UserMenu2 extends JFrame
{
    private JLabel password;
    private JPasswordField passwordField;
    private User user;
    
    public UserMenu2(User user)
    {
        super("Menu 2");
        this.user = user;
        setLayout(new GridLayout(1,2));
        
        password = new JLabel("New Password: ");
        add(password);
        
        passwordField = new JPasswordField();
        add(passwordField);
        
        userMenu2Handler handler = new userMenu2Handler();
        passwordField.addActionListener(handler);
    }
    
    private class userMenu2Handler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
           String password = event.getActionCommand();
           boolean hasUppercase = !password.equals(password.toLowerCase());
           boolean hasLowercase = !password.equals(password.toUpperCase());

           if (password.equals(user.getPassword()))
           {
               JOptionPane.showMessageDialog(null,"Password cannot be re-used");
           }
           else if (password.length()<8 || password.length()>31)
           {
               JOptionPane.showMessageDialog(null,"Password must contain 8-31 characters");
           }
           else if (!hasUppercase || !hasLowercase)
           {
               JOptionPane.showMessageDialog(null,"Password must contain both upper case and lower case character ");
           }
           else
           {
               user.setPassword(password);
               JOptionPane.showMessageDialog(null,"Password changed");
           }
        }
    }
}
