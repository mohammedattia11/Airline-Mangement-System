package airline.Admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AdminMang extends JFrame implements ActionListener{
    JPanel pan =  new JPanel();
    JLabel l1 = new JLabel("Welcome in Adminstration Section");
    JButton flight =    new JButton("Manage Flights");
    //JButton passenger =    new JButton("Manage Passenger");
            
    AdminMang(){
            this.setTitle("Adminstration");
              this.setSize(500, 300);
              this.setVisible(true);
              this.setLocation(500, 250);
              this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              this.setResizable( false);
              this.setLayout(null);
              
            this.add(pan);
            pan.setLayout(null);
            //pan.setBackground(Color.);
            pan.setBounds(0, 0, 500, 300);
            
            pan.add(l1);
            l1.setBounds(150, 1, 250, 70);
            
            pan.add(flight);
           // pan.add(passenger);
            
            flight.setBounds(150, 100, 200, 40);
            //passenger.setBounds(160, 170, 150, 40);
            
            flight.addActionListener((ActionListener) this);

            
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource()==flight)
            {
                AdminAddFlight n=new AdminAddFlight();
                   dispose();
            }


    }
    
}