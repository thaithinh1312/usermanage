package assignment3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JFrame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.lang.System;

public class NewMain {

    private static Object lock = new Object();

    public static void main(String[] args) throws CloneNotSupportedException, InterruptedException 
    {
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Staff> staffs = new ArrayList<>();
        Scanner scanner = null;
        boolean error = false;
        try {
            scanner = new Scanner(Paths.get("Student.txt"));
        } catch (IOException ex) {
            error = true;
        }

        if (!error) {
            while (scanner.hasNext()) {
                String student = scanner.nextLine();
                String[] s = student.split(",");
                Student temp = null;
                try {
                    UserType usertype = null;

                    if (s[5].equals("Student")) {
                        usertype = UserType.Student;
                    } else if (s[5].equals("PostStudent")) {
                        usertype = UserType.PostStudent;
                    } else if (s[5].equals("AdminStaff")) {
                        usertype = UserType.AdminStaff;
                    } else if (s[5].equals("Librarian")) {
                        usertype = UserType.Librarian;
                    } else if (s[5].equals("AcademicStaff")) {
                        usertype = UserType.AcademicStaff;
                    } else if (s[5].equals("Admin")) {
                        usertype = UserType.Admin;
                    }

                    PermissionType permission = null;
                    if (s[6].equals("BorrowAndEdit")) {
                        permission = PermissionType.BorrowAndEdit;
                    } else if (s[6].equals("Borrow")) {
                        permission = PermissionType.Borrow;
                    } else if (s[6].equals("Reserve")) {
                        permission = PermissionType.Reserve;
                    } else if (s[6].equals("Edit")) {
                        permission = PermissionType.Edit;
                    } else if (s[6].equals("None")) {
                        permission = PermissionType.None;
                    }

                    boolean status = false;
                    if (s[7].equals("true")) {
                        status = true;
                    }

                    State state = null;
                    if(s[15].equals(State.NSW.toString())){
                        state = State.NSW;
                    }else if(s[15].equals(State.QLD.toString())){
                        state = State.QLD;
                    }else if(s[15].equals(State.SA.toString())){
                        state = State.SA;
                    }else if(s[15].equals(State.TAS.toString())){
                        state = State.TAS;
                    }else if(s[15].equals(State.VIC.toString())){
                        state = State.VIC;
                    }else if(s[15].equals(State.WA.toString())){
                        state = State.WA;
                    }
                    
                    Address address = new Address(Integer.parseInt(s[10]),Integer.parseInt(s[11]),s[12],s[13],s[14],state,Integer.parseInt(s[16]));
                    temp = new Student(s[0], s[1], s[2], s[3], s[4], usertype, permission, status, s[8], s[9], address);
                    students.add(temp);
                } catch (NoSuchElementException ex) {
                    System.out.println("File improperly formed. Terminating.");
                }
            }
            scanner.close();
        }

        try {
            scanner = new Scanner(Paths.get("Staff.txt"));
        } catch (IOException ex) {
            error = true;
        }

        if (!error) {
            while (scanner.hasNext()) {
                String staff = scanner.nextLine();
                String[] s = staff.split(",");
                Staff temp = null;
                try {
                    UserType usertype = null;
                    if (s[5].equals("Student")) {
                        usertype = UserType.Student;
                    } else if (s[5].equals("PostStudent")) {
                        usertype = UserType.PostStudent;
                    } else if (s[5].equals("AdminStaff")) {
                        usertype = UserType.AdminStaff;
                    } else if (s[5].equals("Librarian")) {
                        usertype = UserType.Librarian;
                    } else if (s[5].equals("AcademicStaff")) {
                        usertype = UserType.AcademicStaff;
                    } else if (s[5].equals("Admin")) {
                        usertype = UserType.Admin;
                    }

                    PermissionType permission = null;
                    if (s[6].equals("BorrowAndEdit")) {
                        permission = PermissionType.BorrowAndEdit;
                    } else if (s[6].equals("Borrow")) {
                        permission = PermissionType.Borrow;
                    } else if (s[6].equals("Reserve")) {
                        permission = PermissionType.Reserve;
                    } else if (s[6].equals("Edit")) {
                        permission = PermissionType.Edit;
                    } else if (s[6].equals("None")) {
                        permission = PermissionType.None;
                    }

                    boolean status = false;
                    if (s[7].equals("true")) {
                        status = true;
                    }

                    Position position = null;
                    if (s[8].equals("ADMIN")) {
                        position = Position.ADMIN;
                    } else if (s[8].equals("LIBRARIAN")) {
                        position = Position.LIBRARIAN;
                    } else if (s[8].equals("GENERAL_OFFICE_STAFF")) {
                        position = Position.GENERAL_OFFICE_STAFF;
                    } else if (s[8].equals("MANAGER")) {
                        position = Position.MANAGER;
                    } else if (s[8].equals("ACADEMIC_STAFF")) {
                        position = Position.ACADEMIC_STAFF;
                    } else if (s[8].equals("TEACHING_ASSISTANT")) {
                        position = Position.TEACHING_ASSISTANT;
                    }
                    
                    State state = null;
                    if(s[16].equals(State.NSW.toString())){
                        state = State.NSW;
                    }else if(s[16].equals(State.QLD.toString())){
                        state = State.QLD;
                    }else if(s[16].equals(State.SA.toString())){
                        state = State.SA;
                    }else if(s[16].equals(State.TAS.toString())){
                        state = State.TAS;
                    }else if(s[16].equals(State.VIC.toString())){
                        state = State.VIC;
                    }else if(s[16].equals(State.WA.toString())){
                        state = State.WA;
                    }

                    Department department = null;
                    if (s[10].equals("BUSINESS")) {
                        department = Department.BUSINESS;
                    } else if (s[10].equals("SOCIAL_SCIENCES")) {
                        department = Department.SOCIAL_SCIENCES;
                    } else if (s[10].equals("ARTS")) {
                        department = Department.ARTS;
                    } else if (s[10].equals("LAW_HUMANITIES")) {
                        department = Department.LAW_HUMANITIES;
                    } else if (s[10].equals("EDUCATION")) {
                        department = Department.EDUCATION;
                    } else if (s[10].equals("COMPUTING_IT")) {
                        department = Department.COMPUTING_IT;
                    }
                    
                    Address address = new Address(Integer.parseInt(s[11]),Integer.parseInt(s[12]),s[13],s[14],s[15],state,Integer.parseInt(s[17]));
                    temp = new Staff(s[0], s[1], s[2], s[3], s[4], usertype, permission, status, position, Integer.parseInt(s[9]), department, address);
                    staffs.add(temp);
                } catch (NoSuchElementException ex) {
                    System.out.println("File improperly formed. Terminating.");
                }
            }
            scanner.close();
        }
        for (User u : students) {
            System.out.println(u);
        }

        Library library = new Library();
        for (User u : students) {
            library.addUser(u);
        }
        for (User u : staffs) {
            library.addUser(u);
        }

        Login login1 = new Login(library);
        login1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        login1.setSize(300, 80);
        login1.setVisible(true);

        Thread t = new Thread() {
            public void run() {
                synchronized (lock) {
                    while (login1.isVisible()) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        t.start();

        login1.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent arg0) {
                synchronized (lock) {
                    login1.setVisible(false);
                    lock.notify();
                }
            }
        });
        t.join();

        File f1 = new File(Paths.get("Staff.txt").toUri());
        Formatter out = null;
        boolean err = false;
        try {
            out = new Formatter(f1);
        } catch (FileNotFoundException ex) {
            err = true;
        }
        if (!err) {
            for (User u : library.getUsers()) {
                if (u instanceof Staff) {
                    out.format("%s,%s%n", u.toString(),u.getAddress().toString());
                }
            }
            out.close();
        }
        
        f1 = new File(Paths.get("Student.txt").toUri());
        out = null;
        err = false;
        try {
            out = new Formatter(f1);
        } catch (FileNotFoundException ex) {
            err = true;
        }
        if (!err) {
            for (User u : library.getUsers()) {
                if (u instanceof Student) {
                    out.format("%s,%s%n", u.toString(),u.getAddress().toString());
                }
            }
            out.close();
        }
        System.out.println("Finished writing file");
        System.exit(0);
    }

}