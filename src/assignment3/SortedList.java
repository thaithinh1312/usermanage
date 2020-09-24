package assignment3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.ArrayList;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class SortedList extends JFrame
{
    public SortedList(ArrayList<User> users)
    {
        super("Sorted List");
        setLayout(new GridLayout(10,1));
        
        for (User user : users)
        {
            JLabel hihi = new JLabel(user.getFullName());
            this.add(hihi);
        }
        
    }
}
