/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airline.User;
import elements.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

/**
 *
 * @author pc
 */
public class BookingFlight extends JFrame implements ActionListener {
    
    
   
    
   ArrayList<flightsData>f;
       // m.PASSENGER_SHOW_FromTO_FLIGHTS("m","m");
    
      JButton book=new JButton("Book"); 
      
      List<flightsData> Bookedflights = new ArrayList<>();
      List<JRadioButton> buttons = new ArrayList<>();
      List<ActionListener> actions = new ArrayList<>();
     public static List<flightsData> Bookedflights2 = new ArrayList<>();
  
       
    BookingFlight( ArrayList<flightsData> result)
    {                   f=result;
        
               //--frame 
               this.setTitle("Booking Page");
               this.setSize(500, 600);
               this.setVisible(true);
               this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               this.setResizable( false);
               this.setLayout(null); 
              //---the panel flight
                 JPanel flightspanel = new JPanel();
                 //flightspanel.setBounds(0, 0, 500, 200);          
                 flightspanel.setPreferredSize(new Dimension(300, 1000));
                 flightspanel.setLayout(null);
                //--the scroll panel
                JScrollPane scroll = new JScrollPane(flightspanel);
                scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                scroll.setBounds(0, 0, 485, 450);
                 this.add(scroll);
                //---
                  book.setBounds(225, 500, 100, 20);
                  book.addActionListener(this);
                  this.add(book);
              
                // labels
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
                
                //---
               
               
              for(int i=0,x=0;i<result.size();i++)
              { 
                  
                     
                      // System.out.println(result.get(i). +" "+ ourflights[i].to);
                        JRadioButton b2=new JRadioButton();
                        buttons.add(b2);
                        b2.setBounds(380, 30+((x+1)*70), 15, 15);
                        flightspanel.add(b2);
                       
                       
                                      
                        actions.add(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                 
                              }
                          });
                        buttons.get(x).addActionListener(actions.get(x));

                    JLabel From=new JLabel(result.get(i).ffrom);
                    From.setBounds(50, 30+((x+1)*70), 100, 20);
                    flightspanel.add(From);
                    JLabel To=new JLabel(result.get(i).tto);
                    To.setBounds(130, 30+((x+1)*70), 100, 20);
                    flightspanel.add(To);
                    JLabel Date=new JLabel(result.get(i).date);
                    Date.setBounds(210, 30+((x+1)*70), 100, 20);
                    flightspanel.add(Date);
                    
                    JLabel Price=new JLabel(String.valueOf(result.get(i).price));
                    Price.setBounds(300, 30+((x+1)*70), 50, 20);
                    flightspanel.add(Price);
                    x++;

                    }
                  
              }
              
              
              
        
    
  
 
    
 

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==book)
        {
            for(int i=0;i<buttons.size();i++)
            {
                if(buttons.get(i).isSelected())
                {
                   System.out.println("from "+f.get(i).ffrom+" to "+f.get(i).tto+" at date "+f.get(i).date+" the price "+f.get(i).price+"$");
                        
                       Bookedflights2.add(f.get(i));
                       DB.PassengerFlight_DB.PASSENGER_BOOK_FLIGHT(UserLogin.UserName, f.get(i).fcode);
                       UserFlights userflights= new UserFlights(UserLogin.UserName);
                       
                        
                }
            }
        }

    }
    
}
