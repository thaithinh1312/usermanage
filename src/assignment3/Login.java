package assignment3;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Login extends JFrame 
{
    String currentLoginUser;
    public Library library;
    
    private JPasswordField password;
    private JTextField userName;
    private JLabel userNameLabel;
    private JLabel passwordLabel;
    
    public Login(Library library)
    {
        super("Login");
        this.library = library;
        
        setLayout(new GridLayout(2,2));
        
        userNameLabel = new JLabel("User name ");
        add(userNameLabel);
        
        userName = new JTextField();
        add(userName);
        
        passwordLabel = new JLabel("Password ");
        add(passwordLabel);
        
        password = new JPasswordField();
        add(password);
        
        LoginHandler handler = new LoginHandler();
        password.addActionListener(handler);
    }
    
    private class LoginHandler implements ActionListener
    {        
        public void actionPerformed(ActionEvent event)
        {
            if (library.verifyLogIn(userName.getText(), password.getText()))
            {
                currentLoginUser = userName.getText();
                UserMenu usermenu = new UserMenu(library.getUser(currentLoginUser));
                usermenu.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                usermenu.setSize(300,80);
                usermenu.setVisible(true);
                if(library.isUserAdmin(currentLoginUser))
                {
                    AdminMenu adminmenu = new AdminMenu(library.getUser(currentLoginUser), library);
                    adminmenu.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    adminmenu.setSize(300,80);
                    adminmenu.setVisible(true);
                }
                if(library.isUserStaff(currentLoginUser))
                {
                    StaffMenu staffmenu = new StaffMenu(library);
                    staffmenu.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    staffmenu.setSize(300,80);
                    staffmenu.setVisible(true);
                }
            }
            else 
            {
                JOptionPane.showMessageDialog(null, "Incorrect password");
            }
        }
    }
}
