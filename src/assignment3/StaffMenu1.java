package assignment3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.util.ArrayList;
import javax.swing.JComboBox;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;

public class StaffMenu1 extends JFrame
{
    private JLabel label;
    private JButton sort;
    private String[] sortstyle = {"Ascending", "Descending"};
    private JComboBox sortbox;
    private ArrayList<User> users;
    
    public StaffMenu1(ArrayList<User> users)
    {
        super("Sort student");
        this.users = users;
        setLayout(new GridLayout(1,5));
        
        label = new JLabel("Sort style: ");
        add(label);
                
        sortbox = new JComboBox(sortstyle);
        sortbox.setMaximumRowCount(2);
        add(sortbox);
        
        sort = new JButton("Search");
        add(sort);
        
        StaffMenu1Handler handler = new StaffMenu1Handler();
        sort.addActionListener(handler);
    }
    
    private class StaffMenu1Handler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            ArrayList<User> students = new ArrayList<User>();
            for (User user : users)
            {
                if (user instanceof Student)
                {
                    students.add(user);
                }
            }
            
            if (sortbox.getSelectedIndex() == 0)
            {
                Collections.sort(students);
            }
            else if(sortbox.getSelectedIndex() == 1)
            {
                Collections.sort(students,Collections.reverseOrder());
            }
            
            SortedList list = new SortedList(students);
            list.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            list.setSize(100, 500);
            list.setVisible(true);
        }
    }

}
