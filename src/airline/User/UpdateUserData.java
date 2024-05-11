/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airline.User;

import elements.passengersData;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author pc
 */
public class UpdateUserData extends JFrame implements ActionListener {
    
    
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
    
    
     JLabel fnamel=new JLabel("Name:");
     JLabel usernamel=new JLabel("UserName:");
    JLabel nationalityL=new JLabel("Nationality:");
    JLabel genderl=new JLabel("Gender:");
    JLabel agel=new JLabel("Age:");
    JLabel passportl=new JLabel("passport Number:");
    JLabel emaill=new JLabel("e-mail:");
    JLabel passl=new JLabel("password:");
    //-------------------------------------
    JTextField fnametx=new JTextField(name);
    JTextField usernametx=new JTextField(username2);
    JTextField nationalitytx=new JTextField(nationality);
    String[] G={"Male","Female"};
    JTextField gendertx=new JTextField(gender);
    JTextField agetx=new JTextField(String.valueOf(age));
    JTextField passporttx=new JTextField(passportnum);
    JTextField emailtx=new JTextField(email);
    JPasswordField passtx=new JPasswordField(pass);
    //---------------------------------------
    JButton reset =new JButton("RESET");
    JButton reg2 =new JButton("UPDATE");
     JButton enter =new JButton("ENTER");
    JPasswordField passstx =new JPasswordField();
    
    
    
     UpdateUserData()
    {
        this.setTitle("Register");
        this.setSize(600, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        //---
        
        
        //-----
            
        
        fnametx.setBounds(120, 50, 150, 30);
        fnamel.setBounds(60, 50, 70, 30);
        this.add(fnametx);
        this.add(fnamel);
        //---
        nationalitytx.setBounds(380, 50, 150, 30);
        nationalityL.setBounds(310,50 ,70, 30);
        this.add(nationalitytx);
        this.add(nationalityL);
        //---
        agetx.setBounds(120, 130, 150, 30);
        agel.setBounds(60, 130, 100, 30);
        this.add(agetx);
        this.add(agel);
        //---
        gendertx.setBounds(380, 130, 150, 30);
        genderl.setBounds(325,130 ,70, 30);
        this.add(gendertx);
        this.add(genderl);
        //---
        passporttx.setBounds(220, 200, 150, 30);
        passportl.setBounds(100,140 ,100, 150);
        this.add(passporttx);
        this.add(passportl);
        //---
        emailtx.setBounds(220, 260, 150, 30);
        emaill.setBounds(150, 260, 70, 30);
        this.add(emailtx);
        this.add(emaill);
        //---
        usernametx.setBounds(220, 320, 150, 30);
        usernamel.setBounds(140, 320, 70, 30);
        this.add(usernametx);
        this.add(usernamel);
        //---
        passtx.setBounds(220, 380, 150, 30);
        passl.setBounds(140, 380, 70, 30);
        this.add(passtx);
        this.add(passl);
        //---
        reg2.setBounds(200, 450, 100, 25);
        reg2.addActionListener(this);
        this.add(reg2);
        //--
        reset.setBounds(300, 450, 100, 25);
        reset.addActionListener(this);
        this.add(reset);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource()==reg2)
            {
               
               
                 email= String.valueOf(emailtx.getText());
                   pass=passtx.getText();
                   name=fnametx.getText();
                   nationality=String.valueOf(nationalitytx.getText());
                   gender= gendertx.getText();
                   username2 =usernametx.getText();
                   passportnum=passporttx.getText();
                   age=Integer.parseInt(agetx.getText());
                   
           DB.passengers_DB.PASSENGER_UPDATE_DATA(username2, pass, email, name, gender, nationality, passportnum, age);
           UserData n= new UserData();
           dispose();
            }
         if(e.getSource()==reset)
         {
             UpdateUserData userdataa= new UpdateUserData(); 
             dispose();
         }
              }
    
}
