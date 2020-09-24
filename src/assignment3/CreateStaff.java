package assignment3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class CreateStaff extends JFrame {

    private Library library;
    private JLabel id;
    private JLabel firstName;
    private JLabel lastName;
    private JLabel username;
    private JLabel password;
    private JLabel userType;
    private JLabel permission;
    private JLabel position;
    private JLabel salary;
    private JLabel department;
    private JComboBox positionField;
    private String[] positions = {"Admin", "Librarian", "General Office Staff", "Manager", "Academic Staff", "Teaching Assistant"};
    private JTextField salaryField;
    private JComboBox departmentField;
    private String[] departments = {"Business", "Social Siences", "Arts", "Law & Humanities", "Education", "Computing & IT"};
    private JTextField idField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox userTypeField;
    private String[] userTypes = {"Under Graduate Student", "Post Graduate Student", "Administrative staff", "Librarian", "Academic Staff", "System Administrator"};
    private JComboBox permissionField;
    private String[] permissions = {"BorrowAndEdit", "Borrow", "Reserve", "Edit", "None"};
    private JButton create;

    public CreateStaff(Library library) {
        super("Create Account");
        this.library = library;
        setLayout(new GridLayout(12, 2));

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

        permission = new JLabel("Permission: ");
        add(permission);

        permissionField = new JComboBox(permissions);
        add(permissionField);

        position = new JLabel("Position: ");
        add(position);

        positionField = new JComboBox(positions);
        add(positionField);

        salary = new JLabel("Salary: ");
        add(salary);

        salaryField = new JTextField();
        add(salaryField);

        department = new JLabel("Deparment: ");
        add(department);

        departmentField = new JComboBox(departments);
        add(departmentField);

        create = new JButton("Create");
        add(create);

        CreateHandler handler = new CreateHandler();
        create.addActionListener(handler);

    }

    private class CreateHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
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

            Department department = null;
            switch (departmentField.getSelectedIndex()) {
                case 0:
                    department = Department.BUSINESS;
                    break;
                case 1:
                    department = Department.SOCIAL_SCIENCES;
                    break;
                case 2:
                    department = Department.ARTS;
                    break;
                case 3:
                    department = Department.LAW_HUMANITIES;
                    break;
                case 4:
                    department = Department.EDUCATION;
                    break;
                case 5:
                    department = Department.COMPUTING_IT;
                    break;
            }

            Position position = null;
            switch (positionField.getSelectedIndex()) {
                case 0:
                    position = Position.ADMIN;
                    break;
                case 1:
                    position = Position.LIBRARIAN;
                    break;
                case 2:
                    position = Position.GENERAL_OFFICE_STAFF;
                    break;
                case 3:
                    position = Position.MANAGER;
                    break;
                case 4:
                    position = Position.ACADEMIC_STAFF;
                    break;
                case 5:
                    position = Position.TEACHING_ASSISTANT;
                    break;
            }

            PermissionType permission = null;
            switch (permissionField.getSelectedIndex()) {
                case 0:
                    permission = PermissionType.BorrowAndEdit;
                    break;
                case 1:
                    permission = PermissionType.Borrow;
                    break;
                case 2:
                    permission = PermissionType.Reserve;
                    break;
                case 3:
                    permission = PermissionType.Edit;
                    break;
                case 4:
                    permission = PermissionType.None;
                    break;
            }

            double salary = 0;
            try {
                salary = Integer.parseInt(salaryField.getText());
                int userID = Integer.parseInt(idField.getText());
                try {
                    if (position == Position.LIBRARIAN) {
                        if (userID / 1000000 != 4) {
                            throw new IllegalArgumentException("ID must start with 4 and has 7 numbers");
                        }
                    } else {
                        if (userID / 1000000 != 3) {
                            throw new IllegalArgumentException("ID must start with 3 and has 7 numbers");
                        }
                    }
                    if (firstNameField.getText().length() != 0
                            && lastNameField.getText().length() != 0
                            && usernameField.getText().length() != 0
                            && passwordField.getText().length() != 0) {

                        Address address1 = new Address(0, 0, " ", " ", " ",State.NSW, 0);
                        Staff staff = new Staff(idField.getText(),
                                firstNameField.getText(),
                                lastNameField.getText(),
                                usernameField.getText(),
                                passwordField.getText(),
                                usertype,
                                permission,
                                true,
                                position,
                                salary,
                                department,
                                address1);
                        
                        if (library.addUser(staff) == false) {
                            JOptionPane.showMessageDialog(null, "ID already exsists");
                        } else {
                            JOptionPane.showMessageDialog(null, "Account Created");

                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Insufficient info");
                    }

                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, e);
                }

            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null,"Please enter salary");
            }
        }
    }
}
