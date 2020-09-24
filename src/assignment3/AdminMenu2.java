package assignment3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class AdminMenu2 extends JFrame 
{
    private JButton create;
    private JButton delete;
    private Library library;
    
    public AdminMenu2(Library library)
    {
        super("Menu 2");
        this.library = library;
        setLayout(new GridLayout(1,2));
        
        create = new JButton("Create Account");
        add(create);
        
        delete = new JButton("Delete Account");
        add(delete);
        
        AdminMenu2Handler handler = new AdminMenu2Handler();
        create.addActionListener(handler);
        delete.addActionListener(handler);
    }
    
    private class AdminMenu2Handler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if (event.getSource() == create)
            {
                CreateAccount create = new CreateAccount(library);
                create.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                create.setSize(200, 50);
                create.setVisible(true);
            }
            if (event.getSource() == delete)
            {
                Delete delete = new Delete(library);
                delete.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                delete.setSize(500, 50);
                delete.setVisible(true);
            }
        }
    }
}
