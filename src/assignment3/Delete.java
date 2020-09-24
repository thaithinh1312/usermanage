package assignment3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Delete extends JFrame {

    private JLabel id;
    private JTextField idField;
    private JButton button;
    private Library library;

    public Delete(Library library) {
        super("Delete Account");
        setLayout(new GridLayout(1, 3));

        this.library = library;

        id = new JLabel("Enter ID: ");
        add(id);

        idField = new JTextField();
        add(idField);

        button = new JButton("Delete");
        add(button);

        DeleteHandler handler = new DeleteHandler();
        button.addActionListener(handler);
    }

    private class DeleteHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            User user = null;
            try {
                user = library.findUsersById(idField.getText());
                if (user == null) {
                    throw new NullPointerException();
                }
                else 
                {
                    if (user.getStatus() == true){
                        user.setStatus(false);
                        JOptionPane.showMessageDialog(null, "Deleted");
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(null, "User not found");
                    }
                }

            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "User not found");
            }

        }
    }
}
