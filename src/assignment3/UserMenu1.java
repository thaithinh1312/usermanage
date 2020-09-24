package assignment3;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class UserMenu1 extends JFrame {

    private JLabel id;
    private JTextField idField;
    private JLabel firstName;
    private JTextField firstNameField;
    private JLabel lastName;
    private JTextField lastNameField;
    private JLabel address;
    private JTextField unit;
    private JTextField street_no;
    private JTextField streetName;
    private JTextField suburb;
    private JTextField city;
    private JTextField state;
    private JTextField postCode;
    private User user;

    public UserMenu1(User user) {
        super("Menu 1");
        this.user = user;
        setLayout(new GridLayout(11, 2));

        id = new JLabel("ID: ");
        add(id);

        idField = new JTextField(user.getId());
        add(idField);

        firstName = new JLabel("First name: ");
        add(firstName);

        firstNameField = new JTextField(user.getFirstName());
        add(firstNameField);

        lastName = new JLabel("Last name: ");
        add(lastName);

        lastNameField = new JTextField(user.getLastName());
        add(lastNameField);

        address = new JLabel("Address: ");
        add(address);

        unit = new JTextField("" + user.getAddress().getUnit());
        add(unit);

        street_no = new JTextField("" + user.getAddress().getStreet_no());
        add(street_no);

        streetName = new JTextField(user.getAddress().getStreetName());
        add(streetName);

        suburb = new JTextField(user.getAddress().getSuburb());
        add(suburb);

        city = new JTextField(user.getAddress().getCity());
        add(city);

        state = new JTextField(user.getAddress().getState().toString());
        add(state);

        postCode = new JTextField("" + user.getAddress().getPostCode());
        add(postCode);

        userMenu1Handler handler = new userMenu1Handler();
        unit.addActionListener(handler);
        street_no.addActionListener(handler);
        streetName.addActionListener(handler);
        suburb.addActionListener(handler);
        city.addActionListener(handler);
        state.addActionListener(handler);
        postCode.addActionListener(handler);

    }

    private class userMenu1Handler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            
            if (event.getSource() == unit) {
                try {
                    user.getAddress().setUnit(Integer.parseInt(event.getActionCommand()));
                    JOptionPane.showMessageDialog(null, "change committed");
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }

            if (event.getSource() == street_no) {
                try {
                    user.getAddress().setStreet_no(Integer.parseInt(event.getActionCommand()));
                    JOptionPane.showMessageDialog(null, "change committed");
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }

            if (event.getSource() == streetName) {
                user.getAddress().setStreetName(event.getActionCommand());
                JOptionPane.showMessageDialog(null, "change committed");
            }

            if (event.getSource() == suburb) {
                user.getAddress().setSuburb(event.getActionCommand());
                JOptionPane.showMessageDialog(null, "change committed");
            }

            if (event.getSource() == city) {
                user.getAddress().setCity(event.getActionCommand());
                JOptionPane.showMessageDialog(null, "change committed");
            }

            if (event.getSource() == state) {
                try {
                    if (event.getActionCommand().equals(State.NSW.toString())) {
                        user.getAddress().setState(State.NSW);
                        JOptionPane.showMessageDialog(null, "change committed");
                    } else if (event.getActionCommand().equals(State.QLD.toString())) {
                        user.getAddress().setState(State.QLD);
                        JOptionPane.showMessageDialog(null, "change committed");
                    } else if (event.getActionCommand().equals(State.SA.toString())) {
                        user.getAddress().setState(State.SA);
                        JOptionPane.showMessageDialog(null, "change committed");
                    } else if (event.getActionCommand().equals(State.TAS.toString())) {
                        user.getAddress().setState(State.TAS);
                        JOptionPane.showMessageDialog(null, "change committed");
                    } else if (event.getActionCommand().equals(State.VIC.toString())) {
                        user.getAddress().setState(State.VIC);
                        JOptionPane.showMessageDialog(null, "change committed");
                    } else if (event.getActionCommand().equals(State.WA.toString())) {
                        user.getAddress().setState(State.WA);
                        JOptionPane.showMessageDialog(null, "change committed");
                    } else {
                        JOptionPane.showMessageDialog(null, "State not found");
                    }

                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
            if (event.getSource() == postCode) {
                try {
                    user.getAddress().setPostCode(Integer.parseInt(event.getActionCommand()));
                    JOptionPane.showMessageDialog(null, "change committed");
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }

        }
    }
}
