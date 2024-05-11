/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airline.User;

import airline.Admin.AdminLogin;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author pc
 */
public class Home extends JFrame implements ActionListener{
    JButton Passenger = new JButton("Passenger");
    JButton Admin =new JButton("Admin");
    public Home(){
         this.setTitle("HOME Page");
        this.setSize(500, 340);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setLocation(700, 300);
        //welcom
        JLabel welcom =new JLabel("Welcome To JAVA Airlines");
        welcom.setBounds(70, 30, 400, 30);
        welcom.setFont(new Font("Serif", Font.BOLD, 30));
        this.add(welcom);
        //Buttons
        Passenger.setBounds(150,100, 200, 50);
        Passenger.addActionListener(this);
        this.add(Passenger);
        
        Admin.setBounds(150, 200, 200, 50);
        Admin.addActionListener(this);
        this.add(Admin);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==Passenger)
        {
            UserLogin login=new UserLogin();
             dispose();
        }
        if(e.getSource()==Admin)
        {
            AdminLogin adminlogin =new AdminLogin();
            dispose();
        }
        
                
    }
    
}
