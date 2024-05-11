package airline.User;
import DB.*;
import airline.User.Account;
import airline.User.Home;
import airline.User.Register;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pc
 */
public class UserLogin extends JFrame implements ActionListener{
    JPanel p =new JPanel(),p2= new JPanel();
    public static String UserName ;
    //---buutoms
    JButton logB= new JButton("Login");
    JButton riB= new JButton("Register");
    JButton crewB=new JButton("crew");
    JButton adminB=new JButton("admin");
    //--mail
    JLabel maill=new JLabel("E-mail");
    JTextField mailf=new JTextField();
    //--pass
    JLabel pass= new JLabel("Password");
    JPasswordField passf=new JPasswordField();
    
    //--WELCOME statment
    JLabel wel = new JLabel("Welcome Back, Traveller!");
    
    JButton Back = new JButton("");
    
    
   public UserLogin()
           {
               
               
                //the frame
               this.setLocation(700, 300);
              this.setTitle("Passenger Login");
               this.setSize(385, 350);
               this.setVisible(true);
               this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              this.setResizable( false);
              this.setLayout(null);
              
              //--WELCOME statment
              this.add(wel);
              wel.setBounds(80, 30, 350, 30);
              wel.setFont(new Font("Serif", Font.BOLD, 20));
              
              //--log-in button
              logB.setBounds(215, 230, 100, 25);
              logB.addActionListener(this); 
              this.add(logB);
              
              //--register button
              riB.setBounds(65,230 ,100 , 25);
              riB.addActionListener(this); 
              this.add(riB);
              
              //---password
              pass.setBounds(70, 150, 80,30 );
              passf.setBounds(165, 150, 150, 30);
              this.add(pass);
              this.add(passf);
              pass.setFont(new Font("Serif", Font.PLAIN, 20));
              
              //---mail
              maill.setBounds(70, 90, 80, 30);
              mailf.setBounds(165, 90, 150, 30);
              this.add(mailf);
              this.add(maill);
              maill.setFont(new Font("Serif", Font.PLAIN, 20));
              
            //menu bar
               /*JMenuBar menuBar = new JMenuBar();
               JMenu admin = new JMenu("admin");
               JMenu crew = new JMenu("crew");
               JMenu settings = new JMenu("settings");
               JMenuItem Dark=new JMenuItem("Dark Mode");
               settings.add(Dark);
               menuBar.add(admin);
               menuBar.add(crew);
               menuBar.add(settings);
               
               this.setJMenuBar(menuBar);*/
             
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
       
       if (e.getSource() == riB) {
       Register n=new Register();
       dispose();
    } else if (e.getSource() == logB) {
         UserName=mailf.getText();String userpass=String.valueOf(passf.getPassword());
        
        int result =passengers_DB.PASSENGER_LOGIN(UserName,userpass );
         if(UserName.isEmpty()){ result=0;}
      if(result==1)
      {
          System.out.println(userpass+ " "+ UserName);
          Account longinsucceeded =new Account(UserName);
          dispose();
      }
      else if(result==-1)
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
