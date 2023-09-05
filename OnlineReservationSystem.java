import Modules.*;
import javax.swing.*;
import java.util.Hashtable;
import java.awt.Font;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.jar.Attributes.Name;
import java.time.*;


public class OnlineReservationSystem {
    public static void main(String[] args) {
        JFrame f = new JFrame();

        JLabel j = new JLabel("WELCOME TO TICKET RESERVATION SYSTEM");
        j.setBounds(15, 20, 400, 30);
        JButton u = new JButton("User Login");
        JButton a = new JButton("Admin Login");

        Font font = new Font("Times New Roman", Font.BOLD, 15);
        j.setFont(font);
        u.setBounds(130, 130, 100, 40);
        a.setBounds(130, 75, 100, 40);
        f.add(j);
        f.add(u);
        f.add(a);

        f.setSize(400, 300);
        f.setLayout(null);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        Modules m = new Modules();

        u.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                m.User();
                f.setVisible(false);
            }
        });

        a.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                m.Admin();

            }
        });

    }

}

