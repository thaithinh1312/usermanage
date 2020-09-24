package assignment3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class CreateAccount extends JFrame 
{
    private JButton student;
    private JButton staff;
    private Library library;
    
    public CreateAccount(Library library)
    {
        super("Choose account");
        this.library = library;
        setLayout(new GridLayout(1,2));
        
        student = new JButton("Student");
        add(student);
        
        staff = new JButton("Staff");
        add(staff);
        
        AdminMenu2Handler handler = new AdminMenu2Handler();
        student.addActionListener(handler);
        staff.addActionListener(handler);
    }
    
    private class AdminMenu2Handler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if (event.getSource() == student)
            {
                CreateStudent create = new CreateStudent(library);
                create.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                create.setSize(600, 300);
                create.setVisible(true);
            }
            else if (event.getSource() == staff)
            {
                CreateStaff create = new CreateStaff(library);
                create.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                create.setSize(600, 300);
                create.setVisible(true);
            }
        }
    }
}
