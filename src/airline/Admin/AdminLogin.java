package airline.Admin;
import airline.User.Home;

import static DB.user_database.check_users;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
public class AdminLogin  extends JFrame implements ActionListener{
    
   JPanel p =new JPanel(),p2= new JPanel();
    public static String UserName ;
    
//---button
    JButton logB= new JButton("LogIn");
   
//--mail
    JLabel maill=new JLabel("Username");
    JTextField usernamef =new JTextField();
    //--pass
    JLabel pass= new JLabel("Password");
    JPasswordField passf=new JPasswordField();
    
    JButton Back = new JButton("");
    
    JLabel ad = new JLabel("Adminstration Access");
    
    
    
   public AdminLogin()
           {
               
                //the frame
               this.setLocation(700, 300);
              this.setTitle("Admin Login");
             this.setSize(385, 350);
              this.setVisible(true);
              this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              this.setResizable( false);
              this.setLayout(null);
              
              //--log-in button
              logB.setBounds(140, 230, 100, 35);
              logB.addActionListener(this); 
              this.add(logB);
              
              //---password
              pass.setBounds(30, 160, 100, 25);
              passf.setBounds(150, 160, 200, 30);
              pass.setFont(new Font("Serif", Font.BOLD, 20));
              this.add(pass);
              this.add(passf);
              
              //---mail
              maill.setBounds(30, 100, 100, 25);
              usernamef.setBounds(150, 100, 200, 30);
              this.add(usernamef);
              this.add(maill);
              maill.setFont(new Font("Serif", Font.BOLD, 20));
              
              this.add(ad);
              ad.setBounds(80, 20, 250, 35);
                ad.setFont(new Font("Serif", Font.BOLD, 25));

             
            this.add(Back);
        Back.setBounds(0, 0, 30, 30);
        Back.addActionListener(this);
        Back.setBackground(Color.RED);
           }
   
   
   
   public void actionPerformed(ActionEvent e) {
    
       if(e.getSource()==Back)
      {
      Home m= new Home();
      dispose();
      }
       
       if (e.getSource() == logB) {
         UserName=usernamef.getText();String userpass=String.valueOf(passf.getPassword());
        
        int result =check_users(UserName, userpass);
         if(UserName.isEmpty()){ result=0;}
      if(result==1)
      {
          System.out.println(userpass+ " "+ UserName);
          AdminMang longinsucceeded =new AdminMang();
          dispose();
      }
      else if(result==2)
          {
               JOptionPane.showMessageDialog(null, "Wrong password!");
          }
      else if(result==0) 
      {
             JOptionPane.showMessageDialog(null, "Account not found");
      }
        
      
    }
}

   
    
}