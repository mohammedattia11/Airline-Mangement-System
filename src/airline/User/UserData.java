/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airline.User;

import DB.passengers_DB;
import elements.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author pc
 */
public class UserData extends JFrame implements ActionListener {
    
     //Menu Bar
        JMenuBar accmenu=new JMenuBar();
        JMenuItem book=new JMenuItem("Book");
        JMenuItem flights=new JMenuItem("Flights");
        JMenuItem logout=new JMenuItem("Logout");
        JMenuItem userinfo=new JMenuItem("Profile");
    
    JLabel fnamel=new JLabel("Name:");
     JLabel usernamel=new JLabel("UserName:");
    JLabel nationalityL=new JLabel("Nationality:");
    JLabel genderl=new JLabel("Gender:");
    JLabel agel=new JLabel("Age:");
    JLabel passportl=new JLabel("passport Number:");
    JLabel emaill=new JLabel("E-mail:");
    JLabel passl=new JLabel("Password:");
    JLabel sec = new JLabel("Profile Section");
    //-------------------------------------
    JTextField fnametx=new JTextField();
    JTextField usernametx=new JTextField();
    JTextField nationalitytx=new JTextField();
    String[] G={"Male","Female"};
    JComboBox gendertx=new JComboBox(G);
    JTextField agetx=new JTextField();
    JTextField passporttx=new JTextField();
    JTextField emailtx=new JTextField();
    JPasswordField passtx=new JPasswordField();
    //---------------------------------------
    JButton reg =new JButton("UPDATE");
    JButton reg2 =new JButton("UPDATE");
     JButton enter =new JButton("ENTER");
    JPasswordField passstx =new JPasswordField();
    
     String username = UserLogin.UserName;
      ArrayList<passengersData> userdata=DB.passengers_DB.ADMIN_SEARCH_PASSENGERS_ByUsername(username);
      //user data
      String email=userdata.get(0).email,
                   pass=userdata.get(0).pass,
                   name=userdata.get(0).name,
                   nationality=userdata.get(0).nationality,
                   gender= userdata.get(0).address,
                   username2 =userdata.get(0).userName,
                   passportnum=userdata.get(0).passportNumber;
      int age=userdata.get(0).age;
    
    UserData()
    {
        
       
        
        
        
     
        JLabel fnametxl=new JLabel(userdata.get(0).name);
        JLabel usernametxl=new JLabel(userdata.get(0).userName);
        JLabel nationalitytxl=new JLabel(userdata.get(0).nationality);
        JLabel gendertxl=new JLabel(userdata.get(0).address);
        JLabel agetxl=new JLabel(String.valueOf(userdata.get(0).age));
        JLabel passporttxl=new JLabel(userdata.get(0).passportNumber);
        JLabel emailtxl=new JLabel(userdata.get(0).email);
        JLabel passtxl=new JLabel("********");
        
        //frame
        this.setTitle("Profile");
        this.setLocation(700, 300);
        this.setSize(600, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.add(sec);
        sec.setBounds(200, 15, 200, 40);
        sec.setFont(new Font("Serif", Font.BOLD, 20));
        
        //menu par
          flights.addActionListener(this);
          userinfo.addActionListener(this);
          book.addActionListener(this);
          logout.addActionListener(this);
          accmenu.add(logout);
          accmenu.add(book);
          accmenu.add(flights);
          accmenu.add(userinfo);
          this.setJMenuBar(accmenu);
        //---
        fnametxl.setBounds(120, 50, 150, 30);
        fnamel.setBounds(60, 50, 70, 30);
        this.add(fnametxl);
        this.add(fnamel);
        //---
        nationalitytxl.setBounds(130, 170, 150, 30);
        nationalityL.setBounds(60,170 ,70, 30);
        this.add(nationalitytxl);
        this.add(nationalityL);
        //---
        agetxl.setBounds(120, 90, 150, 30);
        agel.setBounds(60, 90, 100, 30);
        this.add(agetxl);
        this.add(agel);
        //---
        gendertxl.setBounds(120, 130, 150, 30);
        genderl.setBounds(60,130 ,70, 30);
        this.add(gendertxl);
        this.add(genderl);
        //---
        passporttxl.setBounds(165, 210, 150, 30);
        passportl.setBounds(60,210 ,150, 30);
        this.add(passporttxl);
        this.add(passportl);
        //---
        emailtxl.setBounds(120, 250, 150, 30);
        emaill.setBounds(60, 250, 70, 30);
        this.add(emailtxl);
        this.add(emaill);
        //---
        usernametxl.setBounds(130, 290, 150, 30);
        usernamel.setBounds(60, 290, 70, 30);
        this.add(usernametxl);
        this.add(usernamel);
        //---
        passtxl.setBounds(125, 330, 150, 30);
        passl.setBounds(60, 330, 70, 30);
        this.add(passtxl);
        this.add(passl);
        //---
        reg.setBounds(250, 450, 100, 25);
        reg.addActionListener(this);
        this.add(reg);
        //--
        logout.setBackground(Color.red);
        
    }
    
    UserData(int c)
    {
        this.setTitle("Register");
        this.setSize(250, 200);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        JLabel passs= new JLabel("enter yout password");
        passs.setBounds(50, 10, 150,30);
      
        passstx.setBounds(50, 50, 150,30);
        this.add(passs);
        this.add(passstx);
       
        enter.setBounds(60, 100, 80, 30);
        this.add(enter);
        enter.addActionListener(this);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {

            if(e.getSource()==reg)
            {
                UserData m=new UserData(1);
                dispose();
            }
            if(e.getSource()==enter)
            { //System.out.println("yes");
                 int result =passengers_DB.PASSENGER_LOGIN(username,String.valueOf(passstx.getPassword()));
                 if(result==1)
                 {
                     UpdateUserData done = new UpdateUserData();
                      dispose();
                 }
                 else if(result==-1)
                 {
                   JOptionPane.showMessageDialog(null, "Wrong password!");
                  }
            }
             if(e.getSource()==book)
            {
               Account Account2= new Account(UserLogin.UserName);
                dispose();
            }
            if(e.getSource()==flights)
            {
                UserFlights user=new UserFlights(UserLogin.UserName);
                 dispose();
            }
            if(e.getSource()==logout)
            {
               
                UserLogin user=new UserLogin();
                 dispose();
            }       
          

    }
    
}
