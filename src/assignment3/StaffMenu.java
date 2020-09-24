package assignment3;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class StaffMenu extends JFrame
{
    private JButton menu1;
    private Library library;
    
    public StaffMenu(Library library)
    {
        super("Staff Menu");
        this.library = library;
        setLayout(new GridLayout(1,5));
        
        menu1 = new JButton("Menu 1");
        add(menu1);
        
        StaffMenuHandler handler = new StaffMenuHandler();
        menu1.addActionListener(handler);
            
    }
    
    private class StaffMenuHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            StaffMenu1 menu1 = new StaffMenu1(library.getUsers());
            menu1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            menu1.setSize(500,50);
            menu1.setVisible(true);            
            
        }
    }
}
