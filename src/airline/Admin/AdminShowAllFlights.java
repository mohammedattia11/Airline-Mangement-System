/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airline.Admin;

import airline.User.Home;
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
public class AdminShowAllFlights extends JFrame implements ActionListener {
    
    List<JButton> Buttons_cancle=new ArrayList<>();
    List<ActionListener> actions_cancle=new ArrayList<>();
    List<JButton> Buttons_update=new ArrayList<>();
    List<ActionListener> actions_update=new ArrayList<>();
    
    
     JPanel panel = new JPanel();
     
     JLabel from =new JLabel("From");
     JLabel to =new JLabel("To");
     JLabel date =new JLabel("Date:");
     JLabel time =new JLabel("time");
     JLabel price =new JLabel("Price");
     JLabel avilabilityl= new JLabel("Avilability");
            
     //--menubar
    JMenuBar adminmenu = new JMenuBar();
    JMenuItem add = new JMenuItem("Add Flight");
    JMenuItem show = new JMenuItem("Show All");
    JMenuItem search = new JMenuItem("Search");   
    JMenuItem homee = new JMenuItem("Home");   
       
        
     ArrayList<flightsData> ALLFlights= DB.flights_DB.ADMIN_SHOW_ALL_FLIGHTS();
   
    public AdminShowAllFlights() {
    
        this.setTitle("UPCOMMING");
        this.setSize(920, 600);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        ///////////////////menu///////////////
       
        
        
        panel.setPreferredSize(new Dimension(9000,1500));
         this.add(panel);
         panel.setLayout(null);
         panel.setPreferredSize(new Dimension(900,1500));
         
          this.setJMenuBar(adminmenu);
              add.addActionListener( this);
              homee.addActionListener(this);
              add.addActionListener(this);
              show.addActionListener(this);
              search.addActionListener(this);
               adminmenu.add(homee);
              adminmenu.add(add);  adminmenu.add(show);   adminmenu.add(search);
         
         
         panel.add(from);panel.add(to);panel.add(date);panel.add(time);panel.add(price);panel.add(avilabilityl);
         from.setBounds(50, 50, 100, 25);
         to.setBounds(150, 50, 100, 25);
         date.setBounds(250, 50, 100, 25);
         time.setBounds(350, 50, 100, 25);
         price.setBounds(450, 50, 100, 25);
         avilabilityl.setBounds(550, 50, 100, 25);
         JScrollPane scroll= new JScrollPane(panel);
         scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
         scroll.setBounds(0, 0, 900, 600);
         this.add(scroll);
              
                System.out.println(ALLFlights.size());
                int i=0;
                for(flightsData fly:ALLFlights)
                {   String flightCode= ALLFlights.get(i).fcode;
                    System.out.println(i);
                    System.out.println(fly.ffrom+" "+fly.tto+" "+fly.date+" "+fly.price+" ");
                    JButton b_cancle=new JButton("Cancel");
                    JButton b_update=new JButton("update");
                     String code = ALLFlights.get(i).fcode;
                     actions_cancle.add(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                 
                                  if(e.getSource()==b_cancle){
                                     
                                     DB.flights_DB.ADMIN_DELETE_FLIGHT(flightCode);
                                      System.out.println("cancle");
                                   
                                     
                                  }
                              }
                          });
                     actions_update.add(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                 
                                  if(e.getSource()==b_update){
                                     AdminFlightUpdateData newC= new AdminFlightUpdateData(flightCode);
                                     
                                      System.out.println("update");
                                    
                                     
                                  }
                              }
                          });
                      Buttons_cancle.add(b_cancle);
                     Buttons_cancle.get(i).addActionListener(actions_cancle.get(i));
                     
                      Buttons_update.add(b_update);
                       Buttons_update.get(i).addActionListener(actions_update.get(i));
                   
                        
                    b_update.setBounds(810, 30+((i+1)*70), 73, 20);
                    panel.add(b_update);
                    
                     b_cancle.setBounds(730, 30+((i+1)*70), 73, 20);
                    panel.add(b_cancle);
                    
                    JLabel From=new JLabel(fly.ffrom);
                    From.setBounds(50, 30+((i+1)*70), 100, 20);
                    panel.add(From);
                    
                    JLabel To=new JLabel(fly.tto);
                    To.setBounds(130, 30+((i+1)*70), 100, 20);
                    panel.add(To);
                
                    JLabel Date=new JLabel(fly.date);
                    Date.setBounds(240, 30+((i+1)*70), 100, 20);
                    panel.add(Date);
                    
                    JLabel Time=new JLabel(String.valueOf(fly.time));
                    Time.setBounds(350, 30+((i+1)*70), 100, 20);
                    panel.add(Time);
                    
                      JLabel Price=new JLabel(String.valueOf(fly.price));
                    Price.setBounds(450, 30+((i+1)*70), 100, 20);
                    panel.add(Price);
                    JLabel av=new JLabel(String.valueOf(fly.status));
                    av.setBounds(660, 30+((i+1)*70), 100, 20);
                    panel.add(av);
                  //  System.out.println(fly.ffrom+" "+fly.tto+" "+fly.date+" "+fly.price+" ");
                    
                    i++;
                    
                 
                }

   }
    
   

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==add)
        {
            AdminAddFlight addflightt= new AdminAddFlight();
            dispose();
        }
        if(e.getSource()==homee)
        {
        Home newhomme = new Home();
        dispose();
        }
        if(e.getSource()==show)
        {
        AdminShowAllFlights newshow = new AdminShowAllFlights();
         dispose();
        }
        if(e.getSource()==search)
        {
        
        AdminSearchFlights newsearch=new AdminSearchFlights();
         dispose();
        }
        

    }
}