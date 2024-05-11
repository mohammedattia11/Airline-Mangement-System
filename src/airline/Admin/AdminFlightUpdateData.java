/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airline.Admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author pc
 */
public class AdminFlightUpdateData extends JFrame implements ActionListener{
   
    JPanel pan = new JPanel();
    
   
    
    JLabel num =  new JLabel("Flight Code");
    JTextField numt = new JTextField();
    
    JLabel from =  new JLabel("From");
    JTextField fromt = new JTextField();
    
    JLabel to =  new JLabel("To");
    JTextField tot = new JTextField();
    
    JLabel price =  new JLabel("Price");
    JTextField pricet = new JTextField();
    
    JLabel date =  new JLabel("Date");
    JTextField datet = new JTextField();
    
    JLabel time =  new JLabel("Time");
    JTextField timet = new JTextField();


    
    String[] G={"true","false"};
    JTextField avilabilitytx=new JTextField();
     JLabel avilabilityl =  new JLabel("Avilability");
    
    JButton save = new JButton("Update");
    
  String Fcode;
    AdminFlightUpdateData(String fcode){
        Fcode=fcode;
        setflightdata(fcode);
        this.setTitle("Updaate Flight");
              this.setSize(350, 530);
              this.setVisible(true);
              this.setLocation(500, 250);
              this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              this.setResizable( false);
              this.setLayout(null);
              
              this.add(pan);
              pan.setLayout(null);
              pan.setBounds(0, 30, 400, 530);
              
              //pan.setBackground(Color.red);
              //labels
              pan.add(num); pan.add(numt);
              num.setBounds(25, 25, 100, 30);
              numt.setBounds(130, 30, 150, 25);
              
              pan.add(from); pan.add(fromt);
              from.setBounds(25, 70, 100, 30);
              fromt.setBounds(130, 75, 150, 25);
              
              pan.add(to); pan.add(tot);
              to.setBounds(25, 110, 100, 30);
              tot.setBounds(130, 115, 150, 25);
             
               pan.add(price); pan.add(pricet);
              price.setBounds(25, 150, 100, 30);
              pricet.setBounds(130, 155, 150, 25);
             
               pan.add(date); pan.add(datet);
              date.setBounds(25, 190, 100, 30);
              datet.setBounds(130, 195, 150, 25);
             
               pan.add(time); pan.add(timet);
              time.setBounds(25, 230, 100, 30);
              timet.setBounds(130, 235, 150, 25);
             

              
              pan.add(avilabilitytx); pan.add(avilabilityl);
              avilabilityl.setBounds(25, 320, 100, 30);
              avilabilitytx.setBounds(130, 320, 150, 25);
              
              pan.add(save);
              save.setBounds(130, 380, 100, 30);
              save.addActionListener(this);
             
              
             
    }
    
    void setflightdata(String code){
       
    numt.setText(DB.flights_DB.Admin_SHOW_FCode_FLIGHTS(code).get(0).fcode);
    fromt.setText(DB.flights_DB.Admin_SHOW_FCode_FLIGHTS(code).get(0).ffrom);
    tot.setText(DB.flights_DB.Admin_SHOW_FCode_FLIGHTS(code).get(0).tto);
    datet.setText(DB.flights_DB.Admin_SHOW_FCode_FLIGHTS(code).get(0).date);
    timet.setText(DB.flights_DB.Admin_SHOW_FCode_FLIGHTS(code).get(0).time);
    pricet.setText(String.valueOf(DB.flights_DB.Admin_SHOW_FCode_FLIGHTS(code).get(0).price));

    avilabilitytx.setText(DB.flights_DB.Admin_SHOW_FCode_FLIGHTS(code).get(0).status);
    
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource()==save)
            {
                int av =0;
                System.out.println("-->"+avilabilitytx.getText());
                if(avilabilitytx.getText().equals("true"))
                {
                    System.out.println("hi atia");
                av=1;
                }
              DB.flights_DB.ADMIN_UPDATE_FLIGHT ( Fcode,
                      fromt.getText(),
                      tot.getText(),
                     Integer.parseInt( pricet.getText()),
                      datet.getText(),
                      timet.getText(),

                      av
                      );
                      dispose();
            
            }
           
         }
}