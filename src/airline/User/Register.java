package airline.User;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
public class Register extends JFrame implements ActionListener {
    JLabel fnamel=new JLabel("Name");
     JLabel usernamel=new JLabel("Username");
    JLabel nationalityL=new JLabel("Nationality");
    JLabel genderl=new JLabel("Gender");
    JLabel agel=new JLabel("Age");
    JLabel passportl=new JLabel("passport n.");
    JLabel emaill=new JLabel("E-mail");
    JLabel passl=new JLabel("password");
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
    JButton reg =new JButton("register");
    
    JLabel lab = new JLabel("Sign Up!");
    
     JButton Back = new JButton("");
    
     public Register( ) {
        this.setTitle("Create a new account");
        this.setSize(690, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setLocation(500, 220);
        
        //--
        this.add(lab);
        lab.setBounds(270, 10, 150, 40);
        lab.setFont(new Font("Serif", Font.PLAIN, 30));
        
        //---
        fnametx.setBounds(150, 80, 150, 30);
        fnamel.setBounds(40, 77, 80, 30);
        this.add(fnametx);
        this.add(fnamel);
        fnamel.setFont(new Font("Serif", Font.BOLD, 25));
        //---
        nationalitytx.setBounds(470, 80, 150, 30);
        nationalityL.setBounds(330,77 ,120, 30);
        this.add(nationalitytx);
        this.add(nationalityL);
        nationalityL.setFont(new Font("Serif", Font.BOLD, 25));
        //---
        agetx.setBounds(150, 130, 150, 30);
        agel.setBounds(55, 127, 100, 30);
        this.add(agetx);
        this.add(agel);
        agel.setFont(new Font("Serif", Font.BOLD, 25));
        //---
        gendertx.setBounds(470, 130, 150, 30);
        genderl.setBounds(345,130 ,100, 30);
        this.add(gendertx);
        this.add(genderl);
        genderl.setFont(new Font("Serif", Font.BOLD, 25));
        //---
        passporttx.setBounds(150, 180, 150, 30);
        passportl.setBounds(45,177 ,100, 30);
        this.add(passporttx);
        this.add(passportl);
        passportl.setFont(new Font("Serif", Font.BOLD, 20));
        //---
        emailtx.setBounds(470, 180, 150, 30);
        emaill.setBounds(345, 175, 100, 30);
        this.add(emailtx);
        this.add(emaill);
        emaill.setFont(new Font("Serif", Font.BOLD, 25));
        //---
        usernametx.setBounds(150, 230, 150, 30);
        usernamel.setBounds(45, 225, 100, 30);
        this.add(usernametx);
        this.add(usernamel);
        usernamel.setFont(new Font("Serif", Font.BOLD, 20));
        //---
        passtx.setBounds(470, 230, 150, 30);
        passl.setBounds(345, 225, 100, 30);
        this.add(passtx);
        this.add(passl);
        passl.setFont(new Font("Serif", Font.BOLD, 20));
        //---
        reg.setBounds(270, 300, 100, 30);
        reg.addActionListener(this);
        this.add(reg);
        //--
        
        this.add(Back);
        Back.setBounds(0, 0, 30, 30);
        Back.addActionListener(this);
        Back.setBackground(Color.RED);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(e.getSource()==Back)
      {
      UserLogin m= new UserLogin();
      dispose();
      }
        
        if(e.getSource()==reg)
       {
           String email= emailtx.getText(),
                   pass=String.valueOf(passtx.getPassword()),
                   name=fnametx.getText(),
                   nationality=nationalitytx.getText(),
                   gender= String.valueOf(gendertx.getSelectedItem()),
                   username =usernametx.getText(),
                   passportnum=passporttx.getText();
           int age=Integer.parseInt(agetx.getText());
           DB.passengers_DB.PASSENGER_ADD_DATA(username, pass, email, name, gender, nationality, passportnum, age);
           
           UserLogin back=new UserLogin();
           dispose();
       }
    }
}
