package assignment3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JList;

public class AdminMenu1 extends JFrame {

    private JLabel label;
    private String[] names = {"First name", "Last name"};
    private JComboBox namesJComboBox;
    private JTextField nameField;
    private JButton search;
    private Library library;
    private JList userFound;

    public AdminMenu1(Library library) {
        super("Search User");
        setLayout(new GridLayout(1, 5));

        this.library = library;
        label = new JLabel("Search User by: ");
        add(label);

        namesJComboBox = new JComboBox(names);
        namesJComboBox.setMaximumRowCount(2);
        add(namesJComboBox);

        nameField = new JTextField();
        add(nameField);

        search = new JButton("Search");
        add(search);

        adminMenu1Handler handler = new adminMenu1Handler();
        search.addActionListener(handler);

    }

    private class adminMenu1Handler implements ActionListener {

        public void actionPerformed(ActionEvent event) 
        {
            ArrayList<User> userFound;
            if (namesJComboBox.getSelectedItem().equals("First name")) 
            {
                userFound = library.findUsersByFirstName(nameField.getText());
            }
            else 
            {
                userFound = library.findUsersByLastName(nameField.getText());
            }
            
            Result result = new Result(userFound);
            result.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            result.setSize(100, 500);
            result.setVisible(true);

        }
    }
}
