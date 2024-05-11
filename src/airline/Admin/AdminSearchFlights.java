package airline.Admin;

import elements.flightsData;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminSearchFlights extends JFrame implements ActionListener {
    
    
     JButton b_cancle=new JButton("Cancel");
     JButton b_update=new JButton("update"); 
    
    
    JPanel pan = new JPanel();
    
    //flight data labels
     JLabel fromtx= new JLabel();
     JLabel tox= new JLabel();
     JLabel datetx= new JLabel();
     JLabel timetx= new JLabel();
     JLabel pticetx= new JLabel();
     JLabel addtiontx= new JLabel();
     JLabel avilabilitytx= new JLabel();
     
    //--menubar
    JMenuBar adminmenu = new JMenuBar();
    JMenuItem add = new JMenuItem("Add Flight");
    JMenuItem show = new JMenuItem("Show All");
    JMenuItem search = new JMenuItem("Search");      
    //search
    JLabel nflight = new JLabel("Flight Code");
    JTextField nflightt = new JTextField();
    JButton searchbtn = new JButton("Search");
    
    //
     ArrayList<flightsData> theflight;
    
    AdminSearchFlights(){
        this.setTitle("Search Flights");
              this.setSize(550, 400);
              this.setVisible(true);
              this.setLocation(500, 250);
              this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              this.setResizable( false);
              this.setLayout(null);
              
              
              //--
             
              this.add(pan);
              pan.setLayout(null);
              pan.setBounds(0, 30, 550, 350);
              
              
              
              pan.add(nflight); pan.add(nflightt);
              nflight.setBounds(80, 15, 100, 30);
              nflightt.setBounds(200, 20, 200, 25);
              
              pan.add(searchbtn);
              searchbtn.setBounds(200, 65, 100, 20);
               
              ActionListener A=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            if(e.getSource()==searchbtn)
                      {
                         getflight();
                         
                      }
            }
        };
              searchbtn.addActionListener(A);
              
              this.setJMenuBar(adminmenu);
              add.addActionListener( this);
              show.addActionListener(this);
              adminmenu.add(add);  adminmenu.add(show);   adminmenu.add(search);
              
    }
    void getflight()
    {
        String fcode = nflightt.getText();
        theflight = DB.flights_DB.Admin_SHOW_FCode_FLIGHTS(fcode);

        if (theflight.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Flight not found", "Search Result", JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder message = new StringBuilder();
            message.append("Flight Code: ").append(theflight.get(0).fcode).append("\n");
            message.append("From: ").append(theflight.get(0).ffrom).append("\n");
            message.append("To: ").append(theflight.get(0).tto).append("\n");
            message.append("Date: ").append(theflight.get(0).date).append("\n");
            message.append("Time: ").append(theflight.get(0).time).append("\n");
            message.append("Price: ").append(theflight.get(0).price).append("\n");
            message.append("Availability: ").append(theflight.get(0).status).append("\n");

            JOptionPane.showMessageDialog(this, message.toString(), "Search Result", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
            if(e.getSource()==add)
            {
                AdminAddFlight addflight= new AdminAddFlight();
                dispose();
            }
            
            if(e.getSource()==show)
            {
            AdminShowAllFlights newC=new AdminShowAllFlights();
              dispose();
            }
            
            if(e.getSource()==b_cancle){
            DB.flights_DB.ADMIN_DELETE_FLIGHT(theflight.get(0).fcode);
            }
            
            if(e.getSource()==b_update)
            {
             AdminFlightUpdateData newC= new AdminFlightUpdateData(theflight.get(0).fcode);
            }

    }
    
}