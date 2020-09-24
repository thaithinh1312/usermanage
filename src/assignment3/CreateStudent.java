package assignment3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class CreateStudent extends JFrame {

    private Library library;
    private JLabel id;
    private JLabel firstName;
    private JLabel lastName;
    private JLabel username;
    private JLabel password;
    private JLabel userType;
    private JLabel permission;
    private JLabel course;
    private JLabel degree;
    private JTextField degreeField;
    private JTextField courseField;
    private JTextField idField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox userTypeField;
    private String[] userTypes = {"Under Graduate Student", "Post Graduate Student", "Administrative staff", "Librarian", "Academic Staff", "System Administrator"};
    private JTextField permissionField;
    private JButton create;

    public CreateStudent(Library library) {
        super("Create Account");
        this.library = library;
        setLayout(new GridLayout(10, 2));

        id = new JLabel("ID: ");
        add(id);

        idField = new JTextField();
        add(idField);

        firstName = new JLabel("First Name: ");
        add(firstName);

        firstNameField = new JTextField();
        add(firstNameField);

        lastName = new JLabel("Last Name: ");
        add(lastName);

        lastNameField = new JTextField();
        add(lastNameField);

        username = new JLabel("Username: ");
        add(username);

        usernameField = new JTextField();
        add(usernameField);

        password = new JLabel("Password: ");
        add(password);

        passwordField = new JPasswordField();
        add(passwordField);

        userType = new JLabel("User Type: ");
        add(userType);

        userTypeField = new JComboBox(userTypes);
        add(userTypeField);

        course = new JLabel("Course: ");
        add(course);

        courseField = new JTextField();
        add(courseField);

        degree = new JLabel("Degree: ");
        add(degree);

        degreeField = new JTextField();
        add(degreeField);

        create = new JButton("Create");
        add(create);

        CreateHandler handler = new CreateHandler();
        create.addActionListener(handler);

    }

    private class CreateHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            int studentID = 0;

            UserType usertype = null;
            switch (userTypeField.getSelectedIndex()) {
                case 0:
                    usertype = UserType.Student;
                    break;
                case 1:
                    usertype = UserType.PostStudent;
                    break;
                case 2:
                    usertype = UserType.AdminStaff;
                    break;
                case 3:
                    usertype = UserType.Librarian;
                    break;
                case 4:
                    usertype = UserType.AcademicStaff;
                    break;
                case 5:
                    usertype = UserType.Admin;
                    break;
            }

            try {
                studentID = Integer.parseInt(idField.getText());

                if (studentID / 1000000 != 5) {
                    throw new IllegalArgumentException("ID has to start with 5");
                }

                if (firstNameField.getText().length() != 0
                        && lastNameField.getText().length() != 0
                        && usernameField.getText().length() != 0
                        && passwordField.getText().length() != 0) 
                {
                    Address address1 = new Address(0, 0, " ", " ", " ",State.NSW, 0);
                    Student student = new Student(idField.getText(),
                            firstNameField.getText(),
                            lastNameField.getText(),
                            usernameField.getText(),
                            passwordField.getText(),
                            usertype,
                            PermissionType.Reserve,
                            true,
                            courseField.getText(),
                            degreeField.getText(),
                            address1);
                    
                    if (library.addUser(student) == false) 
                    {
                        JOptionPane.showMessageDialog(null, "ID already exsists");
                    } else 
                    {
                        JOptionPane.showMessageDialog(null, "Account Created");

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Insufficient info");
                }

            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "ID has to start with 5");
            }

        }
    }
}
