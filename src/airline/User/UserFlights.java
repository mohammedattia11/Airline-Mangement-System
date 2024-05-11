/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airline.User;
import elements.flightsData;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author pc
 */
public class UserFlights extends JFrame implements ActionListener {
    
    List<JButton> Buttons=new ArrayList<>();
    List<ActionListener> actions=new ArrayList<>();
    
    //Menu Bar
        JMenuBar accmenu=new JMenuBar();
        JMenuItem book=new JMenuItem("Book");
        JMenuItem flights=new JMenuItem("Flights");
        JMenuItem logout=new JMenuItem("logout");
        JMenuItem userinfo=new JMenuItem("my data");
    
    UserFlights(String username)
    {
        ArrayList<flightsData> Bookedflights = DB.PassengerFlight_DB.PASSENGER_SHOW_BOOKED_FLIGHTS(username);
        
        //Bookedflights= BookingFlight.test(Bookedflights);
               // Bookedflights=BookingFlight.Bookedflights2;
        System.out.println(username+" "+Bookedflights.size());
                //the frame
                this.setTitle("your booked flights");
                this.setVisible(true);
                this.setSize(500, 600);
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setLayout(null);
                this.setResizable(false);
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
                //the panel
                JPanel flightspanel=new JPanel();
                flightspanel.setBounds(0, 0, 500, 1000);
                flightspanel.setPreferredSize(new Dimension(500,1000));
                 flightspanel.setLayout(null);
             
                
                //the scroll panel
                JScrollPane scroll = new JScrollPane(flightspanel);
                 scroll.setBounds(0, 0, 485, 450);
                 this.add(scroll);
                 
                 
                //the labels
                JLabel from=new JLabel("FROM");
                from.setBounds(50, 30, 50, 20);
                flightspanel.add(from);
                
                JLabel to=new JLabel("TO");
                to.setBounds(130, 30, 50, 20);
                flightspanel.add(to);
                
                JLabel date=new JLabel("DATE");
                date.setBounds(210, 30, 50, 20);
                flightspanel.add(date);
                
                JLabel price=new JLabel("PRICE-$");
                price.setBounds(290, 30, 50, 20);
                flightspanel.add(price);
        
                //Menu Bar
                
                this.setJMenuBar(accmenu);
                int i=0;
                for(flightsData fly:Bookedflights)
                {
                  
                   // System.out.println(fly.ffrom+" "+fly.tto+" "+fly.date+" "+fly.price+" ");
                    JButton b2=new JButton("Cancel");
                   
                     String code = Bookedflights.get(i).fcode;
                     actions.add(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                 
                                  if(e.getSource()==b2){
                                     
                                      DB.PassengerFlight_DB.PASSENGER_CANCLE_FLIGHT(username, code);
                                      System.out.println("yes");
                                     UserFlights refresh= new UserFlights(username);
                                     dispose();
                                  }
                              }
                          });
                      Buttons.add(b2);
                     Buttons.get(i).addActionListener(actions.get(i));
                   
                        
                    b2.setBounds(380, 30+((i+1)*70), 73, 20);
                    flightspanel.add(b2);

                    JLabel From=new JLabel(fly.ffrom);
                    From.setBounds(50, 30+((i+1)*70), 100, 20);
                    flightspanel.add(From);
                    
                    JLabel To=new JLabel(fly.tto);
                    To.setBounds(130, 30+((i+1)*70), 100, 20);
                    flightspanel.add(To);
                
                    JLabel Date=new JLabel(fly.date);
                    Date.setBounds(210, 30+((i+1)*70), 100, 20);
                    flightspanel.add(Date);
                    
                    JLabel Price=new JLabel(String.valueOf(fly.price));
                    Price.setBounds(300, 30+((i+1)*70), 100, 20);
                    flightspanel.add(Price);
                    System.out.println(fly.ffrom+" "+fly.tto+" "+fly.date+" "+fly.price+" ");
                    i++;
                 
                }
                
                
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
            
      if(e.getSource()==book)
            {
               Account Account2= new Account(UserLogin.UserName);
                dispose();
            }
            if(e.getSource()==userinfo)
            {
                UserData user=new UserData();
                 dispose();
            }
            if(e.getSource()==logout)
            {
                UserLogin user=new UserLogin();
                 dispose();
            }       

    }
    
}

