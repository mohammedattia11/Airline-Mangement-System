/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airline.User;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Account extends JFrame implements ActionListener {
      String[] s2={"cairo","london","alex","dubai","makkah","luxor","aswan"};
    JButton search=new JButton("Search");
     JComboBox tocountry =new JComboBox(s2);
   
     JComboBox fromcountry =new JComboBox(s2);
     
     JLabel lab = new JLabel("Book Ur Flight Now");
     
     //Menu Bar
        JMenuBar accmenu=new JMenuBar();
        JMenuItem book=new JMenuItem("Book");
        JMenuItem flights=new JMenuItem("Flights");
        JMenuItem logout=new JMenuItem("Logout");
        JMenuItem userinfo=new JMenuItem("Profile");
  
    Account(String username)
    {
        //the frame
        this.setVisible(true);
        this.setSize(350,350);
        this.setTitle("Booking");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocation(700, 300);
        //----
        
        this.add(lab);
        lab.setBounds(35, 25, 300, 40);
        lab.setFont(new Font("Serif", Font.BOLD, 30));
        
        //**
        
        flights.addActionListener(this);
        userinfo.addActionListener(this);
        book.addActionListener(this);
        logout.addActionListener(this);
        logout.setBackground(Color.RED);
        accmenu.add(logout);
        accmenu.add(book);
        accmenu.add(flights);
        accmenu.add(userinfo);
        this.setJMenuBar(accmenu);
        accmenu.setBounds(0, 0, 350, 30);
        //the from ComboBox
        JLabel from=new JLabel("From");
        from.setFont(new Font("Serif", Font.ITALIC, 25));
       
        fromcountry.setBounds(100, 100, 150, 30);
        from.setBounds(20, 90, 70, 40);
        this.add(fromcountry);
        this.add(from);
        
        //the to ComboBox
         JLabel to=new JLabel("To");
         to.setFont(new Font("Serif", Font.ITALIC, 25));
        tocountry.setBounds(100, 160, 150, 30);
        to.setBounds(20, 150, 70, 40);
        this.add(tocountry);
        this.add(to);
        
        //the search Button
       
        search.setBounds(100, 230,100, 30);
        this.add(search);
        search.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

            if(e.getSource()==search)
            {
                String From= (String)fromcountry. getSelectedItem(); 
                String To= (String)tocountry. getSelectedItem();
                BookingFlight newBookingFlight= new BookingFlight(DB.flights_DB.PASSENGER_SHOW_FromTO_FLIGHTS(From, To));
            }
            else if(e.getSource()==flights)
            {
               UserFlights userflightss= new UserFlights(UserLogin.UserName);
                dispose();
            }
            else if(e.getSource()==userinfo)
            {
                UserData user=new UserData();
                 dispose();
            }
           else if(e.getSource()==logout)
            {
                UserLogin user=new UserLogin();
                 dispose();
            }

    }

}
