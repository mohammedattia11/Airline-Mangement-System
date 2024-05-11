package airline.Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminAddFlight extends JFrame implements ActionListener{
   
    JPanel pan = new JPanel();
    
    JMenuBar adminmenu = new JMenuBar();
    JMenuItem add = new JMenuItem("Add Flight");
    JMenuItem show = new JMenuItem("Show All");
    JMenuItem search = new JMenuItem("Search");
    
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
    JComboBox avilabilitytx=new JComboBox(G);
     JLabel avilabilityl =  new JLabel("Avilability");
    
    JButton save = new JButton("Add");
    
  
    AdminAddFlight(){
        this.setTitle("Add Flight");
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
             
              //menu
              this.setJMenuBar(adminmenu);
              search.addActionListener(this);
              show.addActionListener(this);
              adminmenu.add(add);  adminmenu.add(show);   adminmenu.add(search);
              //adminmenu.setLayout(null);
             
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource()==save)
            {  int av=0;
                System.out.println(avilabilitytx.getSelectedItem());
                if(avilabilitytx.getSelectedItem() == "true")
                {
                    av=1;
                }
            DB.flights_DB.ADMIN_ADD_FLIGHT(numt.getText(), fromt.getText(), tot.getText(), Integer.parseInt(pricet.getText()) , datet.getText(), timet.getText(), av);
            
            }
            if(e.getSource()==search)
            {
                AdminSearchFlights searchh= new AdminSearchFlights();
                  dispose();
            }
            if(e.getSource()==show)
            {
            AdminShowAllFlights newC=new AdminShowAllFlights();
              dispose();
            }
         }
}