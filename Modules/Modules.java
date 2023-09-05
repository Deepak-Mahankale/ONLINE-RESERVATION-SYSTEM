package Modules;

import javax.swing.*;
import java.util.Hashtable;
import java.util.Random;
import java.awt.Font;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.random.*;
import java.util.jar.Attributes.Name;
import java.time.*;
import java.sql.Connection;
import java.sql.SQLException;

public class Modules {
	 final String DB_URL = "jdbc:mysql://localhost:3306/online_rs";
     final String USERNAME = "root";
     final String PASSWORD = "Pass@123";
    
 public void User() {
     JFrame uf = new JFrame("User Login");
     JTextField tf = new JTextField();
     JPasswordField pf = new JPasswordField();
     JLabel j1 = new JLabel("User ID:");
     JLabel j2 = new JLabel("Password:");
     JButton Login = new JButton("Login");
     JButton NewU = new JButton("New User? Sign up");
     Login.setBounds(190, 150, 100, 40);
     NewU.setBounds(190, 200, 100, 40);

     j1.setBounds(80, 50, 150, 40);
     tf.setBounds(150, 50, 180, 40);

     j2.setBounds(80, 100, 150, 40);
     pf.setBounds(150, 100, 180, 40);

     uf.add(tf);
     uf.add(pf);
     uf.add(j1);
     uf.add(j2);
     uf.add(Login);
     uf.add(NewU);
     uf.setSize(480, 350);
     uf.setLayout(null);
     uf.setLocationRelativeTo(null);
     uf.setVisible(true);
   
     // Existing User
     Login.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 try {
        		 JFrame f = new JFrame("User Login");
                 JButton BookT = new JButton("Book Ticket");
                 JButton CancT = new JButton("Cancel Ticket");
 
              
            
             BookT.setBounds(110, 50, 150, 50);
             CancT.setBounds(110, 120, 150, 50);
             
             uf.setVisible(false);

             f.add(BookT);
             f.add(CancT);
             
             f.setSize(400, 300);
             f.setLayout(null);
             f.setLocationRelativeTo(null);
             f.setVisible(true);

             BookT.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent e) {
                     TicketBooking();
                     
                 }
             });

             CancT.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent e) {
                     CancelTicket();
                    
                 }
             });   	 
             
             }
        	 catch(Exception a) {
        		 
        	 }


         }
     });

     // NewUser Registration
     NewU.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {

             JFrame f = new JFrame("New User Registration");
             JLabel name = new JLabel("Enter Your Name: ");
             JLabel age = new JLabel("Enter Your Age:");
             JLabel gender = new JLabel("Select Your Gender: ");
             JLabel MobileN = new JLabel("Mobile Number: ");
             JLabel email = new JLabel("Enter Your Email: ");
             JLabel city = new JLabel("Enter Your City: ");
             JLabel pass = new JLabel("Create Password: ");

             JButton submit = new JButton("Submit");
             ButtonGroup bg = new ButtonGroup();
             JTextField nameF = new JTextField();
             JTextField ageF = new JTextField();

             JTextField MobileNF = new JTextField();
             JTextField emailF = new JTextField();
             JTextField cityF = new JTextField();
             JTextField passF = new JTextField();

             JRadioButton rb1 = new JRadioButton("Male");
             rb1.setBounds(320, 100, 80, 35);
             JRadioButton rb2 = new JRadioButton("Female");
             rb2.setBounds(400, 100, 80, 35);
             JRadioButton rb3 = new JRadioButton("Other");
             rb3.setBounds(490, 100, 80, 35);

             bg.add(rb1);
             bg.add(rb2);
             bg.add(rb3);

             Font font = new Font("Courier", Font.BOLD, 25);
             Font rb = new Font("Courier", Font.BOLD, 15);

             name.setFont(font);
             age.setFont(font);
             gender.setFont(font);
             MobileN.setFont(font);
             email.setFont(font);
             city.setFont(font);
             pass.setFont(font);
             rb1.setFont(rb);
             rb2.setFont(rb);
             rb3.setFont(rb);
             rb1.setActionCommand("Male");
             rb2.setActionCommand("Female");
             rb3.setActionCommand("Other");

             name.setBounds(30, 20, 350, 30);
             age.setBounds(30, 60, 350, 30);
             gender.setBounds(30, 100, 350, 30);
             MobileN.setBounds(30, 140, 350, 30);
             email.setBounds(30, 180, 380, 30);
             city.setBounds(30, 220, 350, 30);
             pass.setBounds(30, 260, 350, 30);

             nameF.setBounds(300, 20, 300, 30);
             ageF.setBounds(300, 60, 100, 30);
             MobileNF.setBounds(300, 140, 200, 30);
             emailF.setBounds(300, 180, 200, 30);
             cityF.setBounds(300, 220, 150, 30);
             passF.setBounds(300, 260, 300, 30);

             submit.setBounds(320, 320, 150, 40);

             submit.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent e) {
                     String uname, uage, ugen, umobile, uemail, ucity, upass;
                     uname = nameF.getText();
                     uage = ageF.getText();
                     ugen = bg.getSelection().getActionCommand();
                     umobile = MobileNF.getText();
                     uemail = emailF.getText();
                     ucity = cityF.getText();
                     upass = passF.getText();

                    
                     try (Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                             Statement stmt = conn.createStatement();) {

                         String sql = "insert ignore into user_info(user_name,age,gender,mobileN,email,city,pass) values ("
                                 + '"' + uname + '"' + "," + '"' + uage + '"' + "," + '"' + ugen + '"' + "," + '"'
                                 + umobile + '"' + "," + '"' + uemail + '"' + "," + '"' + ucity + '"' + ","
                                 + '"' + upass + '"' + ");";
                         submit.setEnabled(false);
                         f.setVisible(false);
                         JOptionPane.showMessageDialog(f, "User Registered Successfully!","Alert", JOptionPane.WARNING_MESSAGE);
                         stmt.executeUpdate(sql);
                     } catch (Exception E) {
                         System.out.println("erore" + E);
                     }

                 }
             });

             bg.add(rb1);
             bg.add(rb2);
             bg.add(rb3);

             f.add(name);
             f.add(age);
             f.add(gender);
             f.add(MobileN);
             f.add(email);
             f.add(city);
             f.add(nameF);
             f.add(ageF);
             f.add(submit);
             f.add(MobileNF);
             f.add(emailF);
             f.add(cityF);
             f.add(pass);
             f.add(passF);
             f.add(rb1);
             f.add(rb2);
             f.add(rb3);
             f.setSize(800, 450);
             f.setLayout(null);
             f.setLocationRelativeTo(null);
             f.setVisible(true);
         }
     });
 }

 public void Admin() {
     JFrame af = new JFrame("Admin Login");
     JTextField tf = new JTextField();
     JTextField pf = new JTextField();
     JLabel j1 = new JLabel("Admin ID:");
     JLabel j2 = new JLabel("Password:");
     JButton Login = new JButton("Login");

     Login.setBounds(190, 150, 100, 40);

     j1.setBounds(80, 50, 150, 40);
     tf.setBounds(150, 50, 180, 40);

     j2.setBounds(80, 100, 150, 40);
     pf.setBounds(150, 100, 180, 40);

     Login.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {

             JFrame adminframe = new JFrame(pf.getText());
             JButton Userdetails = new JButton("Users");
             JButton Ticketdetails = new JButton("Ticket details");

             Userdetails.setBounds(50, 100, 120, 40);
             Ticketdetails.setBounds(200, 100, 120, 40);

         
           Userdetails.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
        
           String[][] data = new String[5][20];
           JFrame frame = new JFrame();
           try {
           
           Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
           Statement stmt = con.createStatement();
           String sql =
           "SELECT user_name,age,gender,mobileN,city FROM user_info LIMIT 0,5";
           ResultSet rs = stmt.executeQuery(sql);
           int i = 0;
           while (rs.next()) {
           for (int j = 0; j < 5; j++) {
           data[i][j] = rs.getString(j + 1);
           }
           i = i + 1;
           }
           String[] columnNames = { "Name", "Age", "Gender", "MobileN", "city" };
           JTable table = new JTable(data, columnNames);
           table.setBounds(10, 0, 200, 200);
           frame.add(table);
           con.close();
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame.setSize(400, 400);
           frame.setLocationRelativeTo(null);
           frame.setVisible(true);
           
          } catch (Exception E) {
           System.out.println(E);
           }
           
           }
           });
           
           Ticketdetails.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
            
               String[][] data = new String[10][20];
               JFrame frame = new JFrame();
               try {
               
               Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
               Statement stmt = con.createStatement();
               String sql =
               "SELECT * FROM tickets LIMIT 0,10";
               ResultSet rs = stmt.executeQuery(sql);
               int i = 0;
               while (rs.next()) {
               for (int j = 0; j < 10; j++) {
               data[i][j] = rs.getString(j + 1);
               }
               i = i + 1;
               }
               String[] columnNames = { "Passanger Name", "Mobile No", "Age", "Train No", "Name of Train","Seat Type", "Date", "Source", "Destination", "PRN No" };
               JTable table = new JTable(data, columnNames);
               
               table.setBounds(10, 0, 200, 200);
               frame.add(table);
               con.close();
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setSize(800, 400);
               frame.setLocationRelativeTo(null);
               frame.setVisible(true);
               
              } catch (Exception E) {
               System.out.println(E);
               }
               
               }
               });
          
             adminframe.add(Userdetails);
             adminframe.add(Ticketdetails);
             adminframe.setSize(400, 300);
             adminframe.setLayout(null);
             adminframe.setVisible(true);
             adminframe.setLocationRelativeTo(null);
             }
           
     });

     af.add(tf);
     af.add(pf);
     af.add(j1);
     af.add(j2);
     af.add(Login);
     af.setSize(480, 350);
     af.setLayout(null);
     af.setLocationRelativeTo(null);
     af.setVisible(true);
 }

 public void TicketBooking() {
	 
     String[] choices = { "SELECT TRAIN NUMBER", "10001", "20001", "30001", "40001", "50001", "60001" };
     String[] classes = { "------------CLASS------------", "Genral 2S", "Sleeper", "3AC Tier", "2AC Tier",
             "1AC Tier" };
     String[] cities = { "----SELECT----", "Pune", "Mumbai", "Delhi", "Banglore", "Goa", "Uttar Pradesh" };
     String[] days = { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
     String[] months = {"JAN","FEB","MAR","APR","MAY","JUNE","JULY","AUG","SEP","OCT","NOV","DEC"};
     String[] years = {"2023","2024"};
     Random rand = new Random(); 
 
     Hashtable<String, String> ht = new Hashtable<>();
    
     ht.put("10001", "PUNE EXPRESS");
     ht.put("20001", "MUMBAI EXPRESS");
     ht.put("30001", "BANGLORE EXPRESS");
     ht.put("40001", "DELHI EXPRESS");
     ht.put("50001", "GOA EXPRESS");
     ht.put("60001", "HUMSAFAR EXPRESS");

     JButton submit = new JButton("Submit");
     JButton insert = new JButton("Insert");
     JButton choose=new JButton("Choose");
     submit.setBounds(460, 195, 100, 30);
     choose.setBounds(280, 318, 100, 30);

     JFrame tb = new JFrame("Ticket Booking");
     JLabel name = new JLabel("Name of Traveller: ");
     JLabel num = new JLabel("Mobile Number: ");
     JLabel age = new JLabel("Age: ");
     JLabel gender = new JLabel("Gender: ");
     JLabel trainN = new JLabel("Train Number: ");
     JLabel NameT = new JLabel("Name of Train: ");
     JLabel NameofTrain = new JLabel();
     JLabel Seat = new JLabel("Seat Type: ");
     JLabel jou = new JLabel("Date of Journey: ");
     JLabel fromDes = new JLabel("From to Dest: ");
     JLabel to = new JLabel("To");

     JTextField na = new JTextField();
     JTextField nu = new JTextField();
     JTextField ag = new JTextField();
     ButtonGroup bg = new ButtonGroup();

     JRadioButton rb1 = new JRadioButton("Male");
     rb1.setBounds(280, 155, 80, 35);
     JRadioButton rb2 = new JRadioButton("Female");
     rb2.setBounds(370, 155, 100, 35);
     JRadioButton rb3 = new JRadioButton("Other");
     rb3.setBounds(480, 155, 100, 35);

     JComboBox<String> cb = new JComboBox<String>(choices);
     JComboBox<String> cb2 = new JComboBox<String>(classes);

     JComboBox<String> from = new JComboBox<String>(cities);
     JComboBox<String> dest = new JComboBox<String>(cities);
     
     JComboBox<String> day = new JComboBox<String>(days);
     JComboBox<String> month = new JComboBox<String>(months);
     JComboBox<String> year = new JComboBox<String>(years);
    
     day.setBounds(280, 318, 80, 30);
     month.setBounds(380,318, 80, 30);
     year.setBounds(480, 318, 80, 30);
     
     from.setBounds(280, 355, 100, 35);
     to.setBounds(405, 355, 100, 35);
     dest.setBounds(450, 355, 100, 35);

     insert.setBounds(300, 440, 180, 50);
     cb.setBounds(280, 195, 160, 35);

     NameofTrain.setBounds(280, 235, 200, 35);
     cb2.setBounds(280, 275, 160, 35);

     bg.add(rb1);
     bg.add(rb2);
     bg.add(rb3);

     tb.add(cb);
     tb.add(rb1);
     tb.add(rb2);
     tb.add(rb3);

     Font font = new Font("Courier", Font.BOLD, 20);
     name.setFont(font);
     age.setFont(font);
     NameT.setFont(font);
     num.setFont(font);
     trainN.setFont(font);
     NameofTrain.setFont(font);
     jou.setFont(font);
     gender.setFont(font);
     to.setFont(font);
     Seat.setFont(font);
     fromDes.setFont(font);
     rb1.setFont(font);
     rb2.setFont(font);
     rb3.setFont(font);

     name.setBounds(50, 1, 250, 100); // lables
     num.setBounds(50, 40, 250, 100);
     age.setBounds(50, 80, 250, 100);
     gender.setBounds(50, 120, 250, 100);
     trainN.setBounds(50, 160, 250, 100);
     NameT.setBounds(50, 200, 250, 100);
     Seat.setBounds(50, 240, 250, 100);
     jou.setBounds(50, 280, 250, 100);
     fromDes.setBounds(50, 320, 250, 100);

     na.setBounds(280, 35, 300, 35); // textfields
     nu.setBounds(280, 75, 300, 35);
     ag.setBounds(280, 115, 80, 35);

     submit.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             String text = (String) cb.getSelectedItem().toString();
             NameofTrain.setText(ht.get(text));
         }
     });
     
     insert.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 Random rand=new Random();
        	 int ch=rand.nextInt(00000,99999);
        	 try (Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                     Statement stmt = conn.createStatement();) {
        		 String d=day.getSelectedItem().toString()+"-"+month.getSelectedItem().toString()+"-"+year.getSelectedItem().toString();
                 String sql = "insert into tickets(Passanger_Name,MobileN,Age,Train_Number,NameOfTrain,Seat_Type,Date,Source,Destination,PRN_NO) values ("
                         + '"' + na.getText() + '"' + "," + '"' + nu.getText() + '"' + "," + '"' + ag.getText() + '"' + "," + '"'
                         + cb.getSelectedItem().toString() + '"' + "," + '"' + NameofTrain.getText() + '"' + "," + '"' + cb2.getSelectedItem().toString() + '"' + ","
                         + '"' + d + '"' +","+'"'+ from.getSelectedItem().toString()+'"'+","+'"'+ dest.getSelectedItem().toString() +'"'+","+'"'+ch+'"'+");";
  
                 stmt.executeUpdate(sql);
             } catch (Exception E) {
                 System.out.println("erore" + E);
             }
        	 JOptionPane.showMessageDialog(tb, "Ticket Booked Sucessfully! \n"+"Your PRN Number is: "+ch,"Alert", JOptionPane.WARNING_MESSAGE);

         }
     });
    
     

     tb.add(name);
     tb.add(num);
     tb.add(age);
     tb.add(gender);
     tb.add(trainN);
     tb.add(NameT);
     tb.add(submit);
     tb.add(na);
     tb.add(nu);
     tb.add(day);
     tb.add(month);
     tb.add(year);
     tb.add(jou);
     tb.add(fromDes);
     tb.add(ag);
     tb.add(Seat);
     tb.add(NameofTrain);
     tb.add(insert);
     tb.add(cb2);
     tb.add(from);
     tb.add(dest);
     tb.add(to);
     tb.setLayout(null);
     tb.setSize(800, 600);
     tb.setLocationRelativeTo(null);
     tb.setVisible(true);

 }
 
 

 public void CancelTicket() {
     JLabel l = new JLabel("Enter PRN Number:");
     JTextField tf = new JTextField();
     JFrame jf = new JFrame("Ticket Cancallation");
     JButton b = new JButton("Submit");

     Font font = new Font("Courier", Font.BOLD, 25);
     l.setFont(font);

     b.setBounds(250, 70, 100, 50);
     l.setBounds(20, 5, 300, 40);
     tf.setBounds(280, 5, 200, 40);

     b.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 try {
        	     Font font = new Font("Courier", Font.BOLD, 20);
        		 
        	 String[][] tidkData=new String[9][9];
        	 Connection con=DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
        	 Statement stmt;
        	 ResultSet rs;
        	 stmt = con.createStatement();     
        	 String sql2="SELECT * FROM tickets where PRN_NO="+'"'+tf.getText()+'"'+";";
        	 rs = stmt.executeQuery(sql2);                     
        	 int i=0;                                
        	 while (rs.next()) {
        		 for(int j=0;j<9;j++) {
        	  tidkData[i][j] = rs.getString(j+1);
        	 }
        	  i++;
        	 }
        	 rs.close();                                      
        	 stmt.close();   
        
        	 JLabel j1=new JLabel("Name: "+tidkData[0][0]);
        	 JLabel j2=new JLabel("Mobile No: "+tidkData[0][1]);
        	 JLabel j3=new JLabel("Age: "+tidkData[0][2]);
        	 JLabel j4=new JLabel("Train No: "+tidkData[0][3]);
        	 JLabel j5=new JLabel("Name of Train: "+tidkData[0][4]);
        	 JLabel j6=new JLabel("Seat Type: "+tidkData[0][5]);
        	 JLabel j7=new JLabel("Date: "+tidkData[0][6]);
       	 	 JLabel j8=new JLabel("Source: "+tidkData[0][8]);
        	 JLabel j9=new JLabel("Destination: "+tidkData[0][7]);
        	 JLabel j10=new JLabel("Cancel the Ticket? ");
        	 
        	 JButton ok=new JButton("OK");
        	 JButton no=new JButton("NO");
        	 
        	 j1.setFont(font);
        	 j2.setFont(font);
        	 j3.setFont(font);
        	 j4.setFont(font);
        	 j5.setFont(font);
        	 j6.setFont(font);
        	 j7.setFont(font);
        	 j8.setFont(font);
        	 j9.setFont(font);
        	 j10.setFont(font);
        	
        	 ok.setBounds(300, 280, 60, 30);
        	 no.setBounds(400, 280, 60, 30);
        	 
        	 j1.setBounds(20,10,200,40);
        	 j2.setBounds(20,50,250,40);
        	 j3.setBounds(20,90,200,40);
        	 j4.setBounds(20,130,200,40);
        	 j5.setBounds(20,170,350,40);
        	 j6.setBounds(340,130,200,40);
        	 j7.setBounds(340,10,200,40);
           	 j8.setBounds(340,50,200,40);
             j9.setBounds(340,90,200,40);
             j10.setBounds(60, 280, 200, 40);
             
        	 jf.add(j1);
        	 jf.add(j2);
        	 jf.add(j3);
        	 jf.add(j4);
        	 jf.add(j5);
        	 jf.add(j6);
     	     jf.add(j7);
     	     jf.add(j8);
        	 jf.add(j9);
        	 jf.add(j10);
        	 jf.add(ok);
        	 jf.add(no);
        	 
        	 ok.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent e) {
                	
                	 try (Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                             Statement stmt = conn.createStatement();) {
                         String sql = "delete from tickets where PRN_NO="+'"'+tf.getText()+'"'+";";
          
                        stmt.executeUpdate(sql);
                     } catch (Exception E) {
                         System.out.println("erore" + E);
                     }
                	 JOptionPane.showMessageDialog(jf, "Ticket Cancelled Sucessfully!","Alert", JOptionPane.WARNING_MESSAGE);

                 }
             });
        	 no.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent e) {
                	
                	 jf.setVisible(false);
                 }
             });
            
             
             jf.remove(b);
             jf.remove(tf);
             jf.remove(l);
             jf.setSize(600, 400);
             jf.setLayout(null);
             jf.setVisible(true);
             jf.setLocationRelativeTo(null);
             
        	 }
        	 catch(Exception e1) {
        		 
        	 }
        	
         }
     });
     jf.add(b);
     jf.add(l);
     jf.add(tf);
     
     jf.setLayout(null);
     jf.setSize(600, 200);
     jf.setLocationRelativeTo(null);
     jf.setVisible(true);
 }
}
